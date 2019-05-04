package com.multi.student.recommend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;


public class FirstActivity extends AppCompatActivity {
//    ImageButton func1,rec1;
    ImageView func,rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
//        func1 = (ImageButton)findViewById(R.id.func1);
//        rec1 = (ImageButton)findViewById(R.id.rec1);
        func = (ImageView)findViewById(R.id.func);
        rec = (ImageView)findViewById(R.id.rec);
        func.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });
        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }


//    public void process(View v) {
//        int id = v.getId();
//        if(id == R.id.func){
//            Intent i = new Intent(this,MainActivity.class);
//            startActivity(i);
//        }else{
//            Intent i = new Intent(this,MainActivity.class);
//           startActivity(i);
//        }
//    }
}
