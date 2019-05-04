package com.multi.student.intentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_check);

        //Loginctivity에서 보내온 intent 안의 값 꺼내서 비교
        //resultCode를 다르게 저장
        //돌아가기
        Intent i = getIntent();
        String id = i.getStringExtra("userid");
        String pass = i.getStringExtra("userpass");
        String id2 = "tommy";
        String pass2 = "1234";
        if(id.equals(id2)&&pass.equals(pass2)){
            setResult(1);
        }else{
            setResult(2);
        }
        finish();

    }
}
