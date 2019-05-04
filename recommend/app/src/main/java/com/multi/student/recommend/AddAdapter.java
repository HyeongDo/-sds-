package com.multi.student.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddAdapter extends BaseAdapter {
    Context context;
    int itemlayout;
    ArrayList<Productadd> data;
    static String newname;
    static String newcal;
    LayoutInflater inflater;

    public AddAdapter(Context context, int itemlayout, ArrayList<Productadd> data){
        this.context = context;
        this.itemlayout= itemlayout;
        this.data = data;
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

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

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(itemlayout, parent, false);

        }
        ImageView img = (ImageView)convertView.findViewById(R.id.img_m);
        TextView txt = (TextView)convertView.findViewById(R.id.name_m);
        Button info = (Button)convertView.findViewById(R.id.register);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newname=data.get(position).getName();
                newcal=data.get(position).getCal();
                }
        });

        Productadd p = data.get(position);
        img.setImageResource(p.getImgID());
        txt.setText(p.getName());
        return convertView;
    }
}
