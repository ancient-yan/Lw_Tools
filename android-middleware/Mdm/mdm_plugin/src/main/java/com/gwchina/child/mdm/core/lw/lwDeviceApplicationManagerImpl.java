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
            DeviceService.getmBinder2().addPersistentApp(packageNames);
            DeviceService.getmBinder2().setSuperWhiteListForHwSystemManger(packageNames);
        } catch (Throwable e) {
            Log.e(TAG, "addPersistentApp : " + e);
        }
    }

    @Override
    public void removePersistentApp(List<String> packageNames) {
        Log.i(TAG, "removePersistentApp");

        try {
            DeviceService.getmBinder2().removePersistentApp(packageNames);
            DeviceService.getmBinder2().removeSuperWhiteListForHwSystemManger(packageNames);
        } catch (Throwable e) {
            Log.e(TAG, "removePersistentApp : " + e);
        }
    }

    @Override
    public List<String> getPersistentApp() {
        Log.i(TAG, "getPersistentApp");

        try {
            List<String> stringList = DeviceService.getmBinder2().getSuperWhiteListForHwSystemManger();
            Log.i(TAG, "stringList : " + stringList);

            return DeviceService.getmBinder2().getPersistentApp();
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
            DeviceService.getmBinder2().addDisallowedRunningApp(packageNames);
        } catch (Throwable e) {
            Log.e(TAG, "addDisallowedRunningApp : " + e);
        }
    }

    @Override
    public void removeDisallowedRunningApp(List<String> packageNames) {
        Log.i(TAG, "removeDisallowedRunningApp : " + packageNames);

        try {
            DeviceService.getmBinder2().removeDisallowedRunningApp(packageNames);
        } catch (Throwable e) {
            Log.e(TAG, "removeDisallowedRunningApp : " + e);
        }
    }

    @Override
    public List<String> getDisallowedRunningApp() {
        Log.i(TAG, "getDisallowedRunningApp");

        try {
            return DeviceService.getmBinder2().getDisallowedRunningApp();
        } catch (Throwable e) {
            Log.e(TAG, "getDisallowedRunningApp : " + e);
        }

        return super.getDisallowedRunningApp();
    }
}
