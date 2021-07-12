package com.gwchina.child.mdm.core;

import android.os.Bundle;

import com.gwchina.child.mdm.GwDevicePackageManager;
import com.gwchina.child.mdm.GwPackageDeleteObserver;
import com.gwchina.child.mdm.GwPackageInstallObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class glDevicePackageManagerImpl extends GwDevicePackageManager.Stub {
    protected final static String TAG = "my_mdm";

    public glDevicePackageManagerImpl() {
    }

    @Override
    public void installPackage(String packagePath, int flag, final GwPackageInstallObserver observer) {
    }

    @Override
    public void uninstallPackage(String packageName, int flag, final GwPackageDeleteObserver observer) {
    }

    @Override
    public void clearPackageData(String packageName) {
    }

    @Override
    public void enableInstallPackage() {
    }

    @Override
    public void disableInstallSource(List<String> whitelist) {
    }

    @Override
    public boolean isInstallSourceDisabled() {
        return false;
    }

    @Override
    public List<String> getInstallPackageSourceWhiteList() {
        return null;
    }

    @Override
    public void addInstallPackageWhiteList(List<String> packageNames) {
    }

    @Override
    public void removeInstallPackageWhiteList(List<String> packageNames) {
    }

    @Override
    public List<String> getInstallPackageWhiteList() {
        return null;
    }

    @Override
    public void addDisallowedUninstallPackages(List<String> packageNames) {
    }

    @Override
    public void removeDisallowedUninstallPackages(List<String> packageNames) {
    }

    @Override
    public List<String> getDisallowedUninstallPackageList() {
        return new ArrayList<>();
    }

    @Override
    public void addDisabledDeactivateMdmPackages(List<String> packageNames) {
    }

    @Override
    public void removeDisabledDeactivateMdmPackages(List<String> packageNames) {
    }

    @Override
    public List<String> getDisabledDeactivateMdmPackageList() {
        return null;
    }

    @Override
    public String getTopActivity() {
        return null;
    }

    @Override
    public int getApplicationEnabledSetting(java.lang.String packageName) {
        return 0;
    }

    @Override
    public void setApplicationEnabledSetting(java.lang.String packageName, int newState, int flags) {
    }

    @Override
    public int getComponentEnabledSetting(java.lang.String packageName, java.lang.String className) {
        return 0;
    }

    @Override
    public void setComponentEnabledSetting(java.lang.String packageName, java.lang.String className, int newState, int flags) {
    }

    @Override
    public void setSysAppList(Map maps, Bundle bundle) {
    }

    @Override
    public List getSysAppList(List pkgNames) {
        return null;
    }
}
