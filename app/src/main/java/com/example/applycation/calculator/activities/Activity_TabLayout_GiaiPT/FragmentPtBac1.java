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
    String strC="", strD="";
    Button but0, but1, but2, but3, but4, but5, but6,but7, but8, but9, butDot, butMinus, butResult, butRefresh;
    TextView textResult;
    EditText textC, textD;
    GiaiPTBac1 giai = new GiaiPTBac1();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.giai_pt_bac1_layout,container,false);
        attachIDView();
        attachToListener();



        return view;
    }
    public void attachIDView(){
        textC = (EditText)view.findViewById(R.id.text_c);
        textD = (EditText)view.findViewById(R.id.text_d);

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
        butRefresh = (Button)view.findViewById(R.id.button_action_refresh);

        textResult = (TextView)view.findViewById(R.id.text_Result);
    }

    public void attachToListener(){
        textC.setOnClickListener(this);
        textD.setOnClickListener(this);

        butResult.setOnClickListener(this);
        butMinus.setOnClickListener(this);
        butDot.setOnClickListener(this);
        butRefresh.setOnClickListener(this);
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
        if(v.getId()==R.id.text_c) strC = "";
        if(v.getId()==R.id.text_d) strD = "";
        if(v.getId()==R.id.button_action_refresh){
            strC = strD = "";
        }

        if(textC.isFocused()){
            switch (v.getId()){
                case R.id.button_0:  strC+="0"; break;
                case R.id.button_1:  strC+="1"; break;
                case R.id.button_2:  strC+="2"; break;
                case R.id.button_3:  strC+="3"; break;
                case R.id.button_4:  strC+="4"; break;
                case R.id.button_5:  strC+="5"; break;
                case R.id.button_6:  strC+="6"; break;
                case R.id.button_7:  strC+="7"; break;
                case R.id.button_8:  strC+="8"; break;
                case R.id.button_9:  strC+="9"; break;
                case R.id.button_dot:    strC+="."; break;
                case R.id.button_minus:    strC+="-"; break;
            }
        }
        if(textD.isFocused()){
            switch (v.getId()){
                case R.id.button_0:  strD+="0"; break;
                case R.id.button_1:  strD+="1"; break;
                case R.id.button_2:  strD+="2"; break;
                case R.id.button_3:  strD+="3"; break;
                case R.id.button_4:  strD+="4"; break;
                case R.id.button_5:  strD+="5"; break;
                case R.id.button_6:  strD+="6"; break;
                case R.id.button_7:  strD+="7"; break;
                case R.id.button_8:  strD+="8"; break;
                case R.id.button_9:  strD+="9"; break;
                case R.id.button_dot:    strD+="."; break;
                case R.id.button_minus:    strD+="-"; break;
            }
        }
        textC.setText(strC);
        textD.setText(strD);
        if(v.getId()==R.id.button_action_result){
            giai.setC(Double.parseDouble(strC));
            giai.setD(Double.parseDouble(strD));
            textResult.setText(giai.solve());
        }
    }
}
