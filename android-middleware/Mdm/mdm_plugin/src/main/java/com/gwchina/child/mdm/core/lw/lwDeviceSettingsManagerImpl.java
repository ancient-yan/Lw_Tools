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
//            mpm.setReset(disable);
        } catch (Throwable e) {
            Log.e(TAG, "setRestoreFactoryDisabled : " + e);
        }

        return super.setRestoreFactoryDisabled(disable);
    }
}
