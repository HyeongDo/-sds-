package com.multi.student.recommend;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalRecActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Myitem> plist; //data
    Myadapter adapter;//adapter 관리자
    TextView recAddress;
    String[] arr = new String[50];

    String[] link = new String[50];
    String date,like,prod;
    String [] name = new String[50];
    String [] address = new String[50];
    String [] cal = new String[50];
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_rec);
        listView = (ListView)findViewById(R.id.listView);
        recAddress =(TextView)findViewById(R.id.recAddress);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(arr[position+1]));
                startActivity(i);
            }
        });
        createDBmember();
        String temp = selectDataMember();
        createDB();
        selectData(temp);
        int draw=R.mipmap.dish;
        if(name[0].equals("김치찌개")){
            draw = R.mipmap.kimchisoupp;
        }else if(name[0].equals("두부조림")){
            draw = R.mipmap.beancurd;
        }else if(name[0].equals("불고기")){
            draw = R.mipmap.bulgogi;
        }else if(name[0].equals("된장찌개")){
            draw = R.mipmap.daenjangsoup;
        }else if(name[0].equals("생선조림")){
            draw = R.mipmap.fishjolim;
        }else if(name[0].equals("찜닭")){
            draw = R.mipmap.jjimdack;
        }else if(name[0].equals("김밥")){
            draw = R.mipmap.kimbap;
        }else if(name[0].equals("만두")){
            draw = R.mipmap.mandoo;
        }else if(name[0].equals("샐러드")){
            draw = R.mipmap.salad;
        }else if(name[0].equals("삼계탕")){
            draw = R.mipmap.samgaetang;
        }else if(name[0].equals("육개장")){
            draw = R.mipmap.yukgaejang;
        }else if(name[0].equals("비빔밥")){
            draw = R.mipmap.bibimbab;
        }else if(name[0].equals("월남쌈")){
            draw = R.mipmap.walnamsam;
        }else if(name[0].equals("삼겹살 덮밥")){
            draw = R.mipmap.chashu;
        }else if(name[0].equals("토마토파스타")){
            draw = R.mipmap.pasta;
        }else if(name[0].equals("쌀국수")){
            draw = R.mipmap.ricenodle;
        }else if(name[0].equals("돼지불백")){
            draw = R.mipmap.pigbulbaeg;
        }else if(name[0].equals("달걀조림")){
            draw = R.mipmap.eggjolim;
        }else if(name[0].equals("샤브샤브")){
            draw = R.mipmap.sabsab;
        }else if(name[0].equals("쌈밥")){
            draw = R.mipmap.sambap;
        }
        plist = new ArrayList<>();
        Myitem p1 = new Myitem(draw,name[0], address[0], cal[0]);
        //1.data 준비
//        Myitem p1 = new Myitem(R.mipmap.ic_launcher,"김치","http://m.naver.com/","2800");
//        Myitem p2 = new Myitem(R.mipmap.ic_launcher_round,"감자","http://www.sangmyeong.ac.kr","3000");
//        Myitem p3 = new Myitem(R.mipmap.ic_launcher_round,"고구마","http://www.multicampus.co.kr","333");

        plist.add(p1);
//        plist.add(p2);
//        plist.add(p3);
        arr[1]=p1.getAddress();
//        arr[2]=p2.getAddress();
//        arr[3]=p3.getAddress();

        //2.adapter
        adapter = new Myadapter(
                this, //Activity
                R.layout.activity_mylist, //ListView 안에 들어가는 item을 위한 xml
                plist //data가 들어 있는 ArrayList
        );

        //3.Listview에 adapter 지정
        listView.setAdapter(adapter);


    }
    public void createDB(){
        db = openOrCreateDatabase("foodrec.db", Context.MODE_PRIVATE,null);

    }
    public void createDBmember(){
        db = openOrCreateDatabase("member.db",Context.MODE_PRIVATE,null);
    }
    public String selectDataMember(){
        String q = "select* from member2 order by cal";
        Cursor cursor = db.rawQuery(q,null);
        cursor.moveToNext();
        String memname = cursor.getString(0);
//        Toast.makeText(this, memname, Toast.LENGTH_LONG).show();
        db.close();
        return "소고기";
    }
    public void selectData(String q2){

        String q = "select * from foodrec3 where ingr = '"+q2+"' order by cal" ;
        //       plist.clear();

        //select 실행 후에 db가 돌려주는 것.
        Cursor cursor = db.rawQuery(q,null);
        int i=0;

        if(cursor != null){
            while(cursor.moveToNext()){
                name[i] = cursor.getString(0);
                address[i]  = cursor.getString(1);
                cal[i] = cursor.getString(2);
                i++;
            }
//            adapter.notifyDataSetChanged();
        }
        db.close();
    }
}
