package com.example.applycation.calculator.calculatorhandler;

/**
 * Created by Apink on 30/03/2016.
 */
public class GiaiPTBac1 {

    protected double a, b;
    protected String s;

    public GiaiPTBac1(){
        a = b =0;
    }

    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }

    public String solve(){
        if(a == 0 || b != 0)  s = "Phuong trinh vo nghiem!";
        if(a == 0 || b == 0)	s = "Phuong trinh co vo so nghiem!";
        else	s = "Phuong trinh co nghiem la: " + -b/a;
        return s;
    }



}

