package com.multi.student.recommend;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

import static com.multi.student.recommend.AddAdapter.newname;
import static com.multi.student.recommend.CDialog.newcount;
import static com.multi.student.recommend.CDialog.newdate;
import static com.multi.student.recommend.ListAdapter.checkit;
import static com.multi.student.recommend.ListAdapter.checklike;
import static com.multi.student.recommend.ListAdapter.checklist;
import static com.multi.student.recommend.ListAdapter.inte;

public class Main2Activity extends AppCompatActivity {
    ArrayList<Product> plist;//data
    ListAdapter adapter;//adapter
    ListView clist;//화면
    LinearLayout layout;
    SQLiteDatabase db;
    Button store;
    Button back;
    Button add;
    Button revise;
    Button delete;
    public static int fla;
    private CDialog mDialog;
    String name;
    int draw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        clist = (ListView)findViewById(R.id.clist);
       store = (Button)findViewById(R.id.store);
        back = (Button)findViewById(R.id.back);
        add = (Button)findViewById(R.id.add);
        revise = (Button)findViewById(R.id.revise);
        delete= (Button)findViewById(R.id.delete);
        plist = new ArrayList<>();
//        Product p1 = new Product(R.mipmap.menu_refresh,"감자","1","2018.12.10","500");
//        Product p2 = new Product(R.mipmap.menu_refresh,"고구마","1","2018.12.10","500");
//        Product p3 = new Product(R.mipmap.menu_refresh,"양파","1","2018.12.10","500");
//
//        plist.add(p1);
//        plist.add(p2);
//        plist.add(p3);
        adapter = new ListAdapter(
                this,
                R.layout.listitem,
                plist
        );
        clist.setAdapter(adapter);




    }

    @Override
    protected void onStart() {
        super.onStart();
        createDB();
        createTable();
//      insertData();
        selectData();
//        String q = "DELETE FROM member2 ";
//        db.execSQL(q);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        createDB();
        createTable();
        selectData();
    }

    //    options menu 생성: Title bar 옆에 붙는 메뉴


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.myoptions,menu);
        return super.onCreateOptionsMenu(menu);


    }

    public void add(View v){
        Intent i = new Intent(this, AddMainActivity.class);
        startActivity(i);
        Toast.makeText(this, "추가", Toast.LENGTH_SHORT).show();

    }

    public void revise(View v){
        mDialog = new CDialog(this, "재료",
                leftListener, rightListener);
        mDialog.show();



    }

    public void delete(View v){
        int check;
        for(check=0; check<inte; check++)
        {String q = "DELETE FROM member2 where " +
                "_name=" +
                "'"+checklist[check]+"'";
            db.execSQL(q);

            Toast.makeText(this, "삭제완료", Toast.LENGTH_SHORT).show();
        }

        selectData();
        adapter.notifyDataSetChanged();

    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//
//        int mid= item.getItemId();
//        fla=mid;
//        switch (mid){
//            case R.id.add:
//                Intent i = new Intent(this, AddMainActivity.class);
//                startActivity(i);
//                Toast.makeText(this, "추가", Toast.LENGTH_SHORT).show();
//                break;
//            case  R.id.revise:
//                mDialog = new CDialog(this, "재료",
//                        leftListener, rightListener);
//                mDialog.show();
//
//                break;
//
//            case R.id.delete: ;
//
////                Toast.makeText(this, "삭제", Toast.LENGTH_SHORT).show();
//                int check;
//                for(check=0; check<inte; check++)
//                {String q = "DELETE FROM member2 where " +
//                        "_name=" +
//                        "'"+checklist[check]+"'";
//                db.execSQL(q);
//                    Toast.makeText(this, newname+"삭제완료", Toast.LENGTH_SHORT).show();
//                }
//
//                selectData();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//
//    }

    public void createDB() {
        db = openOrCreateDatabase
                ("member.db", Context.MODE_PRIVATE, null);
    }

    public void createTable() {
        String q = "create table if not exists member2(_name primary key, count ,enddate,cal)";
//        q="drop table member2";

        db.execSQL(q);
        Log.i("sqlite::::::::", "table creation success" +
                "");
    }

    public void insertData() {
        String q = "insert into member2 values('김치','3','2018.10.12','11')";
        db.execSQL(q);
    }

    public void selectData() {
        String q = "select *from member2";
        plist.clear();
//        cursor select 해온 data집합
        Cursor cursor = db.rawQuery(q, null);

//        첫번째 cursor는 제목 줄
        if (cursor != null) {
//            실제데이터를 가르킴
            while (cursor.moveToNext()/*다음 투플로 넘어감*/) {
//                table에서 각 어트리뷰트에 넣음

                name = cursor.getString(0);
                String count = cursor.getString(1);
                String enddate = cursor.getString(2);
                String cal = cursor.getString(3);

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
                Product p1 = new Product(checkit,checklike,draw,name,count,enddate,cal);
                plist.add(p1);
            }
            adapter.notifyDataSetChanged();

        }
//        db.close();

    }

    public void back(View v){
        store.setVisibility(View.GONE);
        back.setVisibility(View.GONE);

    }
    private View.OnClickListener leftListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "적용", Toast.LENGTH_SHORT).show();
            String q = ("update member2 set count ='"+newcount+"', enddate='"+newdate+"'where _name ='"+checklist[inte-1]+"'");
            db.execSQL(q);
            mDialog.dismiss();
            selectData();
//            finish();

        }


    };
    private View.OnClickListener rightListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "취소",
                    Toast.LENGTH_SHORT).show();
            String q = ("delete from member2 where _name='"+newname+"'");
            db.execSQL(q);
            mDialog.dismiss();
//            finish();
        }
    };

}

