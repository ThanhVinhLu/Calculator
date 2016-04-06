package com.example.applycation.calculator.calculatorhandler;

/**
 * Created by Apink on 30/03/2016.
 */
public class GiaiPTBac1 {

    protected double c, d;
    protected String s;

    public GiaiPTBac1(){
        c = d = 0;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public String solve(){
        if(c == 0) {
            if (d != 0) s = "Phương trình vô nghiệm!";
            else s = "Phương trình vô số nghiệm!";
        }
        else	s = "Phương trình có một nghiệm: x = " + -d/c;
        return s;
    }



}

