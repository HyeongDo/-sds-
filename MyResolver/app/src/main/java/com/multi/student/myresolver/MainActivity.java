package com.multi.student.myresolver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final String authority = "com.edu.multi";
    Uri myUri = Uri.parse("content://"+authority);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert(View v){
        ContentResolver r = getContentResolver();
        r.insert(myUri,new ContentValues());
    }
    public void update(View v){
        ContentResolver r= getContentResolver();
        r.update(myUri,new ContentValues(),null,null);
    }
    public void delete(View v){
        ContentResolver r= getContentResolver();
        r.delete(myUri,null,null);
    }
    public void query(View v){
        ContentResolver r = getContentResolver();
        r.query(myUri,null,null,null,null);
    }
}
