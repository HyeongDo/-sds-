package com.multi.student.threadproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity {
    int mainvalue, threadvalue;
    TextView maintext, threadtext;
    Myhandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maintext = (TextView)findViewById(R.id.maintext);
        threadtext = (TextView)findViewById(R.id.threadtext);

        handler = new Myhandler();

        //thread 생성 후 start
//        Tiger t = new Tiger();
//        t.setDaemon(true);//daemon thread로 지정. main이 끝나면 같이 종료
//        t.start();

        Lion l = new Lion();
        Thread t2 = new Thread(l);
        t2.setDaemon(true);
        t2.start();
    }

    public void process(View v){
        mainvalue++;
        maintext.setText("Main Value:"+ mainvalue);

    }

    class Tiger extends Thread{
        @Override
        public void run() {//thread가 해야 할 작업내용을 갖고 있는 메소드
            while(true){
            threadvalue++;
            handler.sendEmptyMessage(1);
            //main thread 만이 화면 터치 가능
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Lion implements Runnable{
        @Override
        public void run() {//thread가 해야 할 작업내용을 갖고 있는 메소드
            while(true){
                threadvalue++;

                //handler의 신호 보내기
                Message msg = new Message();
                handler.sendMessage(msg);

                //handler.sendEmptyMessage(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Myhandler extends Handler {
        //다른 thread로부터 Message가 도착하면 실행되는 메소드
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            threadtext.setText("Thread Value:"+threadvalue);
        }
    }
}
