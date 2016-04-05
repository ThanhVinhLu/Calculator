package com.example.applycation.calculator.calculatorhandler;

/**
 * Created by Apink on 30/03/2016.
 */
public class GiaiPTBac2 extends GiaiPTBac1{

    protected double c;
    public GiaiPTBac2(){
        super();
        c = 0;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }

    public String solvePTB2(){
        if(a == 0)	super.solve();
        else{
            double delta = b*b - 4*a*c;
            if(delta < 0) s = "Phương trình vô nghiệm!";
            if(delta == 0) s = "Phương trình có 1 nghiệm: x = " + -b/2/a;
            else s = "Phương trình có 2 nghiệm: \n\tx1 = " +
                    (-b-Math.sqrt(delta))/2/a + "\n\tx2 = " +
                    (-b+Math.sqrt(delta))/2/a;
        }
        return s;
    }


}
