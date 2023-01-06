package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import com.gwchina.child.mdm.core.glDeviceControlManagerImpl;

public class lwDeviceControlManagerImpl extends glDeviceControlManagerImpl {
    MiaMdmPolicyManager mpm;
    Context context;

    public lwDeviceControlManagerImpl(MiaMdmPolicyManager mpm, Context context) {
        this.mpm = mpm;
        this.context = context;
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

    @Override
    public void turnOnGPS(boolean on) {
        if (on)
            Settings.Secure.putInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE, Settings.Secure.LOCATION_MODE_HIGH_ACCURACY);
        else
            Settings.Secure.putInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE, Settings.Secure.LOCATION_MODE_OFF);
    }
}
