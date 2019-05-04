package com.multi.student.preferencesproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {
    CheckBox save;
    EditText userid,userpass;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        save = (CheckBox)findViewById(R.id.save);
        userid = (EditText)findViewById(R.id.userid);
        userpass = (EditText)findViewById(R.id.userpass);
        //전에 저장되었던 id, pass 값 읽어와서 화면에 출력하기
        pref = getSharedPreferences("Login",0);
         String id = pref.getString("id", "");
         String pass = pref.getString("pass", "");
        userid.setText(id);
        userpass.setText(pass);
    }

    public void login(View v){
        //체크박스 상태 알아내서 preferences에 저장 여부 결정
        boolean flag = save.isChecked();
        if(flag){//체크 된 상태
            //id, pass 입력값 알아오기
            //SharedPreferences에 저장
            //Toast 띄우기(저장되었습니다.)
            String id = userid.getText().toString();
            String pass = userpass.getText().toString();
            pref = getSharedPreferences("Login",0);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("id",id);
            editor.putString("pass",pass);

            editor.apply();
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();


        }else{
            //전에 저장되었던 값이 있다면 삭제
            //Toast 띄우기(로그인되었습니다.)
            //id, pass값 지우기
            String id ="";
            String pass = "";
            pref = getSharedPreferences("Login",0);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("id",id);
            editor.putString("pass",pass);
            editor.apply();
            Toast.makeText(this, "로그인되었습니다.", Toast.LENGTH_SHORT).show();


        }


    }
}
