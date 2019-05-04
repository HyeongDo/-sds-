package com.multi.student.serviceproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void process(View v){
        if(v.getId() == R.id.start){
            Intent i = new Intent(this,MyService.class);
            startService(i);
        }else{
            Intent i = new Intent(this,MyService.class);
            startService(i);
        }
    }
}
