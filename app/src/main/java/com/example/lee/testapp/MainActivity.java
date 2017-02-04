package com.example.lee.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    static {
        /*
        加载动态库，动态库加载的时候 JNI_OnLoad函数会被调用

        在JNI——OnLoad函数中，Java虚拟机通过函数表的形式将JNI函数和java类中native函数对应起来
         */
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView= (TextView) findViewById(R.id.tv);
        textView.setText(GetStrFromJNI());
    }

    /*
    Jni 函数的声明
    当调用到此函数时，java虚拟机会通过JNI_OnLoad里注册的函数表找到对应的函数去执行
     */
    private native String GetStrFromJNI();
}
