package com.gwchina.child.mdm.core.lw;

import android.util.Log;

import com.gwchina.child.mdm.DeviceService;
import com.gwchina.child.mdm.core.glDeviceRestrictionManagerImpl;

public class lwDeviceRestrictionManagerImpl extends glDeviceRestrictionManagerImpl {
    @Override
    public void setAdbDisabled(boolean disabled) {
        Log.i(TAG, "setAdbDisabled : " + disabled);

        try {
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
        } catch (Throwable e) {
            Log.e(TAG, "setStatusBarExpandPanelDisabled : " + e);
        }
    }

    @Override
    public boolean isStatusBarExpandPanelDisabled() {
        Log.i(TAG, "isStatusBarExpandPanelDisabled");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "isStatusBarExpandPanelDisabled : " + e);
        }

        return super.isStatusBarExpandPanelDisabled();
    }

    @Override
    public void setHomeButtonDisabled(boolean disabled) {
        Log.i(TAG, "setHomeButtonDisabled : " + disabled);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "setHomeButtonDisabled : " + e);
        }
    }

    @Override
    public boolean isHomeButtonDisabled() {
        Log.i(TAG, "isHomeButtonDisabled");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "isHomeButtonDisabled : " + e);
        }

        return super.isHomeButtonDisabled();
    }

    @Override
    public void setTaskButtonDisabled(boolean disabled) {
        Log.i(TAG, "setTaskButtonDisabled : " + disabled);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "setTaskButtonDisabled : " + e);
        }
    }

    @Override
    public boolean isTaskButtonDisabled() {
        Log.i(TAG, "isTaskButtonDisabled");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "isTaskButtonDisabled : " + e);
        }

        return super.isTaskButtonDisabled();
    }

    @Override
    public void setBackButtonDisabled(boolean disabled) {
        Log.i(TAG, "setBackButtonDisabled : " + disabled);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "setBackButtonDisabled : " + e);
        }
    }

    @Override
    public boolean isBackButtonDisabled() {
        Log.i(TAG, "isBackButtonDisabled");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "isBackButtonDisabled : " + e);
        }

        return super.isBackButtonDisabled();
    }

    @Override
    public void setSafeModeDisabled(boolean disabled) {
        Log.i(TAG, "setSafeModeDisabled : " + disabled);

        try {
        } catch (Throwable e) {
            Log.e(TAG, "setSafeModeDisabled : " + e);
        }
    }

    @Override
    public boolean isSafeModeDisabled() {
        Log.i(TAG, "isSafeModeDisabled");

        try {
        } catch (Throwable e) {
            Log.e(TAG, "isSafeModeDisabled : " + e);
        }

        return super.isSafeModeDisabled();
    }

    @Override
    public void setUSBDataDisabled(boolean disabled) {
        Log.i(TAG, "setUSBDataDisabled : " + disabled);

        try {
            if (disabled) {
                DeviceService.getmBinder().setFunctionState(ClientDataParse.testPutValues(10, 0));
            } else {
                DeviceService.getmBinder().setFunctionState(ClientDataParse.testPutValues(10, 1));
            }
        } catch (Throwable e) {
            Log.e(TAG, "setUSBDataDisabled : " + e);
        }
    }

    @Override
    public boolean isUSBDataDisabled() {
        Log.i(TAG, "isUSBDataDisabled");

        try {
            int nRet = DeviceService.getmBinder().getFunctionState(ClientDataParse.testGetFunction(10));
            Log.i(TAG, "isUSBDataDisabled : " + nRet);
            return (0 == nRet);
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
