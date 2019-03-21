package com.example.dinesh.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.sql.SQLClientInfoException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,age INTEGER(3),id INTEGER PRIMARY KEY)");

            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Dinu',21)");

            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Tommy',5)");

            myDatabase.execSQL("DELETE FROM users WHERE id = 1");

            Cursor c = myDatabase.rawQuery("SELECT * FROM users",null);

            int nameIndex = c.getColumnIndex("name");

            int ageIndex = c.getColumnIndex("age");

            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();

            while(c != null){

                Log.i("name",c.getString(nameIndex));

                Log.i("age",Integer.toString(c.getInt(ageIndex)));

                Log.i("id",Integer.toString(c.getInt(idIndex)));

                c.moveToNext();
            }

        }
        catch (Exception e){

            e.printStackTrace();
        }
    }
}
