/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *An NonLinearEquationException throws exceptions every time the user makes some error when inputting a linear equation.
 * @author Shardul
 */
public class InvalidConst extends Exception {
    
    /**
     * Instantiation with an empty constructor
     */
    public InvalidConst() {

    }
    /**
     * An NonLinearEquationException can be instantiated by inputting a String as a message for the error.
     * @param message The equation is not an lienar equation
     */
    public InvalidConst(String message) {

        super(message);

    }

}
