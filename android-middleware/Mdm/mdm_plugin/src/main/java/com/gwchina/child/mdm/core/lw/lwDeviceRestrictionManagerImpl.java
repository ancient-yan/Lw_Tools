package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.util.Log;

import com.gwchina.child.mdm.core.glDeviceRestrictionManagerImpl;

public class lwDeviceRestrictionManagerImpl extends glDeviceRestrictionManagerImpl {
    MiaMdmPolicyManager mpm;

    public lwDeviceRestrictionManagerImpl(MiaMdmPolicyManager mpm) {
        this.mpm = mpm;
    }

    @Override
    public void setAdbDisabled(boolean disabled) {
        Log.i(TAG, "setAdbDisabled : " + disabled);

        try {
            mpm.setUsbOnlyCharging(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setAdbDisabled : " + e);
        }
    }

    @Override
    public void setHomeButtonDisabled(boolean disabled) {
        Log.i(TAG, "setHomeButtonDisabled : " + disabled);

        try {
            mpm.setHomeKey(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setHomeButtonDisabled : " + e);
        }
    }

    @Override
    public void setTaskButtonDisabled(boolean disabled) {
        Log.i(TAG, "setTaskButtonDisabled : " + disabled);

        try {
            mpm.setRecentKey(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setTaskButtonDisabled : " + e);
        }
    }

    @Override
    public void setBackButtonDisabled(boolean disabled) {
        Log.i(TAG, "setBackButtonDisabled : " + disabled);

        try {
            mpm.setBackKey(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setBackButtonDisabled : " + e);
        }
    }

    @Override
    public boolean isBackButtonDisabled() {
        Log.i(TAG, "isBackButtonDisabled");

        try {
            return !mpm.isControlBackKey();
        } catch (Throwable e) {
            Log.e(TAG, "isBackButtonDisabled : " + e);
        }

        return super.isBackButtonDisabled();
    }

    @Override
    public void setUSBDataDisabled(boolean disabled) {
        Log.i(TAG, "setUSBDataDisabled : " + disabled);

        if (!disabled && !isAdbDisabled()) return;//无效设置，会导致adb被意外关闭

        try {
//            mpm.setOnlyCharging(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setUSBDataDisabled : " + e);
        }
    }

    @Override
    public boolean isUSBDataDisabled() {
        Log.i(TAG, "isUSBDataDisabled");

        try {
//            return mpm.isUsbOnlyCharging();
        } catch (Throwable e) {
            Log.e(TAG, "isUSBDataDisabled : " + e);
        }

        return super.isUSBDataDisabled();
    }
}
