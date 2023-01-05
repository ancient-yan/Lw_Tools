package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.util.Log;

import com.gwchina.child.mdm.core.glDeviceControlManagerImpl;

public class lwDeviceControlManagerImpl extends glDeviceControlManagerImpl {
    MiaMdmPolicyManager mpm;

    public lwDeviceControlManagerImpl(MiaMdmPolicyManager mpm) {
        this.mpm = mpm;
    }

    @Override
    public void shutdownDevice() {
        Log.i(TAG, "shutdownDevice");

        try {
            mpm.shutDown();
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
}
