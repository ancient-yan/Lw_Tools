package com.gwchina.child.mdm;

interface GwDeviceTelephonyManager {
    boolean setSlot2Disable(boolean isSubActive);

    boolean isSlot2Disable();

    boolean setSlot2DataDisable(boolean isSubActive);

    boolean isSlot2DataDisable();

    String getIMEI1();

    String getIMEI2();

    String getMEID();

    String getSerial();
}