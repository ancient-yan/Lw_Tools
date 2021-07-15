package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.util.Log;

import com.gwchina.child.mdm.DeviceService;
import com.gwchina.child.mdm.core.glDeviceApplicationManagerImpl;

import java.util.List;

public class lwDeviceApplicationManagerImpl extends glDeviceApplicationManagerImpl {
    MiaMdmPolicyManager mpm;

    public lwDeviceApplicationManagerImpl(MiaMdmPolicyManager mpm) {
        this.mpm = mpm;
    }

    @Override
    public void killApplicationProcess(String packageName) {
        Log.i(TAG, "killApplicationProcess : " + packageName);

        try {
            mpm.killApp(packageName);
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
