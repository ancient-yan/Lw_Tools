package com.gwchina.child.mdm;

interface GwDeviceSettingsManager {

        boolean setNetworkLocationDisabled( boolean disable);

        boolean isNetworkLocationDisabled();

        boolean setUnknownSourceAppInstallDisabled( boolean disable);

        boolean isUnknownSourceAppInstallDisabled();

        boolean setAllTetheringDisabled( boolean disable);

        boolean isAllTetheringDisabled();

        boolean setWIFIeditDisabled( boolean disable);

        boolean isWIFIeditDisabled();

        boolean setRestoreFactoryDisabled( boolean disable);

        boolean setRestoreStateDisabled(boolean disable);

        boolean isRestoreStateDisable();

        boolean isRestoreFactoryDisabled();

        boolean setWIFIStandbyMode( int status);

        int getWIFIStandbyMode();

        boolean setBluetoothTetheringDisabled( boolean disable);

        boolean isBluetoothTetheringDisabled();

        boolean setAddUserDisabled( boolean disable);

        boolean isAddUserDisabled();

        boolean setEchoPasswordDisabled( boolean disable);

        boolean isEchoPasswordDisabled();

        boolean setForceStopSystemSignatureAppDisabled( boolean disable);

        boolean isForceStopSystemSignatureAppDisabled();

        boolean setUSBTetheringDisabled( boolean disable);

        boolean isUSBTetheringDisabled();

        boolean setTimeAndDateSetDisabled( boolean disable);

        boolean isTimeAndDateSetDisabled();

        boolean setGoogleBackupRestoreDisabled( boolean disable);

        boolean isGoogleBackupRestoreDisabled();

        boolean setDevelopmentOptionDisabled(boolean disable);

        boolean isDevelopmentOptionDisabled();

        boolean isPowerSavingDisabled();

        boolean setPowerSavingDisabled(boolean disable);
}