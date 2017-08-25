package com.example.administrator.wangye_2017_8_25;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView huancundaxiao;
    private TextView qinglihuancun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        huancundaxiao = (TextView) findViewById(R.id.huancun1);
        qinglihuancun = (TextView) findViewById(R.id.huancun2);
        //获得缓存大小
        try {
            huancundaxiao.setText(DataCleanManager.getTotalCacheSize(this));
        } catch (Exception e) {
        }

        //清理缓存
        qinglihuancun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataCleanManager.clearAllCache(Main2Activity.this);
                try {
                    huancundaxiao.setText(DataCleanManager.getTotalCacheSize(Main2Activity.this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
