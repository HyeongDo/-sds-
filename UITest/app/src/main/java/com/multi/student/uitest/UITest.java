package com.multi.student.uitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class UITest extends AppCompatActivity /*implements View.OnClickListener*/{
    private TextView tv;
    private EditText et;

  /*두번째
    private class Myclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String s = et.getText().toString();
            tv.setText(s);
            et.setText("");

        }
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uitest);


        tv = findViewById(R.id.first_tv);
        et = findViewById(R.id.first_edit);
        Button b = findViewById(R.id.first_button);

        //3번째 이벤트 처리방식
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s = et.getText().toString();
                tv.setText(s);
                et.setText("");
            }
        });

        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    if(keyCode == KeyEvent.KEYCODE_ENTER){
                        Toast.makeText(UITest.this,et.getText(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
                return false;
            }
        });

        findViewById(R.id.linear).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Toast t = Toast.makeText(UITest.this,"x : "+event.getX()+", y : "+event.getY(),Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.LEFT|Gravity.TOP,(int)event.getX(),(int)event.getY());
                        t.show();
                        event.getX();
                        event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }

                return false;
            }
        });



    }
    //4번째 이벤트 처리 방식 추천하지는 않음
    /*public void go(View v){

    }*/

/*첫번째
    @Override
    public void onClick(View v) {
    String s = et.getText().toString();
    tv.setText(s);
    et.setText("");
    }
*/
    @Override
    protected void onRestart() {
        super.onRestart();
        String s = et.getText().toString();
        tv.setText(s);
    }

}
