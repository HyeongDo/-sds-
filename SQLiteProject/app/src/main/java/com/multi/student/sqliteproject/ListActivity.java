package com.multi.student.sqliteproject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView list;
    SQLiteDatabase db;//db 작업(insert, select, delete....)
    ArrayList<String> data;//data 저장하고 있는 객체
    ArrayAdapter<String> adapter;//ListView 관리자



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (ListView)findViewById(R.id.list);
        data = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_2,//listview의 item에 사용할 Layout xmL
                android.R.id.text1,
                data
        );
        list.setAdapter(adapter); //어댑터지정필수

    }
    @Override
    protected void onStart() {
        super.onStart();
        createDB();
        createTable();
        selectData();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,1,"Add Data");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this,InsertActivity.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }

    //1. db 생성
    public void createDB(){
        db = openOrCreateDatabase("member2.db", Context.MODE_PRIVATE,null);
    }
    public void createTable(){
        String q = "create table if not exists member(_id text primary key,"+" name text, address text)";
        db.execSQL(q);
        Log.i("sqlite::::::","table creation success");
    }
    public void insertData(){
        String q = "insert into member values('400', 'hill','seoul')";
        db.execSQL(q);
        q = "insert into member values('533', 'kim','paris')";
        db.execSQL(q);
        q = "insert into member values('625', 'ford','london')";
        db.execSQL(q);

    }
    public void selectData(){
        String q = "select * from member order by _id";
        data.clear();

        //select 실행 후에 db가 돌려주는 것.
        Cursor cursor = db.rawQuery(q,null);
        String msg = "";

        if(cursor != null){
            while(cursor.moveToNext()){
                String num = cursor.getString(0);
                String name = cursor.getString(1);
                String address = cursor.getString(2);

                data.add(num + "--" + name + "--" + address + "\n");

            }
            adapter.notifyDataSetChanged();
        }
        db.close();
    }
}
