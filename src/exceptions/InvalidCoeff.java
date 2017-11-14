/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *A NonLogarithmicEquationException throws exceptions every time the user makes some error when inputting a logarithmic equation.
 * @author Shardul
 */
public class InvalidCoeff extends Exception {
    
    /**
     * Instantiation with an empty constructor
     */
    public InvalidCoeff() {

    }
    /**
     * An NonLogarithmicEquationException can be instantiated by inputting a String as a message for the error.
     * @param message The equation is not a logarithmic equation
     */
    public InvalidCoeff(String message) {

        super(message);

    }

}
