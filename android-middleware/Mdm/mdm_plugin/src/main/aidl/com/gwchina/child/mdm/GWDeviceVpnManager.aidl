// GWDeviceSystemManager.aidl
package com.gwchina.child.mdm;

// Declare any non-default types here with import statements

interface GwDeviceVpnManager {

        boolean isVpnDisabled();

        boolean setVpnDisabled(boolean disable);
}
