package com.multi.student.recommend;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;


public class ExpRecActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Myitem> plist; //data
    Myadapter adapter;//adapter 관리자
    TextView recAddress;
    String[] link = new String[50];
    String date,like,prod;
    String [] name = new String[50];
    String [] address = new String[50];
    String [] cal = new String[50];
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_rec);
        listView = (ListView) findViewById(R.id.listView);
        recAddress = (TextView) findViewById(R.id.recAddress);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(link[position + 1]));
                //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
                startActivity(i);
            }
        });
        /*
        * 이부분에 기능 DB받아서 재료,유통기한(여기액티비티는 유통기한),즐겨찾기,칼로리
        * 변수에 넣어서 따로 셀렉트.
        * create 아니면 open MenuDB(); -> 메뉴 DB 생성
        * selectMenuData() -> 셀렉트 유통기한 별 정렬하여 유통기한 얼마 남지 않은 재료 1개 선택
        * 그 재료에 맞는 추천음식 1개 보여준다.
        * */
        createDBmember();
        String temp = selectDataMember();
        createDB();
        selectData(temp);
        /*
        create멤버

        String memberName = select * from member orber by 유통기한;
        insertData 메소드에 아래 셀렉트 넣는다.
        //select * from foodrec3 where ingr = '"+memberName+"' order by name;
        if(memberName.equals("김치"){select * from foodrec3 where "}
        * */
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
        //1.data 준비
        Myitem p1 = new Myitem(draw,name[0], address[0], cal[0]);
//        Myitem p2 = new Myitem(R.mipmap.chicken,name[1],address[1],cal[1]);
//        Myitem p3 = new Myitem(R.mipmap.salad,name[2],address[2],cal[2]);
//        Myitem p1 = new Myitem(R.mipmap.ic_launcher, name, address, cal);
//        Myitem p2 = new Myitem(R.mipmap.ic_launcher_round, "감자", "http://m.google.com", "3000");
//        Myitem p3 = new Myitem(R.mipmap.ic_launcher_round, "고구마", "http://m.daum.net", "333");

        link[1] = p1.getAddress();
//        link[2] = p2.getAddress();
//        link[3] = p3.getAddress();

        plist.add(p1);
//        plist.add(p2);
//        plist.add(p3);
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
        String q = "select* from member2 order by enddate";
        Cursor cursor = db.rawQuery(q,null);
        cursor.moveToNext();
        String memname = cursor.getString(0);
        db.close();
        return memname;
    }
    public void selectData(String q2){

        String q = "select * from foodrec3 where ingr = '"+q2+"' order by cal";
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
