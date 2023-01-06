package com.gwchina.child.mdm.core.lw;

import android.app.ActivityManager;
import android.app.mia.MiaMdmPolicyManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.gwchina.child.mdm.core.glDeviceApplicationManagerImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
            mpm.controlApp(packageName, !enable);
        } catch (Throwable e) {
            Log.e(TAG, "setApplicationEnabled : " + e);
        }
    }

    @Override
    public void killApplicationProcess(String packageName) {
        Log.i(TAG, "killApplicationProcess : " + packageName);

        forceStopPackage(context, packageName);
    }

    public static void forceStopPackage(Context context, String packageName) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            Method method = ActivityManager.class.getDeclaredMethod("forceStopPackage", new Class[]{String.class});
            method.setAccessible(true);
            method.invoke(activityManager, new Object[]{packageName});
        } catch (InvocationTargetException e) {
            Log.e(TAG, "forceStopPackage.InvocationTargetException : " + e.getCause());
        } catch (Throwable e) {
            Log.e(TAG, "forceStopPackage.Throwable : " + e);
        }
    }

    @Override
    public void addDisallowedRunningApp(List<String> packageNames) {
        Log.i(TAG, "addDisallowedRunningApp : " + packageNames);

        try {
            for (String packageName : packageNames)
                mpm.controlApp(packageName, true);
        } catch (Throwable e) {
            Log.e(TAG, "addDisallowedRunningApp : " + e);
        }
    }

    @Override
    public void removeDisallowedRunningApp(List<String> packageNames) {
        Log.i(TAG, "removeDisallowedRunningApp : " + packageNames);

        try {
            for (String packageName : packageNames)
                mpm.controlApp(packageName, false);
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
