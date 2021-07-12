// GwDeviceControlManager.aidl
package com.gwchina.child.mdm;


interface GwDeviceControlManager {
     void shutdownDevice();

     void rebootDevice();

     boolean isRooted();

     void turnOnGPS( boolean on);

     boolean isGPSTurnOn();

     void setSysTime( long millis);

     void setCustomSettingsMenu(in List<String> menusToDelete);

     void setDefaultLauncher(String packageName, String className);

     void clearDefaultLauncher();
     
     Bitmap captureScreen();

     void setSilentActiveAdmin();

     boolean formatSDCard( String diskId);

     boolean installCertificateWithType(int type, in byte[] certBuffer, String name, String password, int flag, boolean requestAccess);

     boolean isEnterpriseModeActivated();
}
