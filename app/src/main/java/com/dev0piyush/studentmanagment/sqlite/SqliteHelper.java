package com.dev0piyush.studentmanagment.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class SqliteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="user.db";
    public SqliteHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE USER(FNAME VARCHAR(20),LNAME VARCHAR(20),EMAIL VARHCAR(42) PRIMARY KEY,MOBILE VARCHAR(10),PASSWORD VARCHAR(12))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
    }

    public boolean InsertData(String FName, String LName, String Email, String Mobile, String Password){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("fName",FName);
        contentValues.put("lName",LName);
        contentValues.put("email",Email);
        contentValues.put("mobile",Mobile);
        contentValues.put("password",Password);
        long result = sqLiteDatabase.insert("USER",null,contentValues);
        return result != -1;
    }

    public Boolean CheckEmail(String Email){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM USER WHERE EMAIL=?",new String[]{Email});
        return cursor.getCount() > 0;
    }

    public Boolean CheckEmailPassword(String Email,String Password){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM USER WHERE EMAIL=? AND PASSWORD=?",new String[]{Email,Password});
        return cursor.getCount() > 0;
    }
}
