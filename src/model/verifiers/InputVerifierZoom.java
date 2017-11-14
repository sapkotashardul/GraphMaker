/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.verifiers;

import exceptions.InvalidCoeff;
import exceptions.InvalidZoom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class checks inputs for the zoom textField
 * @author Shardul
 */
public class InputVerifierZoom {

    /**
     * Holds the coefficient from the zoom field
     */
    private double coeff1;
    
    /**
     * A regex to to test the coefficient of the zoom field. Can only
     * accept in specified intervals with or without '%' sign.
     */
    private final Pattern logarithmicCoeff = Pattern.compile("(\\d+)%?");

    /**
     * To create an instance of this class, just input a 
     * scale as a String. This constructor uses regex to verify whether the
     * the value is well formed
     *
     * @param input user input
     * @throws InvalidZoom The value is not well formed 
     */
    public InputVerifierZoom(String input) throws InvalidZoom {

        Matcher logarithmicCoeffMatcher = logarithmicCoeff.matcher(input);
        if (!(logarithmicCoeffMatcher.matches())) {
            throw new InvalidZoom("Invalid Expression");
        }
        
        coeff1 = Double.parseDouble(logarithmicCoeffMatcher.group(1));
        
        if (coeff1 < 25) {
            coeff1 = 25;
        }
        
        if (coeff1 > 200) {
            coeff1 = 200;
        }
        
        if ((coeff1>25) && (coeff1<50)){
            coeff1 = 25;
        }
        
        if ((coeff1>50) && (coeff1<75)){
            coeff1 = 50;
        }
        
        if ((coeff1>75) && (coeff1<100)){
            coeff1 = 75;
        }
        
        if ((coeff1>100) && (coeff1<125)){
            coeff1 = 100;
        }
        
        if ((coeff1>125) && (coeff1<150)){
            coeff1 = 125;
        }
        
        if ((coeff1>150) && (coeff1<175)){
            coeff1 = 150;
        }
        
        if ((coeff1>175) && (coeff1<200)){
            coeff1 = 175;
        }
        
    }

    /**
     * Getter for the coefficient of a logarithmic equation
     *
     * @return the coefficient
     */
    public int getCoeff1() {
        return (int) coeff1;
    }


    
}
