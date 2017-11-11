package com.example.buscardzz.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlHelper extends SQLiteOpenHelper {
    /**
     * 书籍类型表: booktype id typename：类型
     */

    public MySqlHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    public void onCreate(SQLiteDatabase db) {
        /*
      线路号表
     */
        String sql1 = "create table stationline(id integer primary key autoincrement,LineWord,StationUpLast,StationDownLast)";
        db.execSQL(sql1);
        /*
      上行线路
     */
        String sql2 = "create table stationlines(id integer primary key autoincrement,StationName,StationDULNo)";
        db.execSQL(sql2);
        /*
      下行线路
     */
        String sql3 = "create table stationlinex(id integer primary key autoincrement,StationName,StationDULNo)";
        db.execSQL(sql3);
        /*
      服务用语
     */
        String sql4 = "create table servletmsg(id,context)";
        db.execSQL(sql4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

}
