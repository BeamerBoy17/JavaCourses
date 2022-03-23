/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

public class RecIntegral{
    public static final double MAX = 1000000;
    public static final double MIN = 0.000001;

    public double upperEdge;
    public double lowerEdge;
    public double step;
    
    RecIntegral(double upperEdge,double lowerEdge,double step) throws RecIntegralException {
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

        this.upperEdge = upperEdge;
        this.lowerEdge = lowerEdge;
        this.step = step;
    }
}

