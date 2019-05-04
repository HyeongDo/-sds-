package com.multi.student.threadproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ANRActivity extends AppCompatActivity {
    TextView value;
    Button increase,upload;
    int count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anr);

        value = (TextView) findViewById(R.id.value);



    }

    public void process(View v) {
        if (v.getId() == R.id.increase) {//increase
            count++;
            value.setText("value:"+count);
        } else {//upload
            upload();
            Toast.makeText(this, "업로드를 완료했습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    class UploadAsync extends AsyncTask<Object,Object,Object>{
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            Toast.makeText(ANRActivity.this, "업로드를 완료했습니다.", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
                Toast.makeText(ANRActivity.this, "업로드를 시작합니다.", Toast.LENGTH_SHORT).show();


        }


    }
    public void upload(){
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
