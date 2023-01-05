package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

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
    public void setApplicationEnabled(String packageName, boolean enable) {
        Log.i(TAG, "setApplicationEnabled : " + packageName + " ; enable : " + enable);

        try {

        } catch (Throwable e) {
            Log.e(TAG, "setApplicationEnabled : " + e);
        }
    }

    @Override
    public void killApplicationProcess(String packageName) {
        Log.i(TAG, "killApplicationProcess : " + packageName);

        try {
//            mpm.killApp(packageName);
        } catch (Throwable e) {
            Log.e(TAG, "killApplicationProcess : " + e);
        }
    }

    @Override
    public void addDisallowedRunningApp(List<String> packageNames) {
        Log.i(TAG, "addDisallowedRunningApp : " + packageNames);

        try {
            for (String packageName : packageNames);
//                DeviceService.getmBinder().setFunctionState(ClientDataParse.testPackage(10001, packageName, 1));
        } catch (Throwable e) {
            Log.e(TAG, "addDisallowedRunningApp : " + e);
        }
    }

    @Override
    public void removeDisallowedRunningApp(List<String> packageNames) {
        Log.i(TAG, "removeDisallowedRunningApp : " + packageNames);

        try {
            for (String packageName : packageNames);
//                DeviceService.getmBinder().setFunctionState(ClientDataParse.testPackage(10001, packageName, 0));
        } catch (Throwable e) {
            Log.e(TAG, "removeDisallowedRunningApp : " + e);
        }
    }

    @Override
    public List<String> getDisallowedRunningApp() {
        Log.i(TAG, "getDisallowedRunningApp");

        try {
            return getSuspendApps(context);
        } catch (Throwable e) {
            Log.e(TAG, "getDisallowedRunningApp : " + e);
        }

        return super.getDisallowedRunningApp();
    }

    public static ArrayList<String> getSuspendApps(Context context) {
        ArrayList<String> list = new ArrayList<>();

        ArrayList<PackageInfo> packages = (ArrayList<PackageInfo>) context.getPackageManager()
                .getInstalledPackages(PackageManager.MATCH_UNINSTALLED_PACKAGES);

        for (PackageInfo pak : packages)
            if ((pak.applicationInfo.flags & ApplicationInfo.FLAG_SUSPENDED) > 0)
                list.add(pak.packageName);

        return list;
    }
}
