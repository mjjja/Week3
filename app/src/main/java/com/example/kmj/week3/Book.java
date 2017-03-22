package com.example.kmj.week3;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.concurrent.atomic.AtomicInteger;

public class Book extends AppCompatActivity {
    EditText et1,et2,et3;
    Chronometer cm;
    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    Switch sw;
    DatePicker dp;
    TimePicker tp;
    Button bt1,bt2;
    LinearLayout ll1,ll3;
    GridLayout ll2;
    int num=0;
    boolean swChecked=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        setTitle("레스토랑 예약시스템");
        init();
    }

    void init(){
        et1=(EditText)findViewById(R.id.AdultCount);
        et2=(EditText)findViewById(R.id.YouthCount);
        et3=(EditText)findViewById(R.id.KidCount);
        cm=(Chronometer)findViewById(R.id.CM);
        tv1=(TextView)findViewById(R.id.BookTime);
        tv2=(TextView)findViewById(R.id.textView14);
        tv3=(TextView)findViewById(R.id.textView16);
        tv4=(TextView)findViewById(R.id.textView18);
        tv5=(TextView)findViewById(R.id.textView20);
        tv6=(TextView)findViewById(R.id.textView22);
        sw=(Switch)findViewById(R.id.switch1);
        dp=(DatePicker)findViewById(R.id.datePicker);
        tp=(TimePicker)findViewById(R.id.timePicker);
        bt1=(Button)findViewById(R.id.Prev);
        bt2=(Button)findViewById(R.id.Next);
        ll1=(LinearLayout)findViewById(R.id.count);
        ll2=(GridLayout)findViewById(R.id.result);
        ll3=(LinearLayout)findViewById(R.id.Buttons);
        int year,month,day;

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num--;
                if (num == 0 && swChecked) {
                    dp.setVisibility(View.VISIBLE);
                    tp.setVisibility(View.GONE);
                    ll1.setVisibility(View.GONE);
                    ll2.setVisibility(View.GONE);
                    ll3.setVisibility(View.VISIBLE);
                    bt1.setEnabled(false);
                } else if (num == 1 && swChecked) {
                    dp.setVisibility(View.GONE);
                    tp.setVisibility(View.VISIBLE);
                    ll1.setVisibility(View.GONE);
                    ll2.setVisibility(View.GONE);
                    bt1.setEnabled(true);
                } else if (num == 2 && swChecked) {
                    dp.setVisibility(View.GONE);
                    tp.setVisibility(View.GONE);
                    ll1.setVisibility(View.VISIBLE);
                    ll2.setVisibility(View.GONE);
                    bt2.setEnabled(true);
                } else if (num == 3 && swChecked) {
                    dp.setVisibility(View.GONE);
                    tp.setVisibility(View.GONE);
                    ll1.setVisibility(View.GONE);
                    ll2.setVisibility(View.VISIBLE);
                    bt2.setEnabled(false);
                }
                Log.d("a",Integer.toString(num));
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                if (num == 0 && swChecked) {
                    dp.setVisibility(View.VISIBLE);
                    tp.setVisibility(View.GONE);
                    ll1.setVisibility(View.GONE);
                    ll2.setVisibility(View.GONE);
                    ll3.setVisibility(View.VISIBLE);
                    bt1.setEnabled(false);
                } else if (num == 1 && swChecked) {
                    dp.setVisibility(View.GONE);
                    tp.setVisibility(View.VISIBLE);
                    ll1.setVisibility(View.GONE);
                    ll2.setVisibility(View.GONE);
                    bt1.setEnabled(true);
                } else if (num == 2 && swChecked) {
                    dp.setVisibility(View.GONE);
                    tp.setVisibility(View.GONE);
                    ll1.setVisibility(View.VISIBLE);
                    ll2.setVisibility(View.GONE);
                    bt2.setEnabled(true);
                } else if (num == 3 && swChecked) {
                    tv2.setText(dp.getYear()+"년 "+dp.getMonth()+"월 "+dp.getDayOfMonth()+"일");
                    tv3.setText(tp.getHour()+"시"+tp.getMinute()+"분");
                    String adult = et1.getText().toString();
                    tv4.setText(adult+"명");
                    String youth = et2.getText().toString();
                    tv5.setText(youth+"명");
                    String kid = et3.getText().toString();
                    tv6.setText(kid+"명");
                    dp.setVisibility(View.GONE);
                    tp.setVisibility(View.GONE);
                    ll1.setVisibility(View.GONE);
                    ll2.setVisibility(View.VISIBLE);
                    bt2.setEnabled(false);
                }
                Log.d("a",Integer.toString(num));
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                swChecked=isChecked;
                if (isChecked) {
                    num = 0;
                    cm.setBase(SystemClock.elapsedRealtime());
                    cm.start();
                    dp.setVisibility(View.VISIBLE);
                    tp.setVisibility(View.GONE);
                    ll1.setVisibility(View.GONE);
                    ll2.setVisibility(View.GONE);
                    ll3.setVisibility(View.VISIBLE);
                    bt1.setEnabled(false);
                    bt2.setEnabled(true);
                }else{
                    cm.setBase(SystemClock.elapsedRealtime());
                    cm.stop();
                    dp.setVisibility(View.GONE);
                    tp.setVisibility(View.GONE);
                    ll1.setVisibility(View.GONE);
                    ll2.setVisibility(View.GONE);
                    ll3.setVisibility(View.GONE);
                }
            }
        });
    }
}
