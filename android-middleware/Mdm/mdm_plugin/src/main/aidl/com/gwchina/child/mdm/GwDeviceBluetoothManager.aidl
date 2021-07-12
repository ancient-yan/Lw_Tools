// GwDeviceBluetoothManager.aidl
package com.gwchina.child.mdm;

interface GwDeviceBluetoothManager {

    boolean addBluetoothDevicesToBlackList(in List<String> devices);
   
    boolean addBluetoothDevicesToWhiteList(in List<String> devices);
   
    boolean removeBluetoothDevicesFromBlackList(in  List<String> devices);
   
    boolean removeBluetoothDevicesFromWhiteList(in  List<String> devices);
   
    List<String> getBluetoothDevicesFromBlackLists();

    List<String> getBluetoothDevicesFromWhiteLists();

    boolean isBlackListedDevice(String device);

    boolean isWhiteListedDevice(String device);
}
