package com.multi.student.threadproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class ClockAcyncActivity extends AppCompatActivity {
    TextView maintext, threadtext;
    TextView clocktext;

    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clocktext = (TextView)findViewById(R.id.threadtext);

        ClockAsync async = new ClockAsync();
        async.execute();

    }
    public void process(View v){

    }
    class ClockAsync extends AsyncTask<String,String,String>{
        @Override
        protected void onProgressUpdate(String... values) {//main thread
            super.onProgressUpdate(values);
            clocktext.setText("time:"+values[0]);
        }

        @Override
        protected String doInBackground(String... voids) {//user thread

            while(flag) {

                try {
                    Date d = new Date();
                    publishProgress(d.toString());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

}
