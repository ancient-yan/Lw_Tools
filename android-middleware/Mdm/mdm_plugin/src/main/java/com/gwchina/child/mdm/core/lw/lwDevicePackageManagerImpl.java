package com.gwchina.child.mdm.core.lw;

import android.util.Log;

import com.gwchina.child.mdm.DeviceService;
import com.gwchina.child.mdm.GwPackageDeleteObserver;
import com.gwchina.child.mdm.GwPackageInstallObserver;
import com.gwchina.child.mdm.core.glDevicePackageManagerImpl;

import java.util.List;

public class lwDevicePackageManagerImpl extends glDevicePackageManagerImpl {
    @Override
    public void addDisallowedUninstallPackages(List<String> packageNames) {
        Log.i(TAG, "addDisallowedUninstallPackages : " + packageNames);

        try {
            DeviceService.getmBinder2().addDisallowedUninstallPackages(packageNames);
        } catch (Throwable e) {
            Log.e(TAG, "addDisallowedUninstallPackages : " + e);
        }
    }

    @Override
    public void removeDisallowedUninstallPackages(List<String> packageNames) {
        Log.i(TAG, "removeDisallowedUninstallPackages : " + packageNames);

        try {
            DeviceService.getmBinder2().removeDisallowedUninstallPackages(packageNames);
        } catch (Throwable e) {
            Log.e(TAG, "removeDisallowedUninstallPackages : " + e);
        }
    }

    @Override
    public List<String> getDisallowedUninstallPackageList() {
        Log.i(TAG, "getDisallowedUninstallPackageList");

        try {
            return DeviceService.getmBinder2().getDisallowedUninstallPackageList();
        } catch (Throwable e) {
            Log.e(TAG, "getDisallowedUninstallPackageList : " + e);
        }

        return super.getDisallowedUninstallPackageList();
    }

    @Override
    public void installPackage(String packagePath, int flag, final GwPackageInstallObserver observer) {
        Log.i(TAG, "installPackage : " + packagePath);

        try {
            DeviceService.getmBinder2().installPackage(packagePath);
        } catch (Throwable e) {
            Log.e(TAG, "installPackage : " + e);
        }
    }

    @Override
    public void uninstallPackage(String packageName, int flag, final GwPackageDeleteObserver observer) {
        Log.i(TAG, "uninstallPackage : " + packageName);

        try {
            DeviceService.getmBinder2().uninstallPackage(packageName, false);
        } catch (Throwable e) {
            Log.e(TAG, "uninstallPackage : " + e);
        }
    }

    @Override
    public void clearPackageData(String packageName) {
        Log.i(TAG, "clearPackageData : " + packageName);

        try {
            DeviceService.getmBinder2().clearPackageData(packageName);
        } catch (Throwable e) {
            Log.e(TAG, "clearPackageData : " + e);
        }
    }
}
