package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.content.ComponentName;
import android.content.Context;

import com.gwchina.child.mdm.core.glDeviceSettingsManagerImpl;

public class lwDeviceSettingsManagerImpl extends glDeviceSettingsManagerImpl {
    MiaMdmPolicyManager mpm;
    Context context;

    public lwDeviceSettingsManagerImpl(MiaMdmPolicyManager mpm, Context context) {
        this.mpm = mpm;
        this.context = context;
    }

    @Override
    public boolean setRestoreFactoryDisabled(boolean disable) {
        lwDeviceApplicationManagerImpl.setComponentEnabled(context,
                new ComponentName("com.android.settings", "com.android.settings.Settings$PrivacySettingsActivity"),
                !disable);
        return true;
    }

    @Override
    public boolean isRestoreFactoryDisabled() {
        return false;
    }
}
