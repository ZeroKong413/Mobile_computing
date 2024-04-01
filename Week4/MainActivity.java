package com.example.zxcv1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    CheckBox check1, check2;

    RadioGroup bGroup1, bGroup2, cGroup1;

    ImageView imageView1;

    Matrix matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        check1 = (CheckBox) findViewById(R.id.checkBox1);
        check2 = (CheckBox) findViewById(R.id.checkBox2);

        imageView1 = (ImageView) findViewById(R.id.imageView);

        bGroup1 = (RadioGroup) findViewById(R.id.bgroup1);
        bGroup2 = (RadioGroup) findViewById(R.id.bgroup2);
        cGroup1 = (RadioGroup) findViewById(R.id.cgroup1);
        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { // 체크 박스 1번 체크 시
                    check2.setChecked(false); // 체크 박스 2번 체크 해제
                    bGroup1.clearCheck(); // 그룹 1 버튼 초기화
                    imageView1.setImageResource(0); // 이미지 초기화
                    bGroup1.setVisibility(View.VISIBLE); // 그룹1 버튼 표시
                    bGroup2.setVisibility(View.GONE); // 그룹2 버튼 숨김

                }
            }
        });
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check1.setChecked(false);
                    bGroup2.clearCheck();
                    imageView1.setImageResource(0);
                    bGroup2.setVisibility(View.VISIBLE);
                    bGroup1.setVisibility(View.GONE);

                }
            }
        });
        bGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.b1){ // 각각의 맞는 사진을 보여줌
                    imageView1.setImageResource(R.drawable.so);
                }
                else if(checkedId == R.id.b2){
                    imageView1.setImageResource(R.drawable.woo);
                }
                else {
                    imageView1.setImageResource(R.drawable.mi);
                }

            }
        });
        bGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                if(checkedId == R.id.bb1){
                    imageView1.setImageResource(R.drawable.won);
                }
                else if(checkedId == R.id.bb2){
                    imageView1.setImageResource(R.drawable.jeong);
                }
                else {
                    imageView1.setImageResource(R.drawable.ho);
                }
            }
//
        });
        cGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                matrix = new Matrix();
                if(checkedId == R.id.c1){ // 각각에 맞는 ScaleType으로 변환
                    imageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                else if(checkedId == R.id.c2){ // 2배 Scale
                    matrix.postScale(2f,2f);
                    imageView1.setScaleType(ImageView.ScaleType.MATRIX);
                    imageView1.setImageMatrix(matrix);
                }
                else if(checkedId == R.id.c3){
                    imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
                }
                else{
                    imageView1.setScaleType(ImageView.ScaleType.CENTER);
                }

            }
        });


    }
}