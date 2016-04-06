package com.example.applycation.calculator.activities;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.applycation.calculator.R;
import com.example.applycation.calculator.calculatorhandler.Check;
import com.example.applycation.calculator.calculatorhandler.Expression;

import java.math.BigDecimal;

public class ActivityNorCalculator extends MainMenuActivity implements View.OnClickListener {

    String expressionString;
    BigDecimal ans;

    TextView text_Result,text_smallResult;

    Button numpad[];

    Button math_Plus,math_Minus,math_Multi,math_Divide;

    Button action_Equal,action_C, action_Back;

    Button math_Can2,math_Mu,math_Mu2,math_1phanX,math_phanTram;

    private boolean isInputAbletoNewExpression;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_normal);

        attachIdToView();
        attachOnClickListener();


        isInputAbletoNewExpression = true;
        ans=new BigDecimal(0);
        expressionString="0";
        text_Result.setText("0");
        text_smallResult.setText(expressionString);
    }
    public void attachIdToView(){
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/DejaVuSans.ttf");

        //text
        text_Result = (TextView)findViewById(R.id.text_Result);
        text_smallResult = (TextView)findViewById(R.id.text_SmallResult);

        //numpad

        numpad = new Button[18];
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

        numpad[17] = (Button) findViewById(R.id.button_numpad_ans);

        for(Button num:numpad){
            num.setTypeface(custom_font);
        }

        //math
        math_Plus = (Button) findViewById(R.id.button_Math_plus);
        math_Minus = (Button) findViewById(R.id.button_Math_minus);
        math_Multi = (Button) findViewById(R.id.button_Math_multiply);
        math_Divide = (Button) findViewById(R.id.button_Math_divide);
        math_Can2 = (Button)findViewById(R.id.button_Math_can);
        math_Mu = (Button)findViewById(R.id.button_Math_mu);
        math_Mu2 = (Button)findViewById(R.id.button_Math_mu2);
        math_1phanX = (Button)findViewById(R.id.button_Math_divideX);
        math_phanTram = (Button) findViewById(R.id.button_Math_phanTram);
        math_Mu.setTypeface(custom_font);
        math_Mu2.setTypeface(custom_font);
        math_Can2.setTypeface(custom_font);

        //action
        action_Equal = (Button)findViewById(R.id.button_action_equal);
        action_C = (Button)findViewById(R.id.button_action_C);
        action_Back = (Button)findViewById(R.id.button_action_back);
        action_Back.setTypeface(custom_font);

    }
    public void attachOnClickListener(){
        for(Button num:numpad)
            num.setOnClickListener(this);

        math_Plus.setOnClickListener(this);
        math_Minus.setOnClickListener(this);
        math_Multi.setOnClickListener(this);
        math_Divide.setOnClickListener(this);
        math_Can2.setOnClickListener(this);
        math_Mu.setOnClickListener(this);
        math_Mu2.setOnClickListener(this);
        math_1phanX.setOnClickListener(this);
        math_phanTram.setOnClickListener(this);

        action_Equal.setOnClickListener(this);
        action_C.setOnClickListener(this);
        action_Back.setOnClickListener(this);

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
                expressionString=expressionString.replace("Ans",ans.doubleValue()+"");
                ans = new Expression(expressionString).eval();
                //ans = result;
                expressionString="Ans"+"";
                text_Result.setText(Check.scaleValue(ans,6));
                isInputAbletoNewExpression = false;
            }catch (Exception ex){
                expressionString="0";
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
            case R.id.button_action_back:
                if (expressionString.length()>=3&&expressionString.substring(expressionString.length() - 3).contains("Ans"))
                    expressionString = expressionString.substring(0, expressionString.lastIndexOf("Ans"));
                else if (expressionString.length()>=5&&expressionString.substring(expressionString.length() - 5).contains("sqrt"))
                    expressionString = expressionString.substring(0, expressionString.lastIndexOf("sqrt"));
                else if (expressionString.length()>=4&&expressionString.substring(expressionString.length() - 4).contains("sin"))
                    expressionString = expressionString.substring(0, expressionString.lastIndexOf("sin"));
                else if (expressionString.length()>=4&&expressionString.substring(expressionString.length() - 4).contains("cos"))
                    expressionString = expressionString.substring(0, expressionString.lastIndexOf("cos"));
                else if (expressionString.length()>=4&&expressionString.substring(expressionString.length() - 4).contains("tan"))
                    expressionString = expressionString.substring(0, expressionString.lastIndexOf("tan"));
                else if (expressionString.length()>=4&&expressionString.substring(expressionString.length() - 4).contains("cot"))
                    expressionString = expressionString.substring(0, expressionString.lastIndexOf("cot"));
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
                if(expressionString.contains("Ans")&&expressionString.length()<=3)
                    expressionString="";
                expressionString += "1/";
                break;
            case R.id.button_Math_mu2:
                expressionString += "^2";
                break;
            case R.id.button_Math_can:
                expressionString += "sqrt(";
                break;
        }
        if(expressionString.equals(""))expressionString="0";
        isInputAbletoNewExpression=true;
        text_smallResult.setText(Check.toViewString(expressionString));
    }
}
