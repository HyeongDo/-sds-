package com.multi.student.intentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BMIActivity extends AppCompatActivity {

    EditText height,weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        height = (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);

    }

    public void send(View v){
        //화면에 입력한 값 알아오기
        //인텐트에 담아 BMICheckActivity로 보내기
        String h = height.getText().toString();
        //int ih = Integer.parseInt(h);
        double ih = Double.parseDouble(h);
        String w = weight.getText().toString();
        double iw = Double.parseDouble(w);
       // int iw = Integer.parseInt(w);

        Intent i = new Intent(this,BMICheckActivity.class);
        i.putExtra("height",ih);
        i.putExtra("weight",iw);
        startActivity(i);
    }
}
