package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.util.Log;

import com.gwchina.child.mdm.GwPackageDeleteObserver;
import com.gwchina.child.mdm.GwPackageInstallObserver;
import com.gwchina.child.mdm.core.glDevicePackageManagerImpl;

public class lwDevicePackageManagerImpl extends glDevicePackageManagerImpl {
    MiaMdmPolicyManager mpm;

    public lwDevicePackageManagerImpl(MiaMdmPolicyManager mpm) {
        this.mpm = mpm;
    }

    @Override
    public void installPackage(String packagePath, int flag, final GwPackageInstallObserver observer) {
        Log.i(TAG, "installPackage : " + packagePath);

        try {
            mpm.silentInstall(packagePath);
        } catch (Throwable e) {
            Log.e(TAG, "installPackage : " + e);
        }
    }

    @Override
    public void uninstallPackage(String packageName, int flag, final GwPackageDeleteObserver observer) {
        Log.i(TAG, "uninstallPackage : " + packageName);

        try {
            mpm.silentUnInstall(packageName);
        } catch (Throwable e) {
            Log.e(TAG, "uninstallPackage : " + e);
        }
    }

    @Override
    public void clearPackageData(String packageName) {
        Log.i(TAG, "clearPackageData : " + packageName);

        try {
            mpm.clearAppData(packageName);
        } catch (Throwable e) {
            Log.e(TAG, "clearPackageData : " + e);
        }
    }
}
