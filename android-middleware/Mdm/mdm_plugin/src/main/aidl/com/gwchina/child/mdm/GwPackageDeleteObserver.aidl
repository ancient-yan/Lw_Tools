// GwDeviceApplicationManager.aidl
package com.gwchina.child.mdm;

// Declare any non-default types here with import statements

interface GwPackageDeleteObserver {

    void onPackageDeleted(String basePackageName, int returnCode, String msg);
}
