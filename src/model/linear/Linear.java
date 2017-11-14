/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.linear;

import java.util.ArrayList;
import java.util.List;
import userInterface.PaintWindow;

/**
 *
 * @author Shardul
 */
public class Linear {
    
    /**
     * stores the coefficient of the equation
     */
    private int coeff1;
    /**
     * stores the const of the equation
     */
    private int coeff2;
    /**
     * stores the to and from values from the interval
     */
    private int from;
    /**
     * stores the to and from values from the interval
     */
    private int to;
    /**
     * stores the PaintWindow
     */
    private PaintWindow pw;
    /**
     * stores the value of x
     */
    private double x;
    /**
     * stores the value of y
     */
    private double y;
    /**
     * stores the value of x from the interval
     */

    private List<Integer> xValue = new ArrayList<>();
    /**
     * stores the value of y from the computation of the equation (based on the
     * interval)
     */

    private List<Integer> yValue = new ArrayList<>();
    
    /**
     * A constructor when instantiated performs linear operations
     * @param pw 
     */
    public Linear(PaintWindow pw){
        this.pw = pw;
        this.from = -this.pw.getxCoordNumbers();
        this.to = this.pw.getxCoordNumbers();
        this.coeff1 = this.pw.getUi().getCoeff1();
        this.coeff2 = this.pw.getUi().getCoeff2();
        this.solveLinearEqValues();
    }
    
    
    /**
     * Computes the equation from the values of x based on the interval.
     */
    private void solveLinearEqValues() {
        for (int i = from; i <= to; i ++) {
            int counter = 0;
            xValue.add(i);
            yValue.add((coeff1 * i) + coeff2);
        }
        
    }
    /**
     * Solves linear for a given x
     * @param mouseX
     * @return double 
     */
    public double solveThis(double mouseX){
        this.x = mouseX;
        return (coeff1 * x) + coeff2;
    }
    /**
     * Returns xval
     * @return x
     */
    public List<Integer> getxValue() {
        return xValue;
    }
    /**
     * Returns yVal
     * @return y
     */
    public List<Integer> getyValue() {
        return yValue;
    }
    
    
}
