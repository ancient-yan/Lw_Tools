package com.gwchina.child.mdm.core.lw;

import android.app.mia.MiaMdmPolicyManager;
import android.util.Log;

import com.gwchina.child.mdm.DeviceService;
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
            mpm.setAdbEnable(disabled);
            if (disabled) {
                DeviceService.getmBinder().setFunctionState(ClientDataParse.testPutValues(9, 0));
            } else {
                DeviceService.getmBinder().setFunctionState(ClientDataParse.testPutValues(9, 1));
            }
        } catch (Throwable e) {
            Log.e(TAG, "setAdbDisabled : " + e);
        }
    }

    @Override
    public boolean isAdbDisabled() {
        Log.i(TAG, "isAdbDisabled");

        try {
            int nRet = DeviceService.getmBinder().getFunctionState(ClientDataParse.testGetFunction(9));
            Log.i(TAG, "isAdbDisabled : " + nRet);
            return (0 == nRet);
        } catch (Throwable e) {
            Log.e(TAG, "isAdbDisabled : " + e);
        }

        return super.isAdbDisabled();
    }

    @Override
    public void setStatusBarExpandPanelDisabled(boolean disabled) {
        Log.i(TAG, "setStatusBarExpandPanelDisabled : " + disabled);

        try {
            mpm.setStatusBar(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setStatusBarExpandPanelDisabled : " + e);
        }
    }

    @Override
    public boolean isStatusBarExpandPanelDisabled() {
        Log.i(TAG, "isStatusBarExpandPanelDisabled");

        try {
            return !mpm.isControlStatus();
        } catch (Throwable e) {
            Log.e(TAG, "isStatusBarExpandPanelDisabled : " + e);
        }

        return super.isStatusBarExpandPanelDisabled();
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
    public boolean isHomeButtonDisabled() {
        Log.i(TAG, "isHomeButtonDisabled");

        try {
            return !mpm.isControlHomeKey();
        } catch (Throwable e) {
            Log.e(TAG, "isHomeButtonDisabled : " + e);
        }

        return super.isHomeButtonDisabled();
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
    public boolean isTaskButtonDisabled() {
        Log.i(TAG, "isTaskButtonDisabled");

        try {
            return !mpm.isControlRecentsKey();
        } catch (Throwable e) {
            Log.e(TAG, "isTaskButtonDisabled : " + e);
        }

        return super.isTaskButtonDisabled();
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

        try {
            mpm.setOnlyCharging(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setUSBDataDisabled : " + e);
        }
    }

    @Override
    public boolean isUSBDataDisabled() {
        Log.i(TAG, "isUSBDataDisabled");

        try {
            return mpm.isUsbOnlyCharging();
        } catch (Throwable e) {
            Log.e(TAG, "isUSBDataDisabled : " + e);
        }

        return super.isUSBDataDisabled();
    }

    @Override
    public void setUSBOtgDisabled(boolean disabled) {
        Log.i(TAG, "setUSBOtgDisabled : " + disabled);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "setUSBOtgDisabled : " + e);
        }
    }

    @Override
    public boolean isUSBOtgDisabled() {
        Log.i(TAG, "isUSBOtgDisabled");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "isUSBOtgDisabled : " + e);
        }

        return super.isUSBOtgDisabled();
    }
}
