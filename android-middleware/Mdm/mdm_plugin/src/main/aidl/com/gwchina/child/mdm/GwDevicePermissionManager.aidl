// GwDevicePermissionManager.aidl
package com.gwchina.child.mdm;

// Declare any non-default types here with import statements

interface GwDevicePermissionManager {

    boolean addAppPermissionWhiteList( in List<String> pkgs);

    List<String> getAppPermissionWhiteList();

    boolean deleteAppPermissionWhiteList( in List<String> pkgs);
}
