package com.multi.student.recommend;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class CDialog extends Dialog {
    private TextView mTitleView;
    private EditText mContentView, susu,cal,count,material,name_m;
    private Button mLeftButton;
    private Button mRightButton;
    private String mTitle;
    private String mContent;
    EditText date;
    DatePickerDialog datePickerDialog;
    Context context;
    static String newdate,newcount;
    SQLiteDatabase db;



    private View.OnClickListener mLeftClickListener;
    private View.OnClickListener mRightClickListener;

    @Override
    public void dismiss() {
        super.dismiss();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);


        date = (EditText) findViewById(R.id.date);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(year + "/"
                                        + (monthOfYear + 1) + "/" + dayOfMonth);
                                newdate=date.getText().toString();
                                Toast.makeText(context, date.getText().toString(), Toast.LENGTH_SHORT).show();
                                newcount =susu.getText().toString();
                            }
                        }, mYear, mMonth, mDay);


                datePickerDialog.show();



            }
        });


        //다이얼로그 외부 화면 흐리게 하기
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);



        mTitleView = (TextView) findViewById(R.id.material);
        mLeftButton = (Button) findViewById(R.id.apply);
        mRightButton = (Button) findViewById(R.id.cancel);
        susu = (EditText)findViewById(R.id.susu);
        date = (EditText)findViewById(R.id.date);
        susu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                susu.setText(null);
            }
        });

        //클릭 이벤트 셋팅
        if (mLeftClickListener != null && mRightClickListener != null){
            mLeftButton.setOnClickListener(mLeftClickListener);
            mRightButton.setOnClickListener(mRightClickListener);
        } else if (mLeftClickListener != null
                && mRightClickListener == null) {
            mLeftButton.setOnClickListener(mLeftClickListener);
        } else {

        }





    }


    public CDialog(Context context, String title,
                   View.OnClickListener leftListener,
                   View.OnClickListener rightListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mTitle = title;
        this.context = context;
        this.mLeftClickListener = leftListener;
        this.mRightClickListener = rightListener;
    }

//    public void insertdata(View view){
//        susu = (EditText)findViewById(R.id.susu);
//        date = (EditText)findViewById(R.id.date);
//        Intent i = new Intent(getContext(),Main2Activity.class);
//        getContext().startActivity(i);
//
//        cal.setText(date.getText().toString());
//        count.setText(susu.getText().toString());
//        newdate=date.getText().toString();
//        newcount=susu.getText().toString();
//        String q = ("update member2 set count ='"+newcount+"', enddate='"+newdate+"'");
//        db.execSQL(q);
//        db.close();
//
//
//    }
//    public void backdata(View view){
//        CDialog.this.dismiss();
//        Intent i = new Intent(context, AddMainActivity.class);
//        context.startActivity(i);
//        ((Activity)context).finish();
//
//    }


//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()){
//
//            case R.id.apply:
//                newdate=date.getText().toString();
//                newcount=susu.getText().toString();
//
//
//                Intent i = new Intent(getContext(),Main2Activity.class);
//                getContext().startActivity(i);
//                String q = ("update member2 set count ='"+newcount+"', enddate='"+newdate+"'");
//                db.execSQL(q);
//                db.close();
//
//            case R.id.cancel:
//
//                CDialog.this.dismiss();
//                Intent back = new Intent(context, AddMainActivity.class);
//                context.startActivity(back);
//                ((Activity)context).finish();
//
//        }
//
//    }
}
