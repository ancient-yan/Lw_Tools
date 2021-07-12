package com.gwchina.child.mdm.core.lw;

import android.util.Log;

import com.gwchina.child.mdm.DeviceService;
import com.gwchina.child.mdm.core.glDeviceRestrictionManagerImpl;

public class lwDeviceRestrictionManagerImpl extends glDeviceRestrictionManagerImpl {
    @Override
    public void setAdbDisabled(boolean disabled) {
        Log.i(TAG, "setAdbDisabled : " + disabled);

        try {
            DeviceService.getmBinder2().setAdbDisabled(disabled);
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
            return DeviceService.getmBinder2().isAdbDisabled();
        } catch (Throwable e) {
            Log.e(TAG, "isAdbDisabled : " + e);
        }

        return super.isAdbDisabled();
    }

    @Override
    public void setStatusBarExpandPanelDisabled(boolean disabled) {
        Log.i(TAG, "setStatusBarExpandPanelDisabled : " + disabled);

        try {
            DeviceService.getmBinder2().setStatusBarExpandPanelDisabled(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setStatusBarExpandPanelDisabled : " + e);
        }
    }

    @Override
    public boolean isStatusBarExpandPanelDisabled() {
        Log.i(TAG, "isStatusBarExpandPanelDisabled");

        try {
            return DeviceService.getmBinder2().isStatusBarExpandPanelDisabled();
        } catch (Throwable e) {
            Log.e(TAG, "isStatusBarExpandPanelDisabled : " + e);
        }

        return super.isStatusBarExpandPanelDisabled();
    }

    @Override
    public void setHomeButtonDisabled(boolean disabled) {
        Log.i(TAG, "setHomeButtonDisabled : " + disabled);

        try {
            DeviceService.getmBinder2().setHomeButtonDisabled(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setHomeButtonDisabled : " + e);
        }
    }

    @Override
    public boolean isHomeButtonDisabled() {
        Log.i(TAG, "isHomeButtonDisabled");

        try {
            return DeviceService.getmBinder2().isHomeButtonDisabled();
        } catch (Throwable e) {
            Log.e(TAG, "isHomeButtonDisabled : " + e);
        }

        return super.isHomeButtonDisabled();
    }

    @Override
    public void setTaskButtonDisabled(boolean disabled) {
        Log.i(TAG, "setTaskButtonDisabled : " + disabled);

        try {
            DeviceService.getmBinder2().setTaskButtonDisabled(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setTaskButtonDisabled : " + e);
        }
    }

    @Override
    public boolean isTaskButtonDisabled() {
        Log.i(TAG, "isTaskButtonDisabled");

        try {
            return DeviceService.getmBinder2().isTaskButtonDisabled();
        } catch (Throwable e) {
            Log.e(TAG, "isTaskButtonDisabled : " + e);
        }

        return super.isTaskButtonDisabled();
    }

    @Override
    public void setBackButtonDisabled(boolean disabled) {
        Log.i(TAG, "setBackButtonDisabled : " + disabled);

        try {
            DeviceService.getmBinder2().setBackButtonDisabled(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setBackButtonDisabled : " + e);
        }
    }

    @Override
    public boolean isBackButtonDisabled() {
        Log.i(TAG, "isBackButtonDisabled");

        try {
            return DeviceService.getmBinder2().isBackButtonDisabled();
        } catch (Throwable e) {
            Log.e(TAG, "isBackButtonDisabled : " + e);
        }

        return super.isBackButtonDisabled();
    }

    @Override
    public void setSafeModeDisabled(boolean disabled) {
        Log.i(TAG, "setSafeModeDisabled : " + disabled);

        try {
            DeviceService.getmBinder2().setSafeModeDisabled(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setSafeModeDisabled : " + e);
        }
    }

    @Override
    public boolean isSafeModeDisabled() {
        Log.i(TAG, "isSafeModeDisabled");

        try {
            return DeviceService.getmBinder2().isSafeModeDisabled();
        } catch (Throwable e) {
            Log.e(TAG, "isSafeModeDisabled : " + e);
        }

        return super.isSafeModeDisabled();
    }

    @Override
    public void setUSBDataDisabled(boolean disabled) {
        Log.i(TAG, "setUSBDataDisabled : " + disabled);

        try {
            DeviceService.getmBinder2().setUSBDataDisabled(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setUSBDataDisabled : " + e);
        }
    }

    @Override
    public boolean isUSBDataDisabled() {
        Log.i(TAG, "isUSBDataDisabled");

        try {
            return DeviceService.getmBinder2().isUSBDataDisabled();
        } catch (Throwable e) {
            Log.e(TAG, "isUSBDataDisabled : " + e);
        }

        return super.isUSBDataDisabled();
    }

    @Override
    public void setUSBOtgDisabled(boolean disabled) {
        Log.i(TAG, "setUSBOtgDisabled : " + disabled);

        try {
            DeviceService.getmBinder2().setUSBOtgDisabled(disabled);
        } catch (Throwable e) {
            Log.e(TAG, "setUSBOtgDisabled : " + e);
        }
    }

    @Override
    public boolean isUSBOtgDisabled() {
        Log.i(TAG, "isUSBOtgDisabled");

        try {
            return DeviceService.getmBinder2().isUSBOtgDisabled();
        } catch (Throwable e) {
            Log.e(TAG, "isUSBOtgDisabled : " + e);
        }

        return super.isUSBOtgDisabled();
    }
}
