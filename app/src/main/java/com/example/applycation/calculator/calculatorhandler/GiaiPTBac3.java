package com.example.applycation.calculator.calculatorhandler;

/**
 * Created by Apink on 30/03/2016.
 */
public class GiaiPTBac3 extends GiaiPTBac2{

    private double d;

    public GiaiPTBac3(){
        super();
        d = 0;
    }

    public double getD() {
        return d;
    }
    public void setD(double d) {
        this.d = d;
    }

    public String SolveGiaiPTB3(){
        if(a == 0) super.solvePTB2();
        else{
            double delta = b*b - 3*a*c;
            double k = (9*a*b*c - 2*Math.pow(b, 3)- 27*a*a*d)/(2*Math.sqrt(Math.pow(Math.abs(delta),3)));
            if(a < 0){
                double x = Math.sqrt(Math.abs(delta))/(3*a)*(Math.pow(k + Math.sqrt(k*k+1),-1/3) + Math.pow(k - Math.sqrt(k*k+1),-1/3)) - b/3/a;
                s = "Phương trình có nghiệm duy nhất : x = " + x;
            }
            if(a == 0){
                double x = (-b + Math.pow(b*b*b - 27*a*a*d , -1/3))/(3*a);
                s = "Phương trình có nghiệm kép : x = " + x;
            }
            else{
                if(Math.abs(k) <= 1){
                    double x1 = (2*Math.sqrt(delta) * Math.cos(Math.acos(k)/3) - b )/3/a;
                    double x2 = (2*Math.sqrt(delta) * Math.cos(Math.acos(k)/3 - 2*Math.PI/3) - b )/3/a;
                    double x3 = (2*Math.sqrt(delta) * Math.cos(Math.acos(k)/3 + 2*Math.PI/3) - b )/3/a;
                    s = "Phương trình có 3 nghiệm: \n\tx1 = " + x1 + "\n\tx2 = " + x2 + "\n\tx3 = " + x3;
                }
                if(Math.abs(k) > 1){
                    double x = (Math.sqrt(delta) * Math.abs(k))/(3*a*k) * (Math.pow(Math.abs(k) + Math.sqrt(k*k+1),-1/3) + Math.pow(Math.abs(k) - Math.sqrt(k*k+1),-1/3)) - b/3/a;
                    s = "Phương trình có nghiệm duy nhất: x = " + x;
                }
            }
        }
        return s;
    }



}

