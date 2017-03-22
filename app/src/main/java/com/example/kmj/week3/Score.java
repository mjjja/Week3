package com.example.kmj.week3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends AppCompatActivity {
    EditText et1, et2, et3;
    Button bt1, bt2;
    TextView tv1, tv2;
    ImageView iv1,iv2,iv3,iv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        setTitle("학점 계산기");
        init();

    }

    void init(){
        et1=(EditText)findViewById(R.id.lang);
        et2=(EditText)findViewById(R.id.math);
        et3=(EditText)findViewById(R.id.english);
        bt1=(Button)findViewById(R.id.calc);
        bt2=(Button)findViewById(R.id.init);
        tv1=(TextView)findViewById(R.id.total);
        tv2=(TextView)findViewById(R.id.average);
        iv1=(ImageView)findViewById(R.id.imageView1);
        iv2=(ImageView)findViewById(R.id.imageView2);
        iv3=(ImageView)findViewById(R.id.imageView3);
        iv4=(ImageView)findViewById(R.id.imageView4);



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lang = et1.getText().toString();
                int langscore = Integer.parseInt(lang);
                String math = et2.getText().toString();
                int mathscore = Integer.parseInt(math);
                String english = et3.getText().toString();
                int englishscore = Integer.parseInt(english);
                int total = langscore+mathscore+englishscore;

                tv1.setText(total+"점");
                tv2.setText(total/3+"점");

                if (total/3>=90){
                    iv1.setVisibility(View.VISIBLE);
                }else if (total/3>=80){
                    iv2.setVisibility(View.VISIBLE);
                }else if (total/3>=70){
                    iv3.setVisibility(View.VISIBLE);
                }else{
                    iv4.setVisibility(View.VISIBLE);
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
                tv1.setText("0점");
                tv2.setText("0점");
                iv1.setVisibility(View.GONE);
                iv2.setVisibility(View.GONE);
                iv3.setVisibility(View.GONE);
                iv4.setVisibility(View.GONE);

                Toast.makeText(getApplicationContext(), "초기화 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
