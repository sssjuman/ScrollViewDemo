package com.example.scrollviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_count;
    private ScrollView scrollview;
    private LinearLayout linearlayout;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        tv_count = (TextView) findViewById(R.id.tv_count);
        scrollview = (ScrollView) findViewById(R.id.scrollview);
        linearlayout = (LinearLayout) findViewById(R.id.linearlayout);
    }

    //記得方法要帶參數
    public void onAdd(View v) {
        count++;
        tv_count.setText(String.valueOf(count));

        //動態新增TextView
        TextView textview = new TextView(this);
        textview.setText(String.valueOf(count));
        linearlayout.addView(textview);

        //呼叫post()開一條新的執行緒去做捲動的效果
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}