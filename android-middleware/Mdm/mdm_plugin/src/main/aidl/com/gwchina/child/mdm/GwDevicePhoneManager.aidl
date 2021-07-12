// GwDeviceCameraManager.aidl
package com.gwchina.child.mdm;

interface GwDevicePhoneManager {

    void hangupCalling();
    
    boolean setDataRoamingDisabled( boolean disable);

    boolean isDataRoamingDisabled() ;

    boolean setAccessPointNameDisabled( boolean disable);

    boolean isApnChangeDisabled();

    boolean addMdmNumberList( in List<String> numbers, int blockMode, boolean isOutgoing, boolean isBlackList);

    boolean removeMdmNumberList(in List<String> numbers, int blockMode, boolean isOutgoing, boolean removeAll);

    boolean isBlockNumber( String number, boolean isOutgoing);

    List<String> getPhoneNumbers();
}
