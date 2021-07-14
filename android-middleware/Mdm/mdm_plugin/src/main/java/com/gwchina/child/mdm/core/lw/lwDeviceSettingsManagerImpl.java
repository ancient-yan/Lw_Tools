package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.util.Log;

import com.gwchina.child.mdm.core.glDeviceSettingsManagerImpl;

public class lwDeviceSettingsManagerImpl extends glDeviceSettingsManagerImpl {
    MiaMdmPolicyManager mpm;

    public lwDeviceSettingsManagerImpl(MiaMdmPolicyManager mpm) {
        this.mpm = mpm;
    }

    @Override
    public boolean setRestoreFactoryDisabled(boolean disable) {
        Log.i(TAG, "setRestoreFactoryDisabled : " + disable);

        try {
            mpm.setReset(disable);
        } catch (Throwable e) {
            Log.e(TAG, "setRestoreFactoryDisabled : " + e);
        }

        return super.setRestoreFactoryDisabled(disable);
    }

    @Override
    public boolean setDevelopmentOptionDisabled(boolean disable) {
        Log.i(TAG, "setDevelopmentOptionDisabled : " + disable);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "setDevelopmentOptionDisabled : " + e);
        }

        return super.setDevelopmentOptionDisabled(disable);
    }

    @Override
    public boolean isDevelopmentOptionDisabled() {
        Log.i(TAG, "isDevelopmentOptionDisabled");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "isDevelopmentOptionDisabled : " + e);
        }

        return super.isDevelopmentOptionDisabled();
    }

    @Override
    public boolean setTimeAndDateSetDisabled(boolean disable) {
        Log.i(TAG, "setTimeAndDateSetDisabled : " + disable);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "setTimeAndDateSetDisabled : " + e);
        }

        return super.setTimeAndDateSetDisabled(disable);
    }

    @Override
    public boolean isTimeAndDateSetDisabled() {
        Log.i(TAG, "isTimeAndDateSetDisabled");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "isTimeAndDateSetDisabled : " + e);
        }

        return super.isTimeAndDateSetDisabled();
    }
}
