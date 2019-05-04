package com.multi.student.sqliteproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    EditText userid, username, useraddress;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        userid = (EditText)findViewById(R.id.userid);
        username = (EditText)findViewById(R.id.username);
        useraddress = (EditText)findViewById(R.id.useraddress);

        createDB();
    }
    //1. db 생성
    public void createDB(){
        db = openOrCreateDatabase("member.db", Context.MODE_PRIVATE,null);
    }
    public void insert(View v){
        String uid = userid.getText().toString();
        String uname = username.getText().toString();
        String uaddress = useraddress.getText().toString();

        ContentValues val = new ContentValues();
        val.put("_id",uid);
        val.put("name",uname);
        val.put("address",uaddress);

        db.insert("member",null,val);
        userid.setText("");
        username.setText("");
        useraddress.setText("");

        finish();
    }

}
