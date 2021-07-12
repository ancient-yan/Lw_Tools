package com.gwchina.child.mdm.core;

import android.os.RemoteException;

import com.gwchina.child.mdm.GwDeviceRestrictionManager;

public class glDeviceRestrictionManagerImpl extends GwDeviceRestrictionManager.Stub {
    protected final static String TAG = "my_mdm";

    public glDeviceRestrictionManagerImpl() {
    }

    @Override
    public void setWifiDisabled(boolean disabled) {
    }

    @Override
    public boolean isWifiDisabled() {
        return false;
    }

    @Override
    public void setBluetoothDisabled(boolean disabled) {
    }

    @Override
    public boolean isBluetoothDisabled() {
        return false;
    }

    @Override
    public void setWifiApDisabled(boolean disabled) {
    }

    @Override
    public boolean isWifiApDisabled() {
        return false;
    }

    @Override
    public void setUSBDataDisabled(boolean disabled) {
    }

    @Override
    public boolean isUSBDataDisabled() {
        return false;
    }

    @Override
    public void setExternalStorageDisabled(boolean disabled) {
    }

    @Override
    public boolean isExternalStorageDisabled() {
        return false;
    }

    @Override
    public void setNFCDisabled(boolean disabled) {
    }

    @Override
    public boolean isNFCDisabled() {
        return false;
    }

    @Override
    public void setDataConnectivityDisabled(boolean disabled) {
    }

    @Override
    public boolean isDataConnectivityDisabled() {
        return false;
    }

    @Override
    public boolean setDataNetworkState(int state) throws RemoteException {
        return false;
    }

    @Override
    public int getDataNetworkState() throws RemoteException {
        return 0;
    }

    @Override
    public void setVoiceDisabled(boolean disabled) {
    }

    @Override
    public boolean isVoiceDisabled() {
        return false;
    }

    @Override
    public void setSMSDisabled(boolean disabled) {
    }

    @Override
    public boolean isSMSDisabled() {
        return false;
    }

    @Override
    public void setStatusBarExpandPanelDisabled(boolean disabled) {
    }

    @Override
    public boolean isStatusBarExpandPanelDisabled() {
        return false;
    }

    @Override
    public void setSafeModeDisabled(boolean disabled) {
    }

    @Override
    public boolean isSafeModeDisabled() {
        return false;
    }

    @Override
    public void setAdbDisabled(boolean disabled) {
    }

    @Override
    public boolean isAdbDisabled() {
        return false;
    }

    @Override
    public void setUSBOtgDisabled(boolean disabled) {
    }

    @Override
    public boolean isUSBOtgDisabled() {
        return false;
    }

    @Override
    public void setGPSDisabled(boolean disabled) {
    }

    @Override
    public boolean isGPSDisabled() {
        return false;
    }

    @Override
    public void setHomeButtonDisabled(boolean disabled) {
    }

    @Override
    public boolean isHomeButtonDisabled() {
        return false;
    }

    @Override
    public void setTaskButtonDisabled(boolean disabled) {
    }

    @Override
    public boolean isTaskButtonDisabled() {
        return false;
    }

    @Override
    public void setBackButtonDisabled(boolean disabled) {
    }

    @Override
    public boolean isBackButtonDisabled() {
        return false;
    }

    @Override
    public boolean setScreenCaptureDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isScreenCaptureDisabled() {
        return false;
    }

    @Override
    public boolean setSystemBrowserDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isSystemBrowserDisabled() {
        return false;
    }

    @Override
    public boolean setSettingsApplicationDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isSettingsApplicationDisabled() {
        return false;
    }

    @Override
    public boolean setGooglePlayStoreDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isGooglePlayStoreDisabled() {
        return false;
    }

    @Override
    public boolean setSystemUpdateDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isSystemUpdateDisabled() {
        return false;
    }

    @Override
    public void setGoogleAccountDisabled(boolean disabled) {
    }

    @Override
    public boolean isGoogleAccountDisabled() {
        return false;
    }

    @Override
    public boolean setMicrophoneDisabled(boolean disabled) {
        return false;
    }

    @Override
    public boolean isMicrophoneDisabled() {
        return false;
    }

    @Override
    public boolean setClipboardDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isClipboardDisabled() {
        return false;
    }

    @Override
    public boolean setGoogleAccountAutoSyncDisabled(boolean disable) {
        return false;
    }

    @Override
    public boolean isGoogleAccountAutoSyncDisabled() {
        return false;
    }

    @Override
    public boolean isApplicationDisabled(String packageName) {
        return false;
    }

    @Override
    public int setMode(int code, String packageName, int mode) {
        return 0;
    }

    @Override
    public int getMode(int code, String packageName) {
        return 0;
    }

    @Override
    public boolean systemFixed(String pkgName) {
        return false;
    }

    @Override
    public void addUserRestriction(java.lang.String key) {
    }

    @Override
    public void removeUserRestriction(java.lang.String key) {
    }
}
