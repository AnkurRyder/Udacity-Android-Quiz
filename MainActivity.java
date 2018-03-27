package com.example.android.quiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList <String> Ques = new ArrayList <>(3);
    ArrayList <String> Option = new ArrayList<>(9);
    int[] ans ={0 , 0 , 1};
    int i = 1;
    int [] count = {0 , 0, 0};
    RadioButton radioButton0,radioButton1,radioButton2;
    Button start;
    Chronometer focus;
    TextView scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        focus = (Chronometer)findViewById(R.id.chronometer2);
        createQues();
        createOpt();
        radioButton0 = (RadioButton) findViewById(R.id.A0);
        radioButton1 = (RadioButton) findViewById(R.id.A1);
        radioButton2 = (RadioButton) findViewById(R.id.A2);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                focus.start();
                start.setText("Skip");
                if(i <= 3) {
                    displayQuestion(i);
                    displayAnswer(i);
                    i += 1;
                }
                else
                {
                    start.setVisibility(View.GONE);
                    radioButton0.setVisibility(View.GONE);
                    radioButton1.setVisibility(View.GONE);
                    radioButton2.setVisibility(View.GONE);
                    focus.stop();
                    displayResult();
                }
            }
        });

    }


    public  void createQues()
    {
        Ques.add(0,"The first Prime Minister of Bangladesh was");
        Ques.add(1 ,"The longest river in the world is the");
        Ques.add(2 , "The longest highway in the world is the");
    }

    public void createOpt()
    {
        Option.add(0 , "Mujibur Rehman");
        Option.add(1 , "Sheikh Hasina");
        Option.add(2 , "Khaleda Zia");
        Option.add(3 , "Nile");
        Option.add(4 , "Amazon");
        Option.add(5 ,"Ganaga");
        Option.add(6 , "Trans-Canada");
        Option.add(7 , "Pan American Highway");
        Option.add(8 , "Highway 1 , Australia");
    }
    public void displayQuestion(int q)
    {
        TextView scoreView = (TextView) findViewById(R.id.Question);

        scoreView.setText(String.valueOf("Q"+ q + ": " + Ques.get(q-1)));

    }

    public void displayAnswer(int q)
    {
        radioButton0 = (RadioButton) findViewById(R.id.A0);
        radioButton1 = (RadioButton) findViewById(R.id.A1);
        radioButton2 = (RadioButton) findViewById(R.id.A2);
        radioButton0.setText(String.valueOf(Option.get(3*(q-1))));
        radioButton1.setText(String.valueOf(Option.get(3*(q-1)+1)));
        radioButton2.setText(String.valueOf(Option.get(3*(q-1)+2)));
    }

    public void A(View view){
        if(ans[i-2] == 0 ){
            count[i-2] = 1;
        }
        if(i <4) {
            radioButton0.setChecked(false);
            displayQuestion(i);
            displayAnswer(i);
            i += 1;
        }
        else
        {
            focus = (Chronometer)findViewById(R.id.chronometer2);
            focus.stop();
            start.setVisibility(View.GONE);
            radioButton0.setVisibility(View.GONE);
            radioButton1.setVisibility(View.GONE);
            radioButton2.setVisibility(View.GONE);
            displayResult();
        }
    }

    public void B(View view){
        if(ans[i-2] == 1 ){
            count[i-2] = 1;
        }
        if(i<4) {
            radioButton1.setChecked(false);
            displayQuestion(i);
            displayAnswer(i);
            i += 1;
        }
        else
        {
            focus = (Chronometer)findViewById(R.id.chronometer2);
            focus.stop();
            start.setVisibility(View.GONE);
            radioButton0.setVisibility(View.GONE);
            radioButton1.setVisibility(View.GONE);
            radioButton2.setVisibility(View.GONE);
            displayResult();
        }
    }

    public void C(View view){
        if(ans[i-2] == 2 ){
            count[i-2] = 1;
        }
        if(i<4) {
            radioButton2.setChecked(false);
            displayQuestion(i);
            displayAnswer(i);
            i += 1;
        }
        else
        {
            focus = (Chronometer)findViewById(R.id.chronometer2);
            focus.stop();
            start.setVisibility(View.GONE);
            radioButton0.setVisibility(View.GONE);
            radioButton1.setVisibility(View.GONE);
            radioButton2.setVisibility(View.GONE);
            displayResult();
        }
    }

    public void displayResult()
    {
        scoreView = (TextView) findViewById(R.id.Question);
        int corr =0 ;
        for (int j = 0 ; j <3 ; j++)
        {
            if(count[j] == 1)
            {
                corr++;
            }
        }
        scoreView.setText(String.valueOf("Number of Question correct" + ":  " + corr));
    }
}
