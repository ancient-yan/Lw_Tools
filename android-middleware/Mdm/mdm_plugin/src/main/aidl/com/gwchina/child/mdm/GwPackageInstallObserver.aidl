// GwDeviceApplicationManager.aidl
package com.gwchina.child.mdm;

// Declare any non-default types here with import statements

interface GwPackageInstallObserver {

    void onPackageInstall(String basePackageName, int returnCode, String msg, out Bundle extras);
}
