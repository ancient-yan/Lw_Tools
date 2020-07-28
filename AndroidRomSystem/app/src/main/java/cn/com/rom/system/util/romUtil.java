package cn.com.rom.system.util;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.PersistableBundle;
import android.util.Log;

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
}
