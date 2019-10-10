package cn.com.rom.system.service;

import android.app.ActivityManager;
import android.app.IhaierMDM;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;

import java.util.List;

import cn.com.rom.system.util.dbUtil;
import cn.com.rom.system.util.romUtil;

public class haierMDMService extends Service {
    private static final String TAG = "rom_system";
    private Binder mBinder = null;

    @Override
    public void onCreate() {
        Log.d(TAG, "haierMDMService.onCreate");

        mBinder = new MyBinder();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "haierMDMService.onBind");

        return mBinder;
    }

    private class MyBinder extends IhaierMDM.Stub {
        private MyBinder() {
        }

        public void setAdbDisabled(boolean disabled) throws android.os.RemoteException {
            romUtil.SetAdbEnable(haierMDMService.this, !disabled);
        }

        public void addInstallPackageWhiteList(java.util.List<java.lang.String> packageNames) throws android.os.RemoteException {
            dbUtil.clearInstallWhiteApp(haierMDMService.this);

            for (String packageName : packageNames)
                dbUtil.addInstallWhiteApp(haierMDMService.this, packageName);
        }

        public java.util.List<java.lang.String> getInstallPackageWhiteList() throws android.os.RemoteException {
            return dbUtil.getInstallWhiteApp(haierMDMService.this);
        }

        public void installPackage(java.lang.String packagePath) throws android.os.RemoteException {
            romUtil.install28(haierMDMService.this, packagePath);
        }

        public void uninstallPackage(java.lang.String packageName, boolean keepData) throws android.os.RemoteException {
            romUtil.deletePackage(haierMDMService.this, packageName, null, keepData);
        }

        public boolean SetAppSuspend(List<String> strPackageNames, boolean bSuspend) throws android.os.RemoteException {
            return romUtil.SetAppSuspendDpm(haierMDMService.this, strPackageNames, bSuspend);
        }

        public void setCameraDisabled(boolean bDisable) throws android.os.RemoteException {
            romUtil.setCameraDisabled(haierMDMService.this, bDisable);
        }

        public void setStatusBarExpandPanelDisabled(boolean disabled) throws android.os.RemoteException {
            romUtil.setStatusBarDisabledDpm(haierMDMService.this, disabled);
        }

        public void setHomeButtonDisabled(boolean disabled) throws android.os.RemoteException {
            SystemProperties.set("persist.sys.disablehomekey", disabled ? "1" : "0");
        }

        public void setBackButtonDisabled(boolean disabled) throws android.os.RemoteException {
            SystemProperties.set("persist.sys.disablebackkey", disabled ? "1" : "0");
        }

        public void setTaskButtonDisabled(boolean disabled) throws android.os.RemoteException {
            SystemProperties.set("persist.sys.disableappkey", disabled ? "1" : "0");
        }

        public void setPowerButtonDisabled(boolean disabled) throws android.os.RemoteException {
            SystemProperties.set("persist.sys.disablepowerkey", disabled ? "1" : "0");
        }

        public void setVolumeButtonDisabled(boolean disabled) throws android.os.RemoteException {
            SystemProperties.set("persist.sys.disablevolumekey", disabled ? "1" : "0");
        }

        public void setBluetoothDisabled(boolean bDisable) throws android.os.RemoteException {
            SystemProperties.set("persist.sys.disablebluetooth", bDisable ? "1" : "0");
        }

        public void setSdcardDisabled(boolean bDisable) throws android.os.RemoteException {
            SystemProperties.set("persist.sys.disablesdcard", bDisable ? "1" : "0");
        }

        public ComponentName getTopActivity() throws RemoteException {
            Log.d(TAG, "MyBinder.getTopActivity");

            try {
                List<ActivityManager.RunningTaskInfo> list = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE)).getRunningTasks(1);
                if (list != null && list.size() > 0) {
                    ActivityManager.RunningTaskInfo info = (ActivityManager.RunningTaskInfo) list.get(0);
                    if (info != null) {
                        Log.d(TAG, "info.topActivity : " + info.topActivity.toString());
                        return info.topActivity;
                    }
                }
            } catch (Throwable e) {
                Log.e(TAG, "getTopActivity : " + e);
            }
            return null;
        }

        public void setActiveAdmin(ComponentName componentName, boolean refreshing) throws RemoteException {
            Log.d(TAG, "MyBinder.setActiveAdmin : " + componentName);

            romUtil.setActiveAdmin(haierMDMService.this, componentName, refreshing);
        }

        public void killApplicationProcess(String packageName) throws RemoteException {
            Log.d(TAG, "MyBinder.killApplicationProcess : " + packageName);

            romUtil.forceStopPackage(haierMDMService.this, packageName);
        }

        public void captureScreen(String dir, String filename) throws RemoteException {
            romUtil.captureScreen(dir, filename);
        }
    }
}
