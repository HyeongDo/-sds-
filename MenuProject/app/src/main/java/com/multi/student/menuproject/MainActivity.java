package com.multi.student.menuproject;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.b);
        layout = (ConstraintLayout)findViewById(R.id.layout);
        registerForContextMenu(b);
    }

    //options menu 생성 : title bar 옆에 붙는 메뉴


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.myoptions,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int mid = item.getItemId();
        switch(mid){
            case R.id.refresh:
                Toast.makeText(this,"새로고침",Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this,"검색",Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this,"설정화면",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override//context menu 내용 만드는 메소드
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==b) {
            menu.setHeaderTitle("Context Menu Title");
            menu.add(0, 1, 0, "Red");
            menu.add(0, 2, 0, "Blue");
            menu.add(0, 3, 0, "Green");
        }
    }
    //context menu 선택시 실행될 이벤트 처리 메소드
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int code = item.getItemId();
        switch (code){
            case 1:
                b.setTextColor(Color.RED);
                layout.setBackgroundColor(Color.CYAN);
                break;
            case 2:
                b.setTextColor(Color.BLUE);
                layout.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                b.setTextColor(Color.GRAY);
                layout.setBackgroundColor(Color.BLACK);
                break;
        }
        return super.onContextItemSelected(item);

    }
}
