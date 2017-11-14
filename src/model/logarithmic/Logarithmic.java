/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logarithmic;

import model.verifiers.InputVerifierCoeff;
import exceptions.InvalidCoeff;
import exceptions.InvalidConst;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;
import userInterface.PaintWindow;

/**
 * A Logarithmic class performs operations on the equation that has been
 * verified as a logarithmic equation.
 * The various computations include finding an
 * approximation of a solution and computing values for x and y.
 * 
 * 
 * @author Shardul
 */
public class Logarithmic {

    /**
     * stores the to and from values from the interval
     */
    private int from, to;
    /**
     * stores the coefficient of the equation
     */
    private int coeff1;
    /**
     * stores the constant of the equation
     */
    private int coeff2;
    /**
     * stores the value of x from the interval
     */

    private List<Double> xValueLog = new ArrayList<>();
    /**
     * stores the value of y from the computation of the equation (based on the
     * interval)
     */

    private List<Double> yValueLog = new ArrayList<>();
    /**
     * stores a copy of yValue to find the value of y closest to zero
     */

    private List<Double> y2Value = new ArrayList<>();
    /**
     * stores user input
     */
    private static String input;
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
     *
     * To create an instance of Logarithmic, just input a logarithmic equation
     * as a string
     *
     * @param pw user input
     */
    public Logarithmic(PaintWindow pw){
        
        this.pw = pw;
        this.from = 1;
        this.to = this.pw.getxCoordNumbers();
        this.coeff1 = this.pw.getUi().getCoeff1();
        this.coeff2 = this.pw.getUi().getCoeff2();
        this.solveLogarithmicEqValues();
//        System.out.println(xValue);
//        System.out.println(yValue);
        
    }

    /**
     * Computes the equation from the values of x based on the interval. Also
     * finds the value of y that is closest to zero
     */
    private void solveLogarithmicEqValues() {
        for (double i = 0.00001; i < to; i+= 0.001) {
            xValueLog.add(i);
            yValueLog.add((coeff1 * (log(i) / log(2))) + coeff2);
        }
    }
    
    /**
     * To get the value of x from the list
     *
     * @return value of x
     */
    public List<Double> getxValueLog() {
        return xValueLog;   
    }

    /**
     * To get the value of y from the list
     *
     * @return value of y
     */
    public List<Double> getyValueLog() {
        return yValueLog;
    }
    
    /**
     * Solves logarithmic values for a given x
     * @param mouseX
     * @return the solved value of x as double 
     */
    public double solveThis(double mouseX){
        this.x = mouseX;
        return (coeff1 * (log(x) / log(2))) + coeff2;
    }

}

