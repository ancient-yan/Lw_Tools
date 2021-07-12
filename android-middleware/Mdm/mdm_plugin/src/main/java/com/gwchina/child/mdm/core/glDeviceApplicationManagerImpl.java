package com.gwchina.child.mdm.core;

import android.content.ComponentName;

import com.gwchina.child.mdm.GwDeviceApplicationManager;

import java.util.ArrayList;
import java.util.List;

public class glDeviceApplicationManagerImpl extends GwDeviceApplicationManager.Stub {
    protected final static String TAG = "my_mdm";

    public glDeviceApplicationManagerImpl() {
    }

    @Override
    public void addPersistentApp(List<String> packageNames) {
    }

    @Override
    public void removePersistentApp(List<String> packageNames) {
    }

    @Override
    public List<String> getPersistentApp() {
        return null;
    }

    @Override
    public void addDisallowedRunningApp(List<String> packageNames) {
    }

    @Override
    public void removeDisallowedRunningApp(List<String> packageNames) {
    }

    @Override
    public List<String> getDisallowedRunningApp() {
        return new ArrayList<>();
    }

    @Override
    public void killApplicationProcess(String packageName) {
    }

    @Override
    public void cleanBackgroundProcess() {
    }

    @Override
    public boolean addInstallPackageBlackList(List<String> packageNames) {
        return true;
    }

    @Override
    public List<String> getInstallPackageBlackList() {
        return null;
    }

    @Override
    public boolean removeInstallPackageBlackList(List<String> packageNames) {
        return true;
    }

    @Override
    public boolean addIgnoreFrequentRelaunchAppList(List<String> apps) {
        return false;
    }

    @Override
    public boolean removeIgnoreFrequentRelaunchAppList(List<String> apps) {
        return false;
    }

    @Override
    public List<String> getIgnoreFrequentRelaunchAppList() {
        return null;
    }

    @Override
    public void setApplicationEnabled(String packageName, boolean enable) {
    }

    @Override
    public void setApplicationEnabled2(String packageName, boolean enable, int userId) {
    }

    @Override
    public void addSingleApp(java.lang.String packageName) {
    }

    @Override
    public boolean clearSingleApp(java.lang.String packageName) {
        return false;
    }

    @Override
    public String getSingleApp() {
        return null;
    }

    @Override
    public void enableAccessibilityService(String packageName, String className, boolean enable) {
    }

    @Override
    public void killApplicationProcessForUser(String packageName, int userId) {
    }

    @Override
    public void setComponentEnabled(ComponentName componentName, boolean enable) {
    }
}
