package com.gwchina.child.mdm;

import android.app.IMiddlewareService;
import android.app.Service;
import android.app.hwMDM;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.gwchina.child.mdm.core.glDeviceInterfaceImpl;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

public class DeviceService extends Service implements ServiceConnection {
    private final static String TAG = "my_mdm";
    private final static String action = "com.txtw.lwmiddleware.action.MiddlewareService";
    private final static String action2 = "com.txtw.lwmiddleware.action.MiddlewareService.hw";
    private final static String Serviceclass = "com.gwchina.lssw.child.hw.MiddlewareService";
    private final static String Serviceclass2 = "com.gwchina.lssw.child.hw.hwMDMService";
    private GwDeviceInterface.Stub mStub;
    private static IMiddlewareService mBinder;
    private static hwMDM mBinder2;
    private Disposable mConnectDisposable;

    public static void unsubscribeIfNotNull(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public static IMiddlewareService getmBinder() {
        return mBinder;
    }

    public static hwMDM getmBinder2() {
        return mBinder2;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, intent.toString());
        if (mStub == null) {
            newBinder();
        }
        Log.d(TAG, "onBind");
        return mStub;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind=" + intent.toString());
        mStub = null;
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        mStub = new glDeviceInterfaceImpl(this);
        Log.i(TAG, "DeviceService onCreate");
        connect();
    }

    private void startService() {
        Intent intent = new Intent(action);

        String strPackageName = "com.gwchina.lssw.child.hw";
        intent.setPackage(strPackageName);
        boolean bRet = bindService(intent, this, Context.BIND_AUTO_CREATE);
        Log.i(TAG, strPackageName + " : " + bRet);
    }

    private void startService2() {
        Intent intent = new Intent(action2);

        String strPackageName = "com.gwchina.lssw.child.hw";
        intent.setPackage(strPackageName);
        boolean bRet = bindService(intent, this, Context.BIND_AUTO_CREATE);
        Log.i(TAG, strPackageName + " :.hw " + bRet);
    }

    void connect() {
        unsubscribeIfNotNull(mConnectDisposable);
        mConnectDisposable = Flowable.interval(0, 3, TimeUnit.SECONDS).subscribe(aLong -> {
            if (mBinder == null) {
                Log.i(TAG, "绑定Lw MDM服务");
                startService();
            }

            if (mBinder2 == null) {
                Log.i(TAG, "绑定Lw2 MDM服务");
                startService2();
            }
        }, throwable -> Log.e(TAG, "连接Lw MDM异常 : " + throwable));
    }

    private void newBinder() {
        mStub = new glDeviceInterfaceImpl(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "DeviceService onDestroy");
        super.onDestroy();
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.i(TAG, "onServiceConnected : " + name.getClassName());

        if (Serviceclass.equals(name.getClassName())) {
            mBinder = IMiddlewareService.Stub.asInterface(service);
        } else if (Serviceclass2.equals(name.getClassName())) {
            mBinder2 = hwMDM.Stub.asInterface(service);
        }

        if (mBinder != null && mBinder2 != null)
            unsubscribeIfNotNull(mConnectDisposable);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.i(TAG, "onServiceDisconnected : " + name.getClassName());

        if (Serviceclass.equals(name.getClassName())) {
            mBinder = null;
            connect();
            return;
        }

        if (Serviceclass2.equals(name.getClassName())) {
            mBinder2 = null;
            connect();
            return;
        }
    }
}
