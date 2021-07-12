package com.gwchina.child.mdm.core;

import com.gwchina.child.mdm.GwDeviceTelephonyManager;

public class glDeviceTelephonyManagerImpl extends GwDeviceTelephonyManager.Stub {
    protected final static String TAG = "my_mdm";

    public glDeviceTelephonyManagerImpl() {
    }

    @Override
    public boolean setSlot2Disable(boolean isSubActive) {
        return false;
    }

    @Override
    public boolean isSlot2Disable() {
        return false;
    }

    @Override
    public boolean setSlot2DataDisable(boolean isSubActive) {
        return false;
    }

    @Override
    public boolean isSlot2DataDisable() {
        return false;
    }

    @Override
    public String getIMEI1() {
        return null;
    }

    @Override
    public String getIMEI2() {
        return null;
    }

    @Override
    public String getMEID() {
        return null;
    }

    @Override
    public String getSerial() {
        return null;
    }
}
