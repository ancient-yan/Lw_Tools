package com.appwoo.txtw.theme.deepblack;

public class Load {
	static { 
        System.loadLibrary("my-ndk");//加载so
    }
    public native int addInt(int a, int b); //调用方法
    public native String Mkdir(); //调用方法
}
