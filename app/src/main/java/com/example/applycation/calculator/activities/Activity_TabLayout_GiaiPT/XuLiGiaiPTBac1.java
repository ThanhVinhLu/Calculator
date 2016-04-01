package com.example.applycation.calculator.activities.Activity_TabLayout_GiaiPT;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.applycation.calculator.R;
import com.example.applycation.calculator.calculatorhandler.GiaiPTBac1;

/**
 * Created by Apink on 31/03/2016.
 */
public class XuLiGiaiPTBac1 extends AppCompatActivity implements View.OnClickListener {


    GiaiPTBac1 giaiPT = new GiaiPTBac1();
    String strA, strB;
    EditText textA, textB;
    Button but0, but1, but2, but3, but4, but5, but6, but7, but8, but9, butDot, butMinus, butResult;
    TextView result;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giai_pt_bac1_layout);

        //attachIDView();
        //attachToListener();

        but0 = (Button)findViewById(R.id.button_0);
        but0.setOnClickListener(this);
    }




    public void attachIDView(){
        textA = (EditText)findViewById(R.id.text_a);
        textB = (EditText)findViewById(R.id.text_b);

        but0 = (Button)findViewById(R.id.button_0);
        but1 = (Button)findViewById(R.id.button_1);
        but2 = (Button)findViewById(R.id.button_2);
        but3 = (Button)findViewById(R.id.button_3);
        but4 = (Button)findViewById(R.id.button_4);
        but5 = (Button)findViewById(R.id.button_5);
        but6 = (Button)findViewById(R.id.button_6);
        but7 = (Button)findViewById(R.id.button_7);
        but8 = (Button)findViewById(R.id.button_8);
        but9 = (Button)findViewById(R.id.button_9);
        butDot = (Button)findViewById(R.id.button_dot);
        butMinus = (Button)findViewById(R.id.butngang);
        butResult =(Button)findViewById(R.id.button_action_result);
        result = (TextView)findViewById(R.id.text_Result);

    }

    public void attachToListener(){
        textA.setOnClickListener(this);
        textB.setOnClickListener(this);

        butResult.setOnClickListener(this);
        butMinus.setOnClickListener(this);
        butDot.setOnClickListener(this);
        but0.setOnClickListener(this);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);
        but9.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_0: strA += "0"; textA.setText(strA); result.setText(strA);  break;
            /*case R.id.button_1: strA += "1"; break;
            case R.id.button_2: strA += "2"; break;
            case R.id.button_3: strA += "3"; break;
            case R.id.button_4: strA += "4"; break;
            case R.id.button_5: strA += "5"; break;
            case R.id.button_6: strA += "6"; break;
            case R.id.button_7: strA += "7"; break;
            case R.id.button_8: strA += "8"; break;
            case R.id.button_9: strA += "9"; break;
            case R.id.button_dot: strA += ".";   break;*/
        }
/*

        if(textA.isFocused()){
            switch (v.getId()){
                case R.id.button_0: strA += "0"; break;
                case R.id.button_1: strA += "1"; break;
                case R.id.button_2: strA += "2"; break;
                case R.id.button_3: strA += "3"; break;
                case R.id.button_4: strA += "4"; break;
                case R.id.button_5: strA += "5"; break;
                case R.id.button_6: strA += "6"; break;
                case R.id.button_7: strA += "7"; break;
                case R.id.button_8: strA += "8"; break;
                case R.id.button_9: strA += "9"; break;
                case R.id.button_dot: strA += ".";   break;
            }
            textA.setText(strA);
        }
        if(textB.isFocused()){
            switch (v.getId()){
                case R.id.button_0: strB += "0"; break;
                case R.id.button_1: strB += "1"; break;
                case R.id.button_2: strB += "2"; break;
                case R.id.button_3: strB += "3"; break;
                case R.id.button_4: strB += "4"; break;
                case R.id.button_5: strB += "5"; break;
                case R.id.button_6: strB += "6"; break;
                case R.id.button_7: strB += "7"; break;
                case R.id.button_8: strB += "8"; break;
                case R.id.button_9: strB += "9"; break;
                case R.id.button_dot: strB += ".";   break;
            }
            textB.setText(strB);
        }

        if(v.getId()==butResult.getId()){
            strA = textA.getText().toString();
            strB = textB.getText().toString();

            Double numA = Double.parseDouble(strA);
            Double numB = Double.parseDouble(strB);
            giaiPT.setA(numA);
            giaiPT.setB(numB);
            result.setText(giaiPT.solve());
            strA = strB = "";
        }*/
    }
}
