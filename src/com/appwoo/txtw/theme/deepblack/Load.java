package com.appwoo.txtw.theme.deepblack;

public class Load {
	static { 
        System.loadLibrary("my-ndk");//����so
    }
    public native int addInt(int a, int b); //���÷���
    public native String Mkdir(); //���÷���
}
