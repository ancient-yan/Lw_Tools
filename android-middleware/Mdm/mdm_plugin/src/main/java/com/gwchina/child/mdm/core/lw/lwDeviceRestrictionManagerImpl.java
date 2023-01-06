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
    public void setBluetoothDisabled(boolean disabled) {
        Log.i(TAG, "setBluetoothDisabled : " + disabled);

        try {
            mpm.allowBluetoothDataTransfer(!disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setBluetoothDisabled : " + e);
        }
    }

    @Override
    public void setExternalStorageDisabled(boolean disabled) {
        Log.i(TAG, "setExternalStorageDisabled : " + disabled);

        try {
            mpm.setTFcard(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setExternalStorageDisabled : " + e);
        }
    }
}
