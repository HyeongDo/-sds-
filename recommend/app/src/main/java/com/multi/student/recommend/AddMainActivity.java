package com.multi.student.recommend;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.multi.student.recommend.AddAdapter.newcal;
import static com.multi.student.recommend.AddAdapter.newname;
import static com.multi.student.recommend.CDialog.newcount;
import static com.multi.student.recommend.CDialog.newdate;


public class AddMainActivity extends AppCompatActivity {
    ListView clist;
    ArrayList<Productadd> plist;
    AddAdapter adapter;
    SQLiteDatabase db;
    Button store;
    private CDialog mDialog;
    String name;
    String cal;
    int draw;



//    @Override
//    protected void onStart() {
//
////        draw=R.mipmap.dish;
////        if(name.equals("김치")){
////            draw = R.mipmap.kim;
////        }else if(name.equals("된장")){
////            draw = R.mipmap.jang;
////        }else if(name.equals("돼지고기")){
////            draw = R.mipmap.pork;
////        }else if(name.equals("두부")){
////            draw = R.mipmap.dubu;
////        }else if(name.equals("생선")){
////            draw = R.mipmap.fish;
////        }else if(name.equals("햄")){
////            draw = R.mipmap.ham;
////        }else if(name.equals("계란")){
////            draw = R.mipmap.egg;
////        }else if(name.equals("소고기")){
////            draw = R.mipmap.so;
////        }else if(name.equals("토마토")){
////            draw = R.mipmap.tomato;
////        }else if(name.equals("야채")){
////            draw = R.mipmap.vveg;
////        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmain);
        clist = (ListView) findViewById(R.id.clist);
        store = (Button) findViewById(R.id.store);
        plist = new ArrayList<>();
        adapter = new AddAdapter(
                this,
                R.layout.additemlist,
                plist
        );
        clist.setAdapter(adapter);
        // 재료들 data
        adapter = new AddAdapter(this, R.layout.additemlist, plist);
        clist.setAdapter(adapter);
        createDB();
        createTable();
        createMainTable();
//        insertData();
        selectData();
    }

    public void createDB() {
        db = openOrCreateDatabase
                ("member.db", Context.MODE_PRIVATE, null);
    }

    public void createTable() {
        String q = "create table if not exists material(_name primary key,cal)";

//        q="drop table material";

        db.execSQL(q);
        Log.i("sqlite::::::::", "table creation success" +
                "");
    }

    public void createMainTable() {
        String q = "create table if not exists member" +
                "2(_name primary key, count  ,enddate,cal)";

        db.execSQL(q);
        Log.i("sqlite::::::::", "table creation success" +
                "");
    }

    public void insertData() {

        String q = "insert into material values('김치','11')";
        db.execSQL(q);
        q = "insert into material values('된장','128')";
        db.execSQL(q);
        q = "insert into material values('돼지고기','125')";
        db.execSQL(q);
        q = "insert into material values('두부','97')";
        db.execSQL(q);
        q = "insert into material values('생선','100')";
        db.execSQL(q);
        q = "insert into material values('햄','204')";
        db.execSQL(q);
        q = "insert into material values('계란','158')";
        db.execSQL(q);
        q = "insert into material values('소고기','88')";
        db.execSQL(q);
        q = "insert into material values('토마토','22')";
        db.execSQL(q);
        q = "insert into material values('야채','200')";
        db.execSQL(q);
    }

    public void selectData() {
        String q = "select *from material";
        plist.clear();
//        cursor select 해온 data집합
        Cursor cursor = db.rawQuery(q, null);

//        첫번째 cursor는 제목 줄
        if (cursor != null) {
//            실제데이터를 가르킴
            while (cursor.moveToNext()/*다음 투플로 넘어감*/) {
//                table에서 각 어트리뷰트에 넣음


                name = cursor.getString(0);
                cal = cursor.getString(1);
                draw=R.mipmap.dish;
                if(name.equals("김치")){
                    draw = R.mipmap.kim;
                }else if(name.equals("된장")){
                    draw = R.mipmap.jang;
                }else if(name.equals("돼지고기")){
                    draw = R.mipmap.pork;
                }else if(name.equals("두부")){
                    draw = R.mipmap.dubu;
                }else if(name.equals("생선")){
                    draw = R.mipmap.fish;
                }else if(name.equals("햄")){
                    draw = R.mipmap.ham;
                }else if(name.equals("계란")){
                    draw = R.mipmap.egg;
                }else if(name.equals("소고기")){
                    draw = R.mipmap.so;
                }else if(name.equals("토마토")){
                    draw = R.mipmap.tomato;
                }else if(name.equals("야채")){
                    draw = R.mipmap.vveg;
                }

                Productadd p1 = new Productadd(draw,name,cal);
                plist.add(p1);
            }
            adapter.notifyDataSetChanged();


        }
    }

    public void store(View view) {
        String q = ("insert into member2 values('" + newname + "','','','" + newcal + "'" +
                ")");
        db.execSQL(q);
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        mDialog = new CDialog(this, "재료",
                leftListener, rightListener);
        mDialog.show();

    }
    private View.OnClickListener leftListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "적용", Toast.LENGTH_SHORT).show();
            String q = ("update member2 set count ='"+newcount+"', enddate='"+newdate+"' where _name ='"+newname+"'" );
            db.execSQL(q);
            mDialog.dismiss();
            finish();

        }


    };
    private View.OnClickListener rightListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "취소",
                    Toast.LENGTH_SHORT).show();
            String q = ("delete from member2 where _name='"+newname+"'");
            db.execSQL(q);
            mDialog.dismiss();
            finish();
        }
    };
}




