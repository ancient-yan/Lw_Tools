package com.gwchina.child.mdm.core.lw;

import android.util.Log;

import com.gwchina.child.mdm.DeviceService;
import com.gwchina.child.mdm.core.glDeviceSettingsManagerImpl;

public class lwDeviceSettingsManagerImpl extends glDeviceSettingsManagerImpl {
    @Override
    public boolean setRestoreFactoryDisabled(boolean disable) {
        Log.i(TAG, "setRestoreFactoryDisabled : " + disable);

        try {
            return DeviceService.getmBinder2().setRestoreFactoryDisabled(disable);
        } catch (Throwable e) {
            Log.e(TAG, "setRestoreFactoryDisabled : " + e);
        }

        return super.setRestoreFactoryDisabled(disable);
    }

    @Override
    public boolean isRestoreFactoryDisabled() {
        Log.i(TAG, "isRestoreFactoryDisabled");

        try {
            return DeviceService.getmBinder2().isRestoreFactoryDisabled();
        } catch (Throwable e) {
            Log.e(TAG, "isRestoreFactoryDisabled : " + e);
        }

        return super.isRestoreFactoryDisabled();
    }

    @Override
    public boolean setDevelopmentOptionDisabled(boolean disable) {
        Log.i(TAG, "setDevelopmentOptionDisabled : " + disable);

        try {
            return DeviceService.getmBinder2().setDevelopmentOptionDisabled(disable);
        } catch (Throwable e) {
            Log.e(TAG, "setDevelopmentOptionDisabled : " + e);
        }

        return super.setDevelopmentOptionDisabled(disable);
    }

    @Override
    public boolean isDevelopmentOptionDisabled() {
        Log.i(TAG, "isDevelopmentOptionDisabled");

        try {
            return DeviceService.getmBinder2().isDevelopmentOptionDisabled();
        } catch (Throwable e) {
            Log.e(TAG, "isDevelopmentOptionDisabled : " + e);
        }

        return super.isDevelopmentOptionDisabled();
    }

    @Override
    public boolean setTimeAndDateSetDisabled(boolean disable) {
        Log.i(TAG, "setTimeAndDateSetDisabled : " + disable);

        try {
            return DeviceService.getmBinder2().setTimeAndDateSetDisabled(disable);
        } catch (Throwable e) {
            Log.e(TAG, "setTimeAndDateSetDisabled : " + e);
        }

        return super.setTimeAndDateSetDisabled(disable);
    }

    @Override
    public boolean isTimeAndDateSetDisabled() {
        Log.i(TAG, "isTimeAndDateSetDisabled");

        try {
            return DeviceService.getmBinder2().isTimeAndDateSetDisabled();
        } catch (Throwable e) {
            Log.e(TAG, "isTimeAndDateSetDisabled : " + e);
        }

        return super.isTimeAndDateSetDisabled();
    }
}
