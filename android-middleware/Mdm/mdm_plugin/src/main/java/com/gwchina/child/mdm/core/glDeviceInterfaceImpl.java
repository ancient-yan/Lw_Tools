package com.gwchina.child.mdm.core;

import android.app.mia.MiaMdmPolicyManager;
import android.content.Context;
import android.util.Log;

import com.gwchina.child.mdm.GwDeviceApplicationManager;
import com.gwchina.child.mdm.GwDeviceCameraManager;
import com.gwchina.child.mdm.GwDeviceControlManager;
import com.gwchina.child.mdm.GwDevicePackageManager;
import com.gwchina.child.mdm.GwDevicePermissionManager;
import com.gwchina.child.mdm.GwDevicePhoneManager;
import com.gwchina.child.mdm.GwDeviceRestrictionManager;
import com.gwchina.child.mdm.GwDeviceSettingsManager;
import com.gwchina.child.mdm.GwDeviceSystemManager;
import com.gwchina.child.mdm.GwDeviceTelephonyManager;
import com.gwchina.child.mdm.GwDeviceVpnManager;
import com.gwchina.child.mdm.core.lw.lwDeviceApplicationManagerImpl;
import com.gwchina.child.mdm.core.lw.lwDeviceControlManagerImpl;
import com.gwchina.child.mdm.core.lw.lwDevicePackageManagerImpl;
import com.gwchina.child.mdm.core.lw.lwDeviceRestrictionManagerImpl;
import com.gwchina.child.mdm.core.lw.lwDeviceSettingsManagerImpl;
import com.gwchina.child.mdm.core.lw.lwDeviceTelephonyManagerImpl;

public class glDeviceInterfaceImpl extends AbstractDeviceInterfaceImpl {
    Context context;

    private GwDeviceApplicationManager mDeviceApplicationManager;

    private GwDeviceControlManager mDeviceControlManager;

    private GwDevicePackageManager mDevicePackageManager;

    private GwDeviceCameraManager mDeviceCameraManager;

    private GwDevicePhoneManager mDevicePhoneManager;

    private GwDeviceRestrictionManager mDeviceRestrictionManager;

    private GwDeviceSettingsManager mDeviceSettingsManager;

    private GwDeviceTelephonyManager mDeviceTelephonyManager;

    public glDeviceInterfaceImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean init(String key) {
        MiaMdmPolicyManager mpm;
        try {
            mpm = new MiaMdmPolicyManager(context.getApplicationContext());
        } catch (Throwable e) {
            Log.e(TAG, "glDeviceInterfaceImpl.init.Throwable : " + e);
            throw new NullPointerException("MiaMdmPolicyManager null");
        }

        mDeviceControlManager = new lwDeviceControlManagerImpl(mpm, context);
        mDeviceRestrictionManager = new lwDeviceRestrictionManagerImpl(mpm);
        mDeviceSettingsManager = new lwDeviceSettingsManagerImpl(mpm);
        mDeviceApplicationManager = new lwDeviceApplicationManagerImpl(mpm, context);
        mDevicePackageManager = new lwDevicePackageManagerImpl(mpm);
        mDeviceTelephonyManager = new lwDeviceTelephonyManagerImpl(mpm, context);

        return true;
    }

    @Override
    public GwDeviceApplicationManager getDeviceApplicationManager() {
        return mDeviceApplicationManager;
    }

    @Override
    public GwDeviceControlManager getDeviceControlManager() {
        return mDeviceControlManager;
    }

    @Override
    public GwDevicePackageManager getDevicePackageManager() {
        return mDevicePackageManager;
    }

    @Override
    public GwDeviceCameraManager getDeviceCameraManager() {
        return null;
    }

    @Override
    public GwDevicePhoneManager getDevicePhoneManager() {
        return null;
    }

    @Override
    public GwDeviceRestrictionManager getDeviceRestrictionManager() {
        return mDeviceRestrictionManager;
    }

    @Override
    public GwDeviceSettingsManager getDeviceSettingsManager() {
        return mDeviceSettingsManager;
    }

    @Override
    public GwDeviceTelephonyManager getDeviceTelephonyManager() {
        return mDeviceTelephonyManager;
    }

    @Override
    public GwDeviceVpnManager getDeviceVpnManager() {
        return null;
    }

    @Override
    public GwDeviceSystemManager getDeviceSystemManager() {
        return null;
    }

    @Override
    public GwDevicePermissionManager getDevicePermissionManager() {
        return null;
    }
}
