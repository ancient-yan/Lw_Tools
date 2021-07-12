// GwDeviceInterface.aidl
package com.gwchina.child.mdm;

// Declare any non-default types here with import statements
import com.gwchina.child.mdm.GwDeviceApplicationManager;
import com.gwchina.child.mdm.GwDeviceControlManager;
import com.gwchina.child.mdm.GwDevicePackageManager;
import com.gwchina.child.mdm.GwDeviceCameraManager;
import com.gwchina.child.mdm.GwDevicePhoneManager;
import com.gwchina.child.mdm.GwDeviceRestrictionManager;
import com.gwchina.child.mdm.GwDeviceSettingsManager;
import com.gwchina.child.mdm.GwDeviceTelephonyManager;
import com.gwchina.child.mdm.GwDevicePermissionManager;
import com.gwchina.child.mdm.GwDeviceSystemManager;
import com.gwchina.child.mdm.GwDeviceVpnManager;

interface GwDeviceInterface {

    boolean init(String key);

    GwDeviceApplicationManager getDeviceApplicationManager();

    GwDeviceControlManager getDeviceControlManager();

    GwDevicePackageManager getDevicePackageManager();

    GwDeviceCameraManager getDeviceCameraManager();

    GwDevicePhoneManager getDevicePhoneManager();

    GwDeviceRestrictionManager getDeviceRestrictionManager();

    GwDeviceSettingsManager getDeviceSettingsManager();

    GwDeviceTelephonyManager getDeviceTelephonyManager();

    GwDevicePermissionManager getDevicePermissionManager();

    GwDeviceSystemManager getDeviceSystemManager();

    GwDeviceVpnManager getDeviceVpnManager();
}
