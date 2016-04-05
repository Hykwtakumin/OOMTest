package com.example.hayakawa.oomtest;

import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //スレッドを作り続ける
                while (true) {
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                    Runtime runtime = Runtime.getRuntime();
                    Log.d("Runtime", "使用中Javaメモリ" + (int)( (runtime.totalMemory() - runtime.freeMemory())/1024) + "kb" );

                    String memory = "空きネイティブヒープ=" + Long.toString(Debug.getNativeHeapFreeSize() / 1024) + "kb" + // 空きヒープサイズ
                            ", 使用中ネイティブヒープ=  " + Long.toString(Debug.getNativeHeapAllocatedSize() / 1024) + "kb" + // 使用中ピープサイズ
                            ", 確保したネイティブヒープ=" + Long.toString(Debug.getNativeHeapSize() / 1024) + "kb"; // 確保しているヒープサイズ
                    Log.d("Heap", memory);

                }
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
}
