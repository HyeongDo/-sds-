package com.multi.student.recommend;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView expRecBtn,regRecBtn,bookmarkRecBtn,calRecBtn;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expRecBtn = (ImageView)findViewById(R.id.expRecBtn);
        regRecBtn = (ImageView)findViewById(R.id.regRecBtn);
        bookmarkRecBtn = (ImageView)findViewById(R.id.bookmarkRecBtn);
        calRecBtn = (ImageView)findViewById(R.id.calRecBtn);

        expRecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ExpRecActivity.class);
                startActivity(i);
            }
        });
        regRecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegRecActivity.class);
                startActivity(i);
            }
        });
        bookmarkRecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),BookmarkRecActivity.class);
                startActivity(i);
            }
        });
        calRecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CalRecActivity.class);
                startActivity(i);
            }
        });

        createDB();
    }


//    public void recList(View v){
//        int id = v.getId();
//        if(id == R.id.expRecBtn){
//            Intent i = new Intent(this,ExpRecActivity.class);
//            startActivity(i);
//
//        }else if(id == R.id.regRecBtn){
//            Intent i = new Intent(this,RegRecActivity.class);
//            startActivity(i);
//
//        }else if(id == R.id.bookmarkRecBtn){
//            Intent i = new Intent(this,BookmarkRecActivity.class);
//            startActivity(i);
//        }else{
//            Intent i = new Intent(this,CalRecActivity.class);
//            startActivity(i);
//
//        }
//
//    }

    public void createDB(){
        db = openOrCreateDatabase("foodrec.db", Context.MODE_PRIVATE,null);
       // String q ="drop table foodrec";
       // db.execSQL(q);
    }
    public void createTable(){
        String q = "create table if not exists foodrec3( name text primary key,address text, cal text, ingr text)";
        db.execSQL(q);
    }
    public void insertData(){
        String q = "insert into foodrec3 values('두부조림','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=두부조림','70','두부')";
        db.execSQL(q);
        q = "insert into foodrec3 values('김치찌개','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=김치찌개+만들기','240','김치')";
        db.execSQL(q);
        q = "insert into foodrec3 values('된장찌개','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=된장찌개+만들기','145','된장')";
        db.execSQL(q);
        q = "insert into foodrec3 values('삼겹살 덮밥','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=돼지고기+덮밥','540','돼지고기')";
        db.execSQL(q);
        q = "insert into foodrec3 values('생선조림','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=생선조림','220','생선')";
        db.execSQL(q);
        q = "insert into foodrec3 values('김밥','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=김밥','318','계란')";
        db.execSQL(q);
        q = "insert into foodrec3 values('만두','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=만두','52','돼지고기')";
        db.execSQL(q);
        q = "insert into foodrec3 values('육개장','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=육개장','636','소고기')";
        db.execSQL(q);
        q = "insert into foodrec3 values('달걀조림','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=달걀조림','275','계란')";
        db.execSQL(q);
        q = "insert into foodrec3 values('토마토파스타','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=토마토파스타','800','토마토')";
        db.execSQL(q);
        q = "insert into foodrec3 values('불고기','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=불고기','320','소고기')";
        db.execSQL(q);
        q = "insert into foodrec3 values('돼지불백','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=돼지불백','500','돼지고기')";
        db.execSQL(q);
        q = "insert into foodrec3 values('비빔밥','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=비빔밥','706','야채')";
        db.execSQL(q);
        q = "insert into foodrec3 values('샐러드','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=샐러드','160','야채')";
        db.execSQL(q);
        q = "insert into foodrec3 values('월남쌈','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=월남쌈','432','야채')";
        db.execSQL(q);
        q = "insert into foodrec3 values('찜닭','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=찜닭','480','닭고기')";
        db.execSQL(q);
        q = "insert into foodrec3 values('샤브샤브','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=샤브샤브','264','소고기')";
        db.execSQL(q);
        q = "insert into foodrec3 values('쌀국수','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=쌀국수','320','소고기')";
        db.execSQL(q);
        q = "insert into foodrec3 values('쌈밥','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=쌈밥','315','야채')";
        db.execSQL(q);
        q = "insert into foodrec3 values('삼계탕','https://search.naver.com/search.naver?where=post&sm=tab_jum&query=삼계탕','918','닭고기')";
        db.execSQL(q);

    }

    @Override
    protected void onStart() {
        super.onStart();
//        createTable();
//        insertData();
    }
}
