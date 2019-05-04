package com.multi.student.preferencesproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);

    }

    public void process(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.put:
                SharedPreferences pref = getSharedPreferences("preftest", 0);//name file명
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("num", "111");
                editor.putString("name", "bill kollins");
                editor.putString("address", "seattle");
                editor.apply();
                break;
            case R.id.get:
                SharedPreferences pref2 = getSharedPreferences("preftest", MODE_PRIVATE);
//                String num = pref2.getString("num", "");
//                String name = pref2.getString("name", "");
//                String address = pref2.getString("address", "");


                String val = "";
                //getAll() : pref2안의 모든 데이터를 Map구조로 리턴해 줌
                Map<String,?> map = pref2.getAll();
                Set<String> keys = map.keySet();
                for(String key: keys){
                    val += key + ":" + map.get(key)+"\n";
                }

                result.setText(val);
                break;
        }
    }
}
