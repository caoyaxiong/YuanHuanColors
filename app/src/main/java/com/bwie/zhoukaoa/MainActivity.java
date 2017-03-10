package com.bwie.zhoukaoa;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private  JuXing ju;
    Handler han=new Handler(){

        private Paint paint;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                String st = tv.getText().toString();
                if (st.equals("#FF0000")) {
                    tv.setText("#FFFF00");
                    ju.SetColor(st);
                } else {
                    tv.setText("#FF0000");
                    ju.SetColor(st);
                }
                init();
            }else {

            }


        }
    };
    private SharedPreferences sha;
    private SharedPreferences.Editor ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sha = getSharedPreferences("user",MODE_PRIVATE);
        ed = sha.edit();
        initView();
        init();
        ju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean f=sha.getBoolean("user",false);
                if (f==false){
                    han.removeMessages(1);
                    ed.putBoolean("user",true).commit();
                }else {
                    init();
                    ed.putBoolean("user",false).commit();
                }

            }
        });

    }

    private void initView() {
        ju = (JuXing) findViewById(R.id.ju);
        tv = (TextView) findViewById(R.id.tv);


    }
    private void init(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                han.sendEmptyMessageDelayed(1,3000);
            }
        });
    }

}
