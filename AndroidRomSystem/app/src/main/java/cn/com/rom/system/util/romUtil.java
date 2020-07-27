package cn.com.rom.system.util;

import android.app.PendingIntent;
import android.app.StatusBarManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.provider.Settings;
import android.util.Log;

import com.android.internal.statusbar.IStatusBarService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class romUtil {
    private static final String TAG = "rom_system";

    static public void SetAdbEnable(Context context, boolean bEnable) {
        Settings.Global.putInt(context.getContentResolver(), Settings.Global.ADB_ENABLED, bEnable ? 1 : 0);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static public void install28(Context context, String apkFilePath) {
        Log.d(TAG, "apkFilePath : " + apkFilePath);

        File apkFile = new File(apkFilePath);
        PackageInstaller packageInstaller = context.getPackageManager().getPackageInstaller();
        PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL);
        sessionParams.setSize(apkFile.length());
        int sessionId = createSession(packageInstaller, sessionParams);
        if (sessionId != -1) {
            boolean copySuccess = copyInstallFile(packageInstaller, sessionId, apkFilePath);
            if (copySuccess) {
                execInstallCommand(context, packageInstaller, sessionId);
            }
        }
    }

    static private int createSession(PackageInstaller packageInstaller, PackageInstaller.SessionParams sessionParams) {
        int sessionId = -1;
        try {
            sessionId = packageInstaller.createSession(sessionParams);
        } catch (IOException e) {
            Log.e(TAG, "createSession.IOException : " + e);
        }

        return sessionId;
    }

    static private boolean copyInstallFile(PackageInstaller packageInstaller, int sessionId, String apkFilePath) {
        InputStream in;
        OutputStream out;
        PackageInstaller.Session session;
        boolean success = false;
        try {
            File apkFile = new File(apkFilePath);
            session = packageInstaller.openSession(sessionId);
            out = session.openWrite("base.apk", 0, apkFile.length());
            in = new FileInputStream(apkFile);
            int total = 0, c;
            byte[] buffer = new byte[65536];
            while ((c = in.read(buffer)) != -1) {
                total += c;
                out.write(buffer, 0, c);
            }
            session.fsync(out);
            Log.i(TAG, "streamed " + total + " bytes");
            success = true;
            if (null != out) out.close();
            if (null != in) in.close();
            if (null != session) session.close();
        } catch (IOException e) {
            Log.e(TAG, "copyInstallFile.IOException : " + e);
        }

        return success;
    }

    static private void execInstallCommand(Context context, PackageInstaller packageInstaller, int sessionId) {
        PackageInstaller.Session session = null;
        try {
            session = packageInstaller.openSession(sessionId);
            Intent intent = new Intent(context, InstallResultReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            session.commit(pendingIntent.getIntentSender());
        } catch (IOException e) {
            Log.e(TAG, "execInstallCommand.IOException : " + e);
        }

        if (null != session) session.close();
    }

    public class InstallResultReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                final int status = intent.getIntExtra(PackageInstaller.EXTRA_STATUS, PackageInstaller.STATUS_FAILURE);
                if (status == PackageInstaller.STATUS_SUCCESS) {
                } else {
                    Log.e(TAG, intent.getStringExtra(PackageInstaller.EXTRA_STATUS_MESSAGE));
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final int DELETE_KEEP_DATA = 0x00000001;

    public static boolean deletePackage(Context context, String packageName, IPackageDeleteObserver observer, boolean keepData) {
        try {
            Method method = PackageManager.class.getDeclaredMethod("deletePackage", String.class,
                    IPackageDeleteObserver.class, int.class);
            method.setAccessible(true);
            method.invoke(context.getPackageManager(), packageName, observer, keepData ? DELETE_KEEP_DATA : 0);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "deletePackage.Exception : " + e);
        }
        return false;
    }

    public static boolean SetAppSuspend(Context context, String strPackageName, boolean bSuspend) {
        try {
            if (strPackageName.equals(context.getPackageName())) return false;

            PackageManager packageManager = context.getPackageManager();
            Method method = PackageManager.class.getDeclaredMethod("setPackagesSuspendedAsUser", new Class[]{String[].class, Boolean.TYPE, Integer.TYPE});
            method.setAccessible(true);
            try {
                String ret_strPackageName[] = (String[]) method.invoke(packageManager, new Object[]{new String[]{strPackageName}, bSuspend, Integer.valueOf(0)});
                if (Arrays.asList(ret_strPackageName).contains(strPackageName))
                    return false;
                else
                    return true;
            } catch (IllegalAccessException e) {
                Log.e(TAG, "SetAppSuspend.IllegalAccessException : " + e);
            } catch (InvocationTargetException e) {
                Log.e(TAG, "SetAppSuspend.InvocationTargetException : " + e);
            }
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "SetAppSuspend.NoSuchMethodException : " + e);
        } catch (Exception e) {
            Log.e(TAG, "SetAppSuspend.Exception : " + e);
        }

        return false;
    }

    public static boolean SetAppSuspend28(Context context, String strPackageName, boolean bSuspend) {
        try {
            if (strPackageName.equals(context.getPackageName())) return false;

            PackageManager packageManager = context.getPackageManager();
            Method method = PackageManager.class.getDeclaredMethod("setPackagesSuspended",
                    new Class[]{String[].class, Boolean.TYPE, PersistableBundle.class, PersistableBundle.class, String.class});
            method.setAccessible(true);
            try {
                String ret_strPackageName[] = (String[]) method.invoke(packageManager, new Object[]{new String[]{strPackageName}, bSuspend, null, null, ""});
                if (Arrays.asList(ret_strPackageName).contains(strPackageName))
                    return false;
                else
                    return true;
            } catch (IllegalAccessException e) {
                Log.e(TAG, "SetAppSuspend.IllegalAccessException : " + e);
            } catch (InvocationTargetException e) {
                Log.e(TAG, "SetAppSuspend.InvocationTargetException : " + e);
            }
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "SetAppSuspend.NoSuchMethodException : " + e);
        } catch (Exception e) {
            Log.e(TAG, "SetAppSuspend.Exception : " + e);
        }

        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final int STATUS_BAR_DISABLE_MASK =
            StatusBarManager.DISABLE_EXPAND |
                    StatusBarManager.DISABLE_NOTIFICATION_ICONS |
                    StatusBarManager.DISABLE_NOTIFICATION_ALERTS |
                    StatusBarManager.DISABLE_SEARCH;

    private static final int STATUS_BAR_DISABLE2_MASK =
            StatusBarManager.DISABLE2_QUICK_SETTINGS;

    public static void setStatusBarDisabled28(Context context, boolean disabled) {
        if (null == context) return;
        final Binder mToken = new Binder();

        IStatusBarService statusBarService = IStatusBarService.Stub.asInterface(
                ServiceManager.checkService(Context.STATUS_BAR_SERVICE));

        if (statusBarService != null) {
            int flags1 = disabled ? STATUS_BAR_DISABLE_MASK : StatusBarManager.DISABLE_NONE;
            int flags2 = disabled ? STATUS_BAR_DISABLE2_MASK : StatusBarManager.DISABLE2_NONE;
            try {
                statusBarService.disableForUser(flags1, mToken, context.getPackageName(), 0);
                statusBarService.disable2ForUser(flags2, mToken, context.getPackageName(), 0);
            } catch (RemoteException e) {
                Log.e(TAG, "setStatusBarDisabled28.RemoteException : " + e);
            }
        }
    }
}
