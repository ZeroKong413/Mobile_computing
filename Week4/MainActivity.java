package com.example.zxcv1;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    CheckBox check1, check2;

    RadioGroup bGroup1, bGroup2;

    ImageView imageView1;

    Matrix matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check1 = (CheckBox) findViewById(R.id.checkBox1);
        check2 = (CheckBox) findViewById(R.id.checkBox2);

        imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);


        bGroup1 = (RadioGroup) findViewById(R.id.bgroup1);
        bGroup2 = (RadioGroup) findViewById(R.id.bgroup2);
        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check2.setChecked(false);
                    bGroup1.setVisibility(View.VISIBLE); // 남자 그룹 체크 시 남자 라디오 그룹 표시
                    bGroup2.setVisibility(View.GONE); // 여자 그룹 체크 시 여자 라디오 그룹 숨김
                }
            }
        });
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check1.setChecked(false);
                    bGroup2.setVisibility(View.VISIBLE);
                    bGroup1.setVisibility(View.GONE);
                }
            }
        });
        bGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                StringBuilder mStr = new StringBuilder();

                if(checkedId == R.id.b1){
                    mStr.append("소연 selected!");
                    imageView1.setImageResource(R.drawable.so);
                }
                else if(checkedId == R.id.b2){
                    mStr.append("우기 selected!");
                    imageView1.setImageResource(R.drawable.woo);
                }
                else {
                    mStr.append("미연 selected!");
                    imageView1.setImageResource(R.drawable.mi);
                }

            }
        });


    }
}