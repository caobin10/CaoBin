package net.yrom.screenrecorder.db.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Administrator on 2021/2/8.
 */

public class MyDbHelper extends SQLiteOpenHelper {
    //数据库名字
    public static final String DB_NAME = "my.db";

    //数据库版本
    public static final int DB_VERSION = 1;

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * 在数据库首次创建的时候调用，创建表以及可以进行一些表数据的初始化
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        //_id为主键并且自增长一般命名为_id
        String sql = "create table person(_id integer primary key autoincrement,name text)";
        db.execSQL(sql);

        //可以给表初始化一些数据
        //db.execSQL("insert into person(name) values('小米')");
    }

    /**
     * 数据库升级的时候回调该方法，在数据库版本号DB_VERSION升级的时候才会调用
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //给表添加一个字段
        //db.execSQL("alter table person add age integer");
    }

    /**
     * 数据库打开的时候回调该方法
     *
     * @param db
     */
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.e("xyh", "onOpen: ");
    }
}
