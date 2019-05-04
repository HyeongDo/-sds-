package com.multi.student.threadproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskActivity extends AppCompatActivity {
    int mainvalue, threadvalue;
    TextView maintext, threadtext;
    int max = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maintext = (TextView)findViewById(R.id.maintext);
        threadtext = (TextView)findViewById(R.id.threadtext);

        MyasyncTask task = new MyasyncTask();
        task.execute("start");//작업 시작을 알리는 메소드
    }

    public void process(View v){
        mainvalue++;
        maintext.setText("Main Value:"+ mainvalue);
    }
    //AsyncTask: 객체안에 main thread, user thread가 해야할 메소드를 모두 가지고 있음
    class MyasyncTask extends AsyncTask<String, Integer, Integer>{



        //main thread가 수행하는 메소드 -> 1번으로 실행함
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //thread가 작업을 시작하기 전에 준비작업
        }

        //main thread가 수행하는 메소드
        @Override
        protected void onPostExecute(Integer integer) {//4->마무리작업없어도됨
            super.onPostExecute(integer);

        }

        //main thread가 수행하는 메소드
        @Override
        protected void onProgressUpdate(Integer... values) {//3
            super.onProgressUpdate(values);
            threadtext.setText("thread value:"+values[0]);
        }
        //user thread가 수행하는 메소드 -2
        @Override
        protected Integer doInBackground(String... strings) {//2
            while(threadvalue > max) {
                threadvalue++;
                publishProgress(threadvalue);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return 100;
        }
    }

}
