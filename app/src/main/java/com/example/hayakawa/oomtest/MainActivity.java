package com.example.hayakawa.oomtest;

import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClicked();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClicked(){

//        List<ByteBuffer> buffers = new ArrayList<>();
//        Runtime runtime = Runtime.getRuntime();
//        for (int idx = 0; idx < 100; idx++){
//            ByteBuffer buf = ByteBuffer.allocateDirect(10 * 1024 * 1024);
//            buffers.add(buf);
//            Log.d("Runtime", "使用中Javaメモリ" + (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024) + "kb");
//                    String memory = "空きネイティブヒープ=" + Long.toString(Debug.getNativeHeapFreeSize() / 1024) + "kb" + // 空きヒープサイズ
//                            ", 使用中ネイティブヒープ=  " + Long.toString(Debug.getNativeHeapAllocatedSize() / 1024) + "kb" + // 使用中ピープサイズ
//                            ", 確保したネイティブヒープ=" + Long.toString(Debug.getNativeHeapSize() / 1024) + "kb"; // 確保しているヒープサイズ
//                    Log.d("Heap", memory);
//        }
        ByteBuffer.allocateDirect(10*1024*1024);
        Runtime runtime = Runtime.getRuntime();

        while (true){

            Log.d("Runtime", "使用中Javaメモリ" + (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024) + "kb");
//            Log.d("Heap", "使用中Nativeメモリ" + Long.toString(Debug.getNativeHeapAllocatedSize() / 1024) + "kb");

        }

            }
        }

