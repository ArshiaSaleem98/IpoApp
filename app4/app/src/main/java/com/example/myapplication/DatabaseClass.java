package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;


public class DatabaseClass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "retree.db";
    public static final String TABLE_NAME = "registeruser";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";


    public DatabaseClass(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public long insertData(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,user);
        contentValues.put(COL_3,password);
        long res = db.insert("registeruser" ,null,contentValues);
        db.close();
        return res;





    }

    public boolean checkuser(String username, String password){
        String[] columns = {COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection= COL_2 + "=?" +" and " + COL_3+"=?";
        String[] selectionArgs={username,password};
        Cursor res = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count= res.getCount();
        res.close();
        db.close();

        if(count>0){
            return true;

        }else
            return false;


    }




}
