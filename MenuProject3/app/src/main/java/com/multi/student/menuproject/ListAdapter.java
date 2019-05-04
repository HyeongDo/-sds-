package com.multi.student.menuproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListAdapter extends BaseAdapter {
    public static boolean checkit ,checklike;
    Context context;
    int itemlayout;
    ArrayList<Product> data;
    LayoutInflater inflater;//xml문서의 내용을 자바객체로 만들어 주는 class
    Boolean checked=false;
    CheckBox checkitem;
    static String []checklist = new String[10];
    static int inte=0;




    public ListAdapter(Context context, int itemlayout, ArrayList<Product> data) {
        this.context= context;
        this.data=data;
        this.itemlayout=itemlayout;
//        inflater =
//                (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


    }
    //public int getPosition(){
     //   return data.
   // }

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

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listitem, parent,false);


        }

        CheckBox checkitem=(CheckBox)convertView.findViewById(R.id.checkItem);
        ImageView image = (ImageView)convertView.findViewById(R.id.imageView);
        TextView name = (TextView)convertView.findViewById(R.id.name);
        TextView end = (TextView)convertView.findViewById(R.id.end);
        TextView count= (TextView)convertView.findViewById(R.id.count);
        TextView cal= (TextView)convertView.findViewById(R.id.cal);


        end.setVisibility(View.VISIBLE);
        count.setVisibility(View.VISIBLE);

        Product p = data.get(position);
        checkitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checklist[inte]=data.get(position).getName();
                Toast.makeText(context, checklist[inte], Toast.LENGTH_SHORT).show();
                inte++;
            }
        });




        image.setImageResource(p.getImageId());
        name.setText(p.getName());
        count.setText(p.getCount());
        end.setText(p.getEnd());
        cal.setText(p.getCal());



        return convertView;
    }

}

