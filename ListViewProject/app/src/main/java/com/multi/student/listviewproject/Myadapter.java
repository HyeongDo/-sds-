package com.multi.student.listviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Myadapter extends BaseAdapter  {
    Context context;
    int itemlayout;
    ArrayList<Product> data;
    LayoutInflater inflater;//xmL문서의 내용을 자바 객체로 만들어 주는 클래스

    public Myadapter(Context context,int itemlayout,ArrayList<Product> data){
        this.context= context;
        this.itemlayout=itemlayout;
        this.data=data;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //adapter가 ArrayList데이터를 꺼내서 한 개의 아이템(한 행)을 만들어 주는 메소드.
    //자동으로 반복실행 (행이 세 번이면 세 번 시행, 데이터 갯수만큼
    //callback 메소드
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(itemlayout,parent,false);
        }
        Product p = data.get(position);

        ImageView img = (ImageView)convertView.findViewById(R.id.iv);
        TextView txt = (TextView)convertView.findViewById(R.id.tv);
        TextView cnt = (TextView)convertView.findViewById(R.id.count);
        Button info = (Button)convertView.findViewById(R.id.info);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,data.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });



        img.setImageResource(p.getImgId());
        txt.setText(p.getName());
        cnt.setText(p.getCount()+"");

        return convertView;
    }


}
