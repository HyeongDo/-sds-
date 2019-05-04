package com.multi.student.listviewproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//event 처리를 하기 위해서
// 1. Listener(interface) 선언 (감시자 이름 이야기 해줘야 한다.)
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<String> cities;
    ArrayAdapter<String> adapter;
    EditText newcity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //화면
        listView = (ListView)findViewById(R.id.listview);
        newcity = (EditText)findViewById(R.id.newcity);

        //data 준비
        cities = new ArrayList<>();
        cities.add("seoul");
        cities.add("busan");
        cities.add("gwangmyeong");
        cities.add("jeju");
        cities.add("paju");
        cities.add("ulsan");
        cities.add("pyeongyang");
        cities.add("yangyang");
        cities.add("incheon");
        cities.add("anyang");
        cities.add("buchoen");
        cities.add("siheung");
        cities.add("jeonju");

        //adapter 준비(화면+data)
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,//listview의 item에 사용할 Layout xmL
                android.R.id.text1,
                        cities
                        );

        listView.setAdapter(adapter); //어댑터지정필수
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);//라디오버튼
        //2. 사건이 발생하는 대상에게 리스너 등록
        listView.setOnItemClickListener(this);
        }
        //3. 사건이 발생했을 때 리스너가 실행하는 사건 처리 메소드. callback method
    @Override
    public void onItemClick(AdapterView<?> listview, View view, int position, long id) {
        //String city = cities.get(position);
        String city = listview.getItemAtPosition(position).toString();
        Toast.makeText(this,"city:"+city,Toast.LENGTH_SHORT).show();

        //Intent 생성한 후, intent에 city 저장
        //setResult(1,i);
        //finish()
        Intent i = new Intent();
        i.putExtra("city",city);
        setResult(1,i);
        finish();

    }
    public void process(View v){
        int id = v.getId();
        switch (id){
            case R.id.add:
                String value = newcity.getText().toString();
                cities.add(0, value);//arrayList 접근
                adapter.notifyDataSetChanged();//중간관리자에게 요청
                newcity.setText("");
                break;
            case R.id.del:
                int index = listView.getCheckedItemPosition();
                cities.remove(index);
                adapter.notifyDataSetChanged();
                listView.clearChoices();
                break;
        }
    }
}
