package com.multi.student.intentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Loginctivity extends AppCompatActivity {

    EditText userid,userpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginctivity);

        userid = (EditText)findViewById(R.id.userid);
        userpass = (EditText)findViewById(R.id.userpass);
    }

    //사용자가 입력한 id, pass 받아온 후에 intent에 담아
    //LoginCheckActivity로 보냄
    public void login(View v){
        String id = userid.getText().toString();
        String pass = userpass.getText().toString();

        userid.setText("");
        userpass.setText("");

        Intent i = new Intent(this,LoginCheckActivity.class);
        i.putExtra("userid",id);
        i.putExtra("userpass",pass);
        startActivityForResult(i,200);
    }
    //LoginCheckActivity 다녀온 후에 결과 처리
    // callback method : 사용자가 직접 호출 x. 특정 조건이 되면 자동 호출됨
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==200){
            if(resultCode==1){ //로그인 성공
                userid.setText("");
                userpass.setText("");
                Toast.makeText(this,"성공",Toast.LENGTH_SHORT).show();
            }else{ //로그인 실패
                Toast.makeText(this,"실패",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
