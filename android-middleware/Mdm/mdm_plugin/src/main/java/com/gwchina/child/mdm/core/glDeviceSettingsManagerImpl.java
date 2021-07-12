package com.gwchina.child.mdm.core;

import com.gwchina.child.mdm.GwDeviceSettingsManager;

public class glDeviceSettingsManagerImpl extends GwDeviceSettingsManager.Stub {
    protected final static String TAG = "my_mdm";

    public glDeviceSettingsManagerImpl() {
    }

    @Override
    public boolean setNetworkLocationDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isNetworkLocationDisabled() {
        return false;
    }

    @Override
    public boolean setUnknownSourceAppInstallDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isUnknownSourceAppInstallDisabled() {
        return false;
    }

    @Override
    public boolean setAllTetheringDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isAllTetheringDisabled() {
        return false;
    }

    @Override
    public boolean setWIFIeditDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isWIFIeditDisabled() {
        return false;
    }

    @Override
    public boolean setRestoreFactoryDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean setRestoreStateDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isRestoreStateDisable() {
        return false;
    }

    @Override
    public boolean isRestoreFactoryDisabled() {
        return false;
    }

    @Override
    public boolean setWIFIStandbyMode(int status) {
        return false;
    }

    @Override
    public int getWIFIStandbyMode() {
        return 0;
    }

    @Override
    public boolean setBluetoothTetheringDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isBluetoothTetheringDisabled() {
        return false;
    }

    @Override
    public boolean setAddUserDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isAddUserDisabled() {
        return false;
    }

    @Override
    public boolean setEchoPasswordDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isEchoPasswordDisabled() {
        return false;
    }

    @Override
    public boolean setForceStopSystemSignatureAppDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isForceStopSystemSignatureAppDisabled() {
        return false;
    }

    @Override
    public boolean setUSBTetheringDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isUSBTetheringDisabled() {
        return false;
    }

    @Override
    public boolean setTimeAndDateSetDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isTimeAndDateSetDisabled() {
        return false;
    }

    @Override
    public boolean setGoogleBackupRestoreDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isGoogleBackupRestoreDisabled() {
        return false;
    }

    @Override
    public boolean setDevelopmentOptionDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isDevelopmentOptionDisabled() {
        return false;
    }

    @Override
    public boolean isPowerSavingDisabled() {
        return false;
    }

    @Override
    public boolean setPowerSavingDisabled(boolean disable) {
        return false;
    }
}
