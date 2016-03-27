package com.example.applycation.calculator.activities;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applycation.calculator.R;
import com.example.applycation.calculator.calculatorhandler.Check;
import com.fathzer.soft.javaluator.examples.ExtendedDoubleEvaluator;

import org.w3c.dom.Text;

public class NormalCalculator extends AppCompatActivity implements View.OnClickListener {

    String expressionString;

    TextView text_Result,text_smallResult;

    Button numpad[];
    Button numpad_ANS,numpad_sin,numpad_cos,numpad_tan,numpad_cot;

    Button math_Plus,math_Minus,math_Multi,math_Divide;

    Button action_Equal,action_CE,action_C, action_Back,action_shift;

    Button math_Can3,math_Can2,math_Mu,math_Mu2,math_Mu3,math_1phanX,math_AchiaB,math_phanTram;

    private boolean isInputAbletoNewExpression;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_normal);

        attachIdToView();
        attachOnClickListener();


        isInputAbletoNewExpression = true;
        expressionString="0";
        text_Result.setText("0");
        text_smallResult.setText(expressionString);
    }
    public void attachIdToView(){

        //text
        text_Result = (TextView)findViewById(R.id.text_Result);
        text_smallResult = (TextView)findViewById(R.id.text_SmallResult);

        numpad_ANS = (Button) findViewById(R.id.button_numpad_ans);

        //numpad

        numpad = new Button[17];
        numpad[0] = (Button) findViewById(R.id.button_numpad_0);
        numpad[1] = (Button) findViewById(R.id.button_numpad_1);
        numpad[2] = (Button) findViewById(R.id.button_numpad_2);
        numpad[3] = (Button) findViewById(R.id.button_numpad_3);
        numpad[4] = (Button) findViewById(R.id.button_numpad_4);
        numpad[5] = (Button) findViewById(R.id.button_numpad_5);
        numpad[6] = (Button) findViewById(R.id.button_numpad_6);
        numpad[7] = (Button) findViewById(R.id.button_numpad_7);
        numpad[8] = (Button) findViewById(R.id.button_numpad_8);
        numpad[9] = (Button) findViewById(R.id.button_numpad_9);
        numpad[10] = (Button) findViewById(R.id.button_numpad_dot);

        numpad[11] = (Button) findViewById(R.id.button_numpad_mongoac);
        numpad[12] = (Button) findViewById(R.id.button_numpad_dongngoac);


        numpad[13] = (Button) findViewById(R.id.button_numpad_sin);
        numpad[14] = (Button) findViewById(R.id.button_numpad_cos);
        numpad[15] = (Button) findViewById(R.id.button_numpad_tan);
        numpad[16] = (Button) findViewById(R.id.button_numpad_cot);


        //math
        math_Plus = (Button) findViewById(R.id.button_Math_plus);
        math_Minus = (Button) findViewById(R.id.button_Math_minus);
        math_Multi = (Button) findViewById(R.id.button_Math_multiply);
        math_Divide = (Button) findViewById(R.id.button_Math_divide);
        math_Can2 = (Button)findViewById(R.id.button_Math_can);
        math_Can3 = (Button)findViewById(R.id.button_Math_can3);
        math_Mu = (Button)findViewById(R.id.button_Math_mu);
        math_Mu2 = (Button)findViewById(R.id.button_Math_mu2);
        math_Mu3 = (Button)findViewById(R.id.button_Math_mu3);
        math_1phanX = (Button)findViewById(R.id.button_Math_divideX);
        math_AchiaB=(Button)findViewById(R.id.button_Math_phanso);
        math_phanTram = (Button) findViewById(R.id.button_Math_phanTram);


        //action
        action_Equal = (Button)findViewById(R.id.button_action_equal);
        action_CE = (Button)findViewById(R.id.button_action_CE);
        action_C = (Button)findViewById(R.id.button_action_C);
        action_Back = (Button)findViewById(R.id.button_action_back);
        action_shift = (Button)findViewById(R.id.button_action_shift);

    }
    public void attachOnClickListener(){
        for(Button num:numpad)
            num.setOnClickListener(this);
        /*numpad_sin.setOnClickListener(this);
        numpad_cos.setOnClickListener(this);
        numpad_tan.setOnClickListener(this);
        numpad_cot.setOnClickListener(this);*/
        numpad_ANS.setOnClickListener(this);

        math_Plus.setOnClickListener(this);
        math_Minus.setOnClickListener(this);
        math_Multi.setOnClickListener(this);
        math_Divide.setOnClickListener(this);
        math_Can2.setOnClickListener(this);
        math_Can3.setOnClickListener(this);
        math_Mu.setOnClickListener(this);
        math_Mu2.setOnClickListener(this);
        math_Mu3.setOnClickListener(this);
        math_1phanX.setOnClickListener(this);
        math_AchiaB.setOnClickListener(this);
        math_phanTram.setOnClickListener(this);

        action_Equal.setOnClickListener(this);
        action_CE.setOnClickListener(this);
        action_C.setOnClickListener(this);
        action_Back.setOnClickListener(this);
        action_shift.setOnClickListener(this);

    }

    public void starColorAnimaton(View v,int color){
        int colorStar = Color.WHITE;
        int colorEnd = color;
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(
                v, "backgroundColor", colorStar, colorEnd
        );
        valueAnimator.setDuration(100);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setRepeatCount(1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }

    @Override
    public void onClick(View v) {
        //Set onclick color for button
        starColorAnimaton(v, 0xFF55AAFF);

        if(v.getId()==action_Equal.getId()){
            try {
                ExtendedDoubleEvaluator evaluator = new ExtendedDoubleEvaluator();
                double result = evaluator.evaluate(expressionString);
                String result_str = result + "";
                expressionString = result_str;
                text_Result.setText(result_str + "");
                isInputAbletoNewExpression = false;
            }catch (Exception ex){
                expressionString="";
                text_Result.setText("LỖI");
            }
            return;
        }
        for(int i=0;i<numpad.length;i++) {
            if (numpad[i].getId() == v.getId()) {
                if (!isInputAbletoNewExpression || expressionString.equals("0")) {
                    expressionString = "";
                }
                expressionString += numpad[i].getText();
                if(i>=13&&i<=16)
                    expressionString+="(";
            }
        }
        expressionString=expressionString.replace("cot","1/tan");

        switch (v.getId()) {
            case R.id.button_action_C:
                expressionString = "";
                text_Result.setText("");
                break;
            case R.id.button_action_CE:
                int dem = 1;
                for (int i = 0; i < expressionString.length(); i++) {
                    if (Check.isNumber(expressionString.substring(expressionString.length() - dem)))
                        dem++;
                    else break;
                }
                expressionString = expressionString.substring(0, expressionString.length() + 1 - dem);
                break;
            case R.id.button_action_back:
                if (expressionString.substring(expressionString.length() - 5).contains("sqrt"))
                    expressionString = expressionString.substring(0, expressionString.lastIndexOf("sqrt"));
                else if (expressionString.substring(expressionString.length() - 4).contains("sin"))
                    expressionString = expressionString.substring(0, expressionString.lastIndexOf("sin"));
                else if (expressionString.substring(expressionString.length() - 4).contains("cos"))
                    expressionString = expressionString.substring(0, expressionString.lastIndexOf("cos"));
                else if (expressionString.substring(expressionString.length() - 4).contains("tan"))
                    expressionString = expressionString.substring(0, expressionString.lastIndexOf("tan"));
                else
                    expressionString = expressionString.substring(0, expressionString.length() - 1);
                break;
            case R.id.button_Math_plus:
                expressionString += "+";
                break;
            case R.id.button_Math_minus:
                expressionString += "-";
                break;
            case R.id.button_Math_multiply:
                expressionString += "*";
                break;
            case R.id.button_Math_divide:
                expressionString += "/";
                break;
            case R.id.button_Math_mu:
                expressionString += "^";
                break;
            case R.id.button_Math_phanTram:
                expressionString += "/100";
                break;
            case R.id.button_Math_divideX:
                expressionString += "1/";
                break;
            case R.id.button_Math_phanso:
                expressionString += "/";
                break;
            case R.id.button_Math_mu2:
                expressionString += "^2";
                break;
            case R.id.button_Math_mu3:
                expressionString += "^3";
                break;
            case R.id.button_Math_can:
                expressionString += "sqrt(";
                break;

        }

        if(expressionString.equals(""))expressionString="0";
        isInputAbletoNewExpression=true;
        String lastChar = expressionString.charAt(expressionString.length()-1)+"";
        text_smallResult.setText(Check.toViewString(expressionString));
    }
}
