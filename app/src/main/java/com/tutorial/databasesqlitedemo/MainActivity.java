package com.tutorial.databasesqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {


            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
            myDatabase.execSQL("INSERT INTO Users (name, age) VALUES ('Ibad Nurhamim', '20')");
            myDatabase.execSQL("INSERT INTO Users (name, age) VALUES ('Faiz', '18')");
            myDatabase.execSQL("INSERT INTO Users (name, age) VALUES ('Andi', '20')");

            Cursor cursor = myDatabase.rawQuery("SELECT * FROM Users", null);

            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");

            cursor.moveToFirst();
            while (cursor != null) {
                Log.e("name", cursor.getString(nameIndex));
                Log.e("age", cursor.getString(ageIndex));

                cursor.moveToNext();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}