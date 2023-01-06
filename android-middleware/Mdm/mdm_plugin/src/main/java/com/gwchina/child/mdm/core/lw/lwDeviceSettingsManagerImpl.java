package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;

import com.gwchina.child.mdm.core.glDeviceSettingsManagerImpl;

public class lwDeviceSettingsManagerImpl extends glDeviceSettingsManagerImpl {
    MiaMdmPolicyManager mpm;

    public lwDeviceSettingsManagerImpl(MiaMdmPolicyManager mpm) {
        this.mpm = mpm;
    }
}
