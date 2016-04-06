package com.example.applycation.calculator.calculatorhandler;

/**
 * Created by Apink on 30/03/2016.
 */
public class GiaiPTBac2 extends GiaiPTBac1{

    protected double b;
    public GiaiPTBac2(){
        super();
        b = 0;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }

    public String solvePTB2(){
        if(b == 0)	super.solve();    //bx^2 + cx + d = 0
        else{
            double delta = c*c - 4*b*d;
            if(delta < 0) s = "Phương trình vô nghiệm!";
            if(delta == 0) s = "Phương trình có 1 nghiệm: x = " + -c/2/b;
            if(delta > 0) s = "Phương trình có 2 nghiệm: \n\tx1 = " +
                    (-c-Math.sqrt(delta))/2/b + "\n\tx2 = " +
                    (-c+Math.sqrt(delta))/2/b;
        }
        return s;
    }


}
