package com.multi.student.recommend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;

public class CheckableLayout extends LinearLayout implements Checkable{
    public CheckableLayout(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    public void setChecked(boolean checked) {
        CheckBox checkItem = (CheckBox)findViewById(R.id.checkItem);
        if(checkItem.isChecked() !=checked){
            checkItem.setChecked(checked);
        }


    }

    @Override
    public boolean isChecked() {
        CheckBox checkItem = (CheckBox)findViewById(R.id.checkItem);
        return checkItem.isChecked();
    }

    @Override
    public void toggle() {
        CheckBox checkItem = (CheckBox)findViewById(R.id.checkItem);
        setChecked(checkItem.isChecked()?false:true);
    }
}
