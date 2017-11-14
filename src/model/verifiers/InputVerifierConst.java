/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.verifiers;

import exceptions.InvalidCoeff;
import exceptions.InvalidConst;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class checks inputs for the coefficients from the textbox for const
 * @author Shardul
 */
public class InputVerifierConst {

    /**
     * Holds the constant from the logarithmic equation
     */
    private double coeff1;

    /**
     * A regex to to test the coefficient of the logarithmic equation. Can only
     * accept in a positive or negative integer.
     */
    private final Pattern logarithmicCoeff = Pattern.compile("([+-]?\\d+)");

    /**
     * To create an instance of this class, just input a 
     * constant as a String. This constructor uses regex to verify whether the
     * const is well formed
     *
     * @param input user input
     * @throws InvalidConst The const is not well formed 
     */
    public InputVerifierConst(String input) throws InvalidConst {

        Matcher logarithmicCoeffMatcher = logarithmicCoeff.matcher(input);
        if (!(logarithmicCoeffMatcher.matches())) {
            throw new InvalidConst("Invalid Expression");
        }
        
        coeff1 = Double.parseDouble(logarithmicCoeffMatcher.group(1));
        

    }

    /**
     * Getter for the const of an equation
     *
     * @return the coefficient
     */
    public double getCoeff1() {
        return coeff1;
    }

    
}
