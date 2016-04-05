package com.example.applycation.calculator.activities.Activity_TabLayout_GiaiPT;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.applycation.calculator.R;
import com.example.applycation.calculator.calculatorhandler.GiaiPTBac1;

/**
 * Created by Apink on 27/03/2016.
 */
public class FragmentPtBac1 extends Fragment implements View.OnClickListener{
    View view;
    String strA="", strB="";
    Button but0, but1, but2, but3, but4, but5, but6,but7, but8, but9, butDot, butMinus, butResult;
    TextView textResult;
    EditText textA, textB;
    GiaiPTBac1 giai = new GiaiPTBac1();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.giai_pt_bac1_layout,container,false);
        attachIDView();
        attachToListener();



        return view;
    }
    public void attachIDView(){
        textA = (EditText)view.findViewById(R.id.text_a);
        textB = (EditText)view.findViewById(R.id.text_b);

        but0 = (Button)view.findViewById(R.id.button_0);
        but1 = (Button)view.findViewById(R.id.button_1);
        but2 = (Button)view.findViewById(R.id.button_2);
        but3 = (Button)view.findViewById(R.id.button_3);
        but4 = (Button)view.findViewById(R.id.button_4);
        but5 = (Button)view.findViewById(R.id.button_5);
        but6 = (Button)view.findViewById(R.id.button_6);
        but7 = (Button)view.findViewById(R.id.button_7);
        but8 = (Button)view.findViewById(R.id.button_8);
        but9 = (Button)view.findViewById(R.id.button_9);
        butDot = (Button)view.findViewById(R.id.button_dot);
        butMinus = (Button)view.findViewById(R.id.button_minus);
        butResult =(Button)view.findViewById(R.id.button_action_result);
        textResult = (TextView)view.findViewById(R.id.text_Result);
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
        if(v.getId()==R.id.text_a) strA = "";
        if(v.getId()==R.id.text_b) strB = "";
        if(textA.isFocused()){
            switch (v.getId()){
                case R.id.button_0:  strA+="0"; break;
                case R.id.button_1:  strA+="1"; break;
                case R.id.button_2:  strA+="2"; break;
                case R.id.button_3:  strA+="3"; break;
                case R.id.button_4:  strA+="4"; break;
                case R.id.button_5:  strA+="5"; break;
                case R.id.button_6:  strA+="6"; break;
                case R.id.button_7:  strA+="7"; break;
                case R.id.button_8:  strA+="8"; break;
                case R.id.button_9:  strA+="9"; break;
                case R.id.button_dot:    strA+="."; break;
            }
        }
        if(textB.isFocused()){
            switch (v.getId()){
                case R.id.button_0:  strB+="0"; break;
                case R.id.button_1:  strB+="1"; break;
                case R.id.button_2:  strB+="2"; break;
                case R.id.button_3:  strB+="3"; break;
                case R.id.button_4:  strB+="4"; break;
                case R.id.button_5:  strB+="5"; break;
                case R.id.button_6:  strB+="6"; break;
                case R.id.button_7:  strB+="7"; break;
                case R.id.button_8:  strB+="8"; break;
                case R.id.button_9:  strB+="9"; break;
                case R.id.button_dot:    strB+="."; break;
            }
        }
        textA.setText(strA);
        textB.setText(strB);
        if(v.getId()==R.id.button_action_result){
            giai.setA(Double.parseDouble(strA));
            giai.setB(Double.parseDouble(strB));
            textResult.setText(giai.solve());
        }
    }
}
