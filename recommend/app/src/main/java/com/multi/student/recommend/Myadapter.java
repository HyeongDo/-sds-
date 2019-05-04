package com.multi.student.recommend;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class Myadapter extends BaseAdapter{
    Context context;
    int itemlayout;
    ArrayList<Myitem> item;
    LayoutInflater inflater;

    public Myadapter(Context context,int itemlayout, ArrayList<Myitem> item ){
        this.context = context;
        this.itemlayout=itemlayout;
        this.item = item;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return item.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(itemlayout,parent,false);
        }

        Myitem m = item.get(position);

        ImageView img = (ImageView)convertView.findViewById(R.id.recImg);
        TextView name = (TextView)convertView.findViewById(R.id.recName);
        TextView address = (TextView)convertView.findViewById(R.id.recAddress);
        TextView cal = (TextView)convertView.findViewById(R.id.recCal);


        img.setImageResource(m.getImg());
        name.setText(m.getName());
        address.setText(m.getAddress());
        cal.setText(m.getCal());


        return convertView;
    }
}
