package com.gwchina.child.mdm.core;

import android.graphics.Bitmap;

import com.gwchina.child.mdm.GwDeviceControlManager;

import java.util.List;

public class glDeviceControlManagerImpl extends GwDeviceControlManager.Stub {
    protected final static String TAG = "my_mdm";

    public glDeviceControlManagerImpl() {
    }

    @Override
    public void shutdownDevice() {
    }

    @Override
    public void rebootDevice() {
    }

    @Override
    public boolean isRooted() {
        return false;
    }

    @Override
    public void turnOnGPS(boolean on) {
    }

    @Override
    public boolean isGPSTurnOn() {
        return false;
    }

    @Override
    public void setSysTime(long millis) {
    }

    @Override
    public void setCustomSettingsMenu(List<String> menusToDelete) {
    }

    @Override
    public void setDefaultLauncher(String packageName, String className) {
    }

    @Override
    public void clearDefaultLauncher() {
    }

    @Override
    public Bitmap captureScreen() {
        return null;
    }

    @Override
    public void setSilentActiveAdmin() {
    }

    @Override
    public boolean formatSDCard(String diskId) {
        return false;
    }

    @Override
    public boolean installCertificateWithType(int type, byte[] certBuffer, String name, String password, int flag, boolean requestAccess) {
        return false;
    }

    @Override
    public boolean isEnterpriseModeActivated() {
        return false;
    }
}
