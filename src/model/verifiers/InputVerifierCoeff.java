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
 *This class checks inputs for the coefficients from the textbox for coeff
 * @author Shardul
 */
public class InputVerifierCoeff {

    /**
     * Holds the coefficient from the logarithmic equation
     */
    private double coeff1;
    /**
     * Holds the constant from the logarithmic equation
     */
    private double coeff2;

    /**
     * A regex to to test the coefficient of the equation. Can only
     * accept in a positive or negative integer.
     */
    private final Pattern logarithmicCoeff = Pattern.compile("([+-]?\\d+)");

    /**
     * To create an instance of this verifier, just input the coeff
     * as a String. This constructor uses regex to verify whether the
     * coeff is well formed 
     *
     * @param input user input
     * @throws InvalidCoeff The equation is not a logarithmic equation
     */
    public InputVerifierCoeff(String input) throws InvalidCoeff {

        Matcher logarithmicCoeffMatcher = logarithmicCoeff.matcher(input);
        if (!(logarithmicCoeffMatcher.matches())) {
            throw new InvalidCoeff("Invalid Expression");
        }
        
        coeff1 = Double.parseDouble(logarithmicCoeffMatcher.group(1));
        
        if (coeff1 == 0) {
            throw new InvalidCoeff("Invalid Expression");
        }
        
        

    }

    /**
     * Getter for the coefficient of a logarithmic equation
     *
     * @return the coefficient
     */
    public double getCoeff1() {
        return coeff1;
    }
    
    
    
}
