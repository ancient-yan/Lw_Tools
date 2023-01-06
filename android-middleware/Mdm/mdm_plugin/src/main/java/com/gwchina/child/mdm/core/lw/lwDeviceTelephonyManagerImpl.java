package com.gwchina.child.mdm.core.lw;

import android.annotation.SuppressLint;
import android.app.mia.MiaMdmPolicyManager;
import android.content.Context;
import android.os.Build;

import com.gwchina.child.mdm.core.glDeviceTelephonyManagerImpl;

public class lwDeviceTelephonyManagerImpl extends glDeviceTelephonyManagerImpl {
    MiaMdmPolicyManager mpm;
    Context context;

    public lwDeviceTelephonyManagerImpl(MiaMdmPolicyManager mpm, Context context) {
        this.mpm = mpm;
        this.context = context;
    }

    @SuppressLint("MissingPermission")
    @Override
    public String getSerial() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Build.getSerial();
        }
        return Build.SERIAL;
    }
}
