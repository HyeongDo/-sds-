package com.multi.student.sqliteproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView result;
    SQLiteDatabase db;//db 작업(insert, select, delete....)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView)findViewById(R.id.result);
    }
    //1. db 생성
    public void createDB(View v){
        db = openOrCreateDatabase("member.db", Context.MODE_PRIVATE,null);
    }
    public void createTable(View v){
        String q = "create table if not exists member(_id text primary key,"+" name text, address text)";
        db.execSQL(q);
        Log.i("sqlite::::::","table creation success");
    }
    public void insertData(View v){
        String q = "insert into member values('100', 'tommy','seoul')";
        db.execSQL(q);

        q = "insert into member values('200', 'jane','paris')";
        db.execSQL(q);
        q = "insert into member values('300', 'bill jones','london')";
        db.execSQL(q);

    }
    public void selectData(View v){
        String q = "select * from member";
        Cursor cursor = db.rawQuery(q,null);
        String msg = "";

        if(cursor != null){
            while(cursor.moveToNext()){
                String num = cursor.getString(0);
                String name = cursor.getString(1);
                String address = cursor.getString(2);

                msg += num + "--" + name + "--" + address + "\n";

            }
            result.setText(msg);
        }
        db.close();
    }
}
