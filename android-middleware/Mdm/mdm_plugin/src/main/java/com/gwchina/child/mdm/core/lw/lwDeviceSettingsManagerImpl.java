package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

import com.gwchina.child.mdm.core.glDeviceSettingsManagerImpl;

public class lwDeviceSettingsManagerImpl extends glDeviceSettingsManagerImpl {
    MiaMdmPolicyManager mpm;
    Context context;

    public lwDeviceSettingsManagerImpl(MiaMdmPolicyManager mpm, Context context) {
        this.mpm = mpm;
        this.context = context;
    }

    private static final ComponentName componentNameRestoreFactory
            = new ComponentName("com.android.settings", "com.android.settings.Settings$PrivacySettingsActivity");

    @Override
    public boolean setRestoreFactoryDisabled(boolean disable) {
        lwDeviceApplicationManagerImpl.setComponentEnabled(context, componentNameRestoreFactory, !disable);
        return true;
    }

    @Override
    public boolean isRestoreFactoryDisabled() {
        return PackageManager.COMPONENT_ENABLED_STATE_DISABLED
                == context.getPackageManager().getComponentEnabledSetting(componentNameRestoreFactory);
    }
}
