package com.example.test123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    //private double sort;
    private String ss = "";
    String D;
    private int E = 0;
    double num1;
    double num2;
    double result;
    ArrayList<Double> listA = new ArrayList<>();
    ArrayList<String> listB = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        setTitle("계산기");

        text = findViewById(R.id.text);
    }


    public void onClick(View v) {

        String s = text.getText().toString();

        if (v.getId() == R.id.but1) {
            text.setText(s + "1");
            ss = ss + "1";
        }
        if (v.getId() == R.id.but2) {
            text.setText(s + "2");
            ss = ss + "2";
        }
        if (v.getId() == R.id.but3) {
            text.setText(s + "3");
            ss = ss + "3";
        }
        if (v.getId() == R.id.but4) {
            text.setText(s + "4");
            ss = ss + "4";
        }
        if (v.getId() == R.id.but5) {
            text.setText(s + "5");
            ss = ss + "5";
        }
        if (v.getId() == R.id.but6) {
            text.setText(s + "6");
            ss = ss + "6";
        }
        if (v.getId() == R.id.but7) {
            text.setText(s + "7");
            ss = ss + "7";
        }
        if (v.getId() == R.id.but8) {
            text.setText(s + "8");
            ss = ss + "8";
        }
        if (v.getId() == R.id.but9) {
            text.setText(s + "9");
            ss = ss + "9";
        }
        if (v.getId() == R.id.but0) {
            text.setText(s + "0");
            ss = ss + "0";
        }
        if (v.getId() == R.id.butplus) {
            if (s.equals(""))
                text.setText("ERROR");
                //Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
            else {
                //sort = Double.parseDouble(s);
                listB.add("+");
                if (ss == "")
                    text.setText("ERROR");
                else {
                    listA.add(Double.parseDouble(ss));
                    ss = "";
                    text.setText(s + "+");
                }
            }
        }

        if (v.getId() == R.id.butminus) {
            if (s.equals(""))
                text.setText("ERROR");
                //Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
            else {
                listB.add("-");
                if (ss == "")
                    text.setText("ERROR");
                else {
                    listA.add(Double.parseDouble(ss));
                    ss = "";
                    text.setText(s + "-");
                }

            }
        }

        if (v.getId() == R.id.butgob) {
            if (s.equals(""))
                text.setText("ERROR");
                //Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
            else {
                //sort = Double.parseDouble(s);
                listB.add("*");
                if (ss == "")
                    text.setText("ERROR");
                else {
                    listA.add(Double.parseDouble(ss));
                    ss = "";
                    text.setText(s + "*");
                }

            }
        }

        if (v.getId() == R.id.butna) {
            if (s.equals(""))
                text.setText("ERROR");
                //Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
            else {
                listB.add("/");
                if (ss == "")
                    text.setText("ERROR");
                else {
                    listA.add(Double.parseDouble(ss));
                    ss = "";
                    text.setText(s + "/");
                }

            }
        }

        if (v.getId() == R.id.butclear) {
            text.setText("");
            ss = "";
            listA.clear();
            listB.clear();
        }

        if (v.getId() == R.id.butnun) {
            if (s.equals(""))
                text.setText("ERROR");
                //Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
            else if (listA.size() <= listB.size())
                text.setText("ERROR");
            else {

                listA.add(Double.parseDouble(ss));
                ss = "";
                while (true) {
                    int size = listB.size();
                    int t = 0;
                    for (int i = 0; i < size; i++) {
                        D = listB.get(i);
                        if (D.equals("*") || D.equals("/")) {
                            num1 = listA.get(i);
                            num2 = listA.get(i + 1);
                            if (D.equals("*"))
                                num1 = num1 * num2;
                            if (D.equals("/")) {
                                if (num2 == 0) {
                                    text.setText("ERROR");
                                    E = 1;
                                    break;
                                }
                                num1 = num1 / num2;
                            }
                            listA.set(i, num1);
                            listA.remove(i + 1);
                            listB.remove(i);
                            t = 1;
                            break;
                        }
                    }
                    if (t==0){
                        break;
                    }

                }

                if (!listB.isEmpty()) {
                    int size = listB.size();
                    for (int i = 0; i< size; i++) {
                        D = listB.get(i);
                        num1 = listA.get(i);
                        num2 = listA.get(i + 1);
                        if (D.equals("+"))
                            num1 = num1 + num2;
                        if (D.equals("-"))
                            num1 = num1 - num2;
                        listA.set(i, num1);
                        listA.remove(i + 1);
                    }

                }
                if (E == 0) {
                    result = listA.get(0);
                    text.setText(s + "=" + result);
                }

            }
        }

    }

}
