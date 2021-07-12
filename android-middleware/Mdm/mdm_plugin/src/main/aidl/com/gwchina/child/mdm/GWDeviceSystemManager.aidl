// GWDeviceSystemManager.aidl
package com.gwchina.child.mdm;

// Declare any non-default types here with import statements

interface GwDeviceSystemManager {

        List<String> getSuperWhiteListForHwSystemManger();
    
        boolean setSuperWhiteListForHwSystemManger(in List<String> list);
    
        boolean removeSuperWhiteListForHwSystemManger(in List<String> list);
    
        boolean setDataSaverMode(boolean disable);
    
        boolean getDataSaverMode(boolean disable);
    
        List<String> getEnterpriseWhiteList();
    
        boolean addEnterpriseWhiteList(in List<String> list);
    
        boolean removeEnterpriseWhiteList(in List<String> list);
    
        boolean setPowerSaveModeDisabled(boolean enabled);
    
        boolean isPowerSaveModeDisabled();
}
