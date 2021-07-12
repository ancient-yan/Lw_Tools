package com.gwchina.child.mdm;

interface GwDeviceRestrictionManager {
       void setWifiDisabled( boolean disabled);
   
       boolean isWifiDisabled();
   
       void setBluetoothDisabled( boolean disabled);
   
       boolean isBluetoothDisabled();

       void setWifiApDisabled( boolean disabled);
   
       boolean isWifiApDisabled();
   
       void setUSBDataDisabled( boolean disabled);
   
       boolean isUSBDataDisabled();
   
       void setExternalStorageDisabled( boolean disabled);
   
       boolean isExternalStorageDisabled();
   
       void setNFCDisabled( boolean disabled);
   
       boolean isNFCDisabled();
   
       void setDataConnectivityDisabled( boolean disabled);
   
       boolean isDataConnectivityDisabled();

       boolean setDataNetworkState(int state);

       int getDataNetworkState();
   
       void setVoiceDisabled( boolean disabled);
   
       boolean isVoiceDisabled();
   
       void setSMSDisabled( boolean disabled) ;
   
       boolean isSMSDisabled();
   
       void setStatusBarExpandPanelDisabled( boolean disabled);
   
       boolean isStatusBarExpandPanelDisabled();
   
       void setSafeModeDisabled( boolean disabled);
   
       boolean isSafeModeDisabled();
   
       void setAdbDisabled( boolean disabled);
   
       boolean isAdbDisabled();
   
       void setUSBOtgDisabled( boolean disabled);
   
       boolean isUSBOtgDisabled();
   
       void setGPSDisabled( boolean disabled);
   
       boolean isGPSDisabled() ;
   
       void setHomeButtonDisabled( boolean disabled) ;
   
       boolean isHomeButtonDisabled();
   
       void setTaskButtonDisabled( boolean disabled) ;
   
       boolean isTaskButtonDisabled() ;
   
       void setBackButtonDisabled( boolean disabled);
   
       boolean isBackButtonDisabled();
   
       boolean setScreenCaptureDisabled( boolean disable);
   
       boolean isScreenCaptureDisabled();
   
       boolean setSystemBrowserDisabled( boolean disable) ;
   
       boolean isSystemBrowserDisabled();
   
       boolean setSettingsApplicationDisabled( boolean disable) ;
   
       boolean isSettingsApplicationDisabled();
   
       boolean setGooglePlayStoreDisabled( boolean disable);
   
       boolean isGooglePlayStoreDisabled();
   
       boolean setSystemUpdateDisabled( boolean disable) ;
   
       boolean isSystemUpdateDisabled();
   
       void setGoogleAccountDisabled( boolean disabled);
   
       boolean isGoogleAccountDisabled();
   
       boolean setMicrophoneDisabled( boolean disabled);
   
       boolean isMicrophoneDisabled();
   
       boolean setClipboardDisabled( boolean disable);
   
       boolean isClipboardDisabled() ;
   
       boolean setGoogleAccountAutoSyncDisabled( boolean disable) ;
   
       boolean isGoogleAccountAutoSyncDisabled() ;
   
       boolean isApplicationDisabled( String packageName);

       void addUserRestriction(String key);

       void removeUserRestriction(String key);

       int setMode(int code, String packageName, int mode);

       int getMode(int code, String packageName);

       boolean systemFixed(String pkgName);
}