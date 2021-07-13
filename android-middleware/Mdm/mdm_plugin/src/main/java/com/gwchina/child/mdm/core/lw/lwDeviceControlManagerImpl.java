package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.graphics.Bitmap;
import android.util.Log;

import com.gwchina.child.mdm.DeviceService;
import com.gwchina.child.mdm.core.glDeviceControlManagerImpl;

import java.util.List;

public class lwDeviceControlManagerImpl extends glDeviceControlManagerImpl {
    MiaMdmPolicyManager mpm;

    public lwDeviceControlManagerImpl(MiaMdmPolicyManager mpm) {
        this.mpm = mpm;
    }

    @Override
    public void shutdownDevice() {
        Log.i(TAG, "shutdownDevice");

        try {
            DeviceService.getmBinder().powerOff();
        } catch (Throwable e) {
            Log.e(TAG, "shutdownDevice : " + e);
        }
    }

    @Override
    public void rebootDevice() {
        Log.i(TAG, "rebootDevice");

        try {
            mpm.reBoot();
        } catch (Throwable e) {
            Log.e(TAG, "rebootDevice : " + e);
        }
    }

    @Override
    public void setDefaultLauncher(String packageName, String className) {
        Log.i(TAG, "setDefaultLauncher : " + packageName + "/" + className);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "setDefaultLauncher : " + e);
        }
    }

    @Override
    public void clearDefaultLauncher() {
        Log.i(TAG, "clearDefaultLauncher");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "clearDefaultLauncher : " + e);
        }
    }

    @Override
    public void setCustomSettingsMenu(List<String> menusToDelete) {
        Log.i(TAG, "setCustomSettingsMenu : " + menusToDelete);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "setCustomSettingsMenu : " + e);
        }
    }

    @Override
    public Bitmap captureScreen() {
        Log.i(TAG, "captureScreen");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "captureScreen : " + e);
        }

        return super.captureScreen();
    }

    @Override
    public void turnOnGPS(boolean on) {
        Log.i(TAG, "turnOnGPS : " + on);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "turnOnGPS : " + e);
        }
    }

    @Override
    public boolean isGPSTurnOn() {
        Log.i(TAG, "isGPSTurnOn");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "isGPSTurnOn : " + e);
        }

        return super.isGPSTurnOn();
    }
}
