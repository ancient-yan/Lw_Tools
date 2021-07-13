package com.gwchina.child.mdm.core.lw;

import android.util.Log;

import com.gwchina.child.mdm.DeviceService;
import com.gwchina.child.mdm.core.glDeviceApplicationManagerImpl;

import java.util.List;

public class lwDeviceApplicationManagerImpl extends glDeviceApplicationManagerImpl {
    @Override
    public void addPersistentApp(List<String> packageNames) {
        Log.i(TAG, "addPersistentApp");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "addPersistentApp : " + e);
        }
    }

    @Override
    public void removePersistentApp(List<String> packageNames) {
        Log.i(TAG, "removePersistentApp");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "removePersistentApp : " + e);
        }
    }

    @Override
    public List<String> getPersistentApp() {
        Log.i(TAG, "getPersistentApp");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "getPersistentApp : " + e);
        }

        return super.getPersistentApp();
    }

    @Override
    public void killApplicationProcess(String packageName) {
        Log.i(TAG, "killApplicationProcess : " + packageName);

        try {
            DeviceService.getmBinder().forceStopPackage(packageName);
        } catch (Throwable e) {
            Log.e(TAG, "killApplicationProcess : " + e);
        }
    }

    @Override
    public void addDisallowedRunningApp(List<String> packageNames) {
        Log.i(TAG, "addDisallowedRunningApp : " + packageNames);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "addDisallowedRunningApp : " + e);
        }
    }

    @Override
    public void removeDisallowedRunningApp(List<String> packageNames) {
        Log.i(TAG, "removeDisallowedRunningApp : " + packageNames);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "removeDisallowedRunningApp : " + e);
        }
    }

    @Override
    public List<String> getDisallowedRunningApp() {
        Log.i(TAG, "getDisallowedRunningApp");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "getDisallowedRunningApp : " + e);
        }

        return super.getDisallowedRunningApp();
    }
}
