package com.multi.student.intentproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //event처리 메소드. v:사건이 발생한 대상
    // 화면을 만들 수 있는 전체구성요소 -> View , component, widget 같은 이야기
    public void sub(View v){
        //Activity간의 전환을 위해 사용되는 시스템 메세지, 신호
        Intent i = new Intent(this,SubActivity.class);
        startActivity(i);
    }

    public void data(View v){
        //DataActivity로 넘어감
        Intent i = new Intent(this,DataActivity.class);
        i.putExtra("code","droid");//key, value
        i.putExtra("count",999);
        startActivityForResult(i,100);
    }

    //결과처리 메소드


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){//DataActivity에서 돌아옴
           if(resultCode==1){//정상종료
              String result= data.getStringExtra("result");
               Toast.makeText(this,result,Toast.LENGTH_SHORT).show();


           }else{//비정상

           }
        }else{

        }
    }

    //암시적 인텐트
    public void process(View v){
        int id = v.getId();
        if(id == R.id.call){
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("tel:010-3456-8907"));
            startActivity(i);
        }else{
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://m.naver.com"));
            startActivity(i);
        }
    }

}
