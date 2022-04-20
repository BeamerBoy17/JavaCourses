/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.company;

import java.io.Serializable;

public class RecIntegral implements Serializable {
    public static final double MAX = 1000000;
    public static final double MIN = 0.000001;

    public double lowerEdge;
    public double upperEdge;
    public double step;
    
    RecIntegral(double lowerEdge,double upperEdge,double step) throws RecIntegralException {
        if (
                Double.compare(lowerEdge,MIN) < 0 ||
                Double.compare(upperEdge,MIN) < 0 ||
                Double.compare(step,MIN) < 0)
            throw new RecIntegralExceptionLowerBound();

        if (
                Double.compare(lowerEdge,MAX) > 0 ||
                Double.compare(upperEdge,MAX) > 0 ||
                Double.compare(step,MAX) > 0)
            throw new RecIntegralExceptionUpperBound();

        if (Double.compare(lowerEdge,upperEdge) > 0)
            throw new RecIntegralExceptionRange();

        this.lowerEdge = lowerEdge;
        this.upperEdge = upperEdge;
        this.step = step;
    }

    @Override
    public String toString(){
        return new String(""+lowerEdge+" "+upperEdge+" "+step+" \n");
    }
    public static RecIntegral fromString(String string) throws NumberFormatException,RecIntegralException{
        String subString = new String();
        double[] data = new double[3];

        try{
            int from = 0;
            int to = string.indexOf(" ");
            data[0] = Double.parseDouble(string.substring(from,to));

            from = to+1;
            to = string.indexOf(" ",from);
            data[1] = Double.parseDouble(string.substring(from,to));

            from = to+1;
            to = string.indexOf(" ",from);
            data[2] = Double.parseDouble(string.substring(from,to));
        }catch (NumberFormatException e){
            throw e;
        }
        try {
            return new RecIntegral(data[0],data[1],data[2]);
        }catch (RecIntegralException e){
            throw e;
        }
    }
}

