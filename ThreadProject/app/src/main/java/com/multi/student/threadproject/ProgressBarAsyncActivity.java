package com.multi.student.threadproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarAsyncActivity extends AppCompatActivity {
    TextView tv;
    ProgressBar bar;
    ProgressAcync acync;
    int value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_async);

        tv = (TextView)findViewById(R.id.textView);
        bar = (ProgressBar)findViewById(R.id.progressBar);


    }

    class ProgressAcync extends AsyncTask<Integer,Integer,Integer>{



        @Override
        protected void onPreExecute() {//main에 의해
            super.onPreExecute();
            bar.setProgress(value);//progressbar에 값 setting
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            bar.setProgress(0);
            tv.setText("finished...");
            value = 0;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            bar.setProgress(values[0]);
            tv.setText("Current value:"+values[0]);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            bar.setProgress(0);
            tv.setText("canceled...");
            value= 0;
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            while(isCancelled() == false){//취소 안 됐으면
                value++;
                if(value>100){
                    break;
                }else{
                    publishProgress(value);//화면 update
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public void process(View v){
        if(v.getId()==R.id.run){
            acync = new ProgressAcync();
            acync.execute(100);
        }else{//취소
            acync.cancel(true);
        }
    }
}
