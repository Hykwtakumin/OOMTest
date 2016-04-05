package com.example.hayakawa.oomtest;
import android.os.Debug;
import android.util.Log;

import javassist.ClassPool;

/**
 * Created by hayakawa on 2016/04/05.
 */
public class OOMSample {
    public static void main(String[] args) {
        new Exception().printStackTrace();
        try {
            ClassPool pool = ClassPool.getDefault();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                String className = String.format("MyClass%d", i);
                pool.makeClass(className).toClass();
                Runtime runtime = Runtime.getRuntime();
                Log.d("Runtime", "使用中Javaメモリ" + (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024) + "kb");

                String memory = "空きネイティブヒープ=" + Long.toString(Debug.getNativeHeapFreeSize() / 1024) + "kb" + // 空きヒープサイズ
                        ", 使用中ネイティブヒープ=  " + Long.toString(Debug.getNativeHeapAllocatedSize() / 1024) + "kb" + // 使用中ピープサイズ
                        ", 確保したネイティブヒープ=" + Long.toString(Debug.getNativeHeapSize() / 1024) + "kb"; // 確保しているヒープサイズ
                Log.d("Heap", memory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}