package com.multi.student.intentproject;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BMICheckActivity extends AppCompatActivity {
    ImageView resultimage;
    TextView resultmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicheck);

        Intent i = getIntent();
        double height = i.getIntExtra("height",0);
        double weight = i.getIntExtra("weight",0);
        resultimage = (ImageView) findViewById(R.id.resultimage);
        resultmessage = (TextView) findViewById(R.id.resulmessage);

        double bmi = (weight/((height*0.01)*(height*0.01)));

        if(bmi>=30){
            resultimage.setImageResource(R.mipmap.fatfat);
            resultmessage.setText("팻팻입니다.");
        }else if(bmi>=23){
            resultimage.setImageResource(R.mipmap.fat);
            resultmessage.setText("팻입니다.");
        }else if(bmi>=18.5){
            resultimage.setImageResource(R.mipmap.good);
            resultmessage.setText("굿입니다.");
        }else{
            resultimage.setImageResource(R.mipmap.thin);
            resultmessage.setText("띤입니다.");
        }



    }

    public void back(View v){
        finish();
    }
}
