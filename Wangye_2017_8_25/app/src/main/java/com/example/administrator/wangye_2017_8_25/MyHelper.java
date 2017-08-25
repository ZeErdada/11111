package com.example.administrator.wangye_2017_8_25;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 2017/8/21.
 */

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context) {
        super(context,"yuekao", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table yuekaodb(title text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
