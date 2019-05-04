package com.multi.student.listviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    ArrayList<Product> plist; //data
    Myadapter adapter;//adapter 관리자
    ListView clist;//화면


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        clist = (ListView)findViewById(R.id.clist);

        plist = new ArrayList<>();
        //1.data 준비
        Product p1 = new Product(R.mipmap.gals,"갤럭시 9",28);
        Product p2 = new Product(R.mipmap.ipad,"i-pad",30);
        Product p3 = new Product(R.mipmap.trom,"LG Trom",12);

        plist.add(p1);
        plist.add(p2);
        plist.add(p3);

        //2.adapter
        adapter = new Myadapter(
                this, //Activity
                R.layout.listitem, //ListView 안에 들어가는 item을 위한 xml
                plist //data가 들어 있는 ArrayList
        );

        //3.Listview에 adapter 지정
        clist.setAdapter(adapter);

    }
}
