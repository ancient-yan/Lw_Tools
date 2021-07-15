package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.gwchina.child.mdm.DeviceService;
import com.gwchina.child.mdm.core.glDeviceApplicationManagerImpl;

import java.util.ArrayList;
import java.util.List;

public class lwDeviceApplicationManagerImpl extends glDeviceApplicationManagerImpl {
    MiaMdmPolicyManager mpm;
    Context context;

    public lwDeviceApplicationManagerImpl(MiaMdmPolicyManager mpm, Context context) {
        this.mpm = mpm;
        this.context = context;
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
            for (String packageName : packageNames)
                DeviceService.getmBinder().setApplicationEnabled(packageName, null, false);
        } catch (Throwable e) {
            Log.e(TAG, "addDisallowedRunningApp : " + e);
        }
    }

    @Override
    public void removeDisallowedRunningApp(List<String> packageNames) {
        Log.i(TAG, "removeDisallowedRunningApp : " + packageNames);

        try {
            for (String packageName : packageNames)
                DeviceService.getmBinder().setApplicationEnabled(packageName, null, true);
        } catch (Throwable e) {
            Log.e(TAG, "removeDisallowedRunningApp : " + e);
        }
    }

    @Override
    public List<String> getDisallowedRunningApp() {
        Log.i(TAG, "getDisallowedRunningApp");

        try {
            return getDisableApps(context);
        } catch (Throwable e) {
            Log.e(TAG, "getDisallowedRunningApp : " + e);
        }

        return super.getDisallowedRunningApp();
    }

    public static ArrayList<String> getDisableApps(Context context) {
        ArrayList<String> list = new ArrayList<>();

        ArrayList<PackageInfo> packages = (ArrayList<PackageInfo>) context.getPackageManager()
                .getInstalledPackages(PackageManager.MATCH_UNINSTALLED_PACKAGES);

        for (PackageInfo pak : packages)
            if (!isApplicationEnabled(context, pak.packageName))
                list.add(pak.packageName);

        return list;
    }

    public static boolean isApplicationEnabled(Context context, String packageName) {
        int nEnable = context.getPackageManager().getApplicationEnabledSetting(packageName);
        if (PackageManager.COMPONENT_ENABLED_STATE_DISABLED == nEnable)
            return false;
        else if (PackageManager.COMPONENT_ENABLED_STATE_DISABLED_USER == nEnable)
            return false;
        return true;
    }
}
