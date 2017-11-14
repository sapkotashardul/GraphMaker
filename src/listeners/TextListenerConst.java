/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import exceptions.InvalidCoeff;
import exceptions.InvalidConst;
import userInterface.PaintWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import model.verifiers.InputVerifierCoeff;
import model.verifiers.InputVerifierConst;
import userInterface.UserInterface;

/**
 * This class implements a textListener to get the value from the textField
 * @author Shardul
 */
public class TextListenerConst implements FocusListener {

    private UserInterface myWindow;
    private String coeff1;
    private int equationCoeff;
    
    /**
     * Constructor that takes UI as input 
     * @param mw 
     */
    public TextListenerConst(UserInterface mw) {
        this.myWindow = mw;
    }
    /**
     * ActionPerformed method for the textField when enter is pressed
     * @param e 
     */
    //@Override
    public void actionPerformed(ActionEvent e) {
        /*
		JTextField source = (JTextField) e.getSource();
        String coeff = source.getText();
        System.out.println(coeff);
        try {
            InputVerifier iv = new InputVerifier(coeff);
        } catch (InvalidCoeff ex) {
            
        }
         */

    }
    
    /**
     * FocusGained method that does not do anything when focus is gained 
     * @param e 
     */
    @Override
    public void focusGained(FocusEvent e) {

    }
    
    /**
     * FocusLost method that gets the text and parses it 
     * @param e 
     */
    @Override
    public void focusLost(FocusEvent e) {

        JTextField source = (JTextField) e.getSource();
        try {
            coeff1 = source.getText();
            InputVerifierConst iv = new InputVerifierConst(coeff1);
            this.equationCoeff = (int) iv.getCoeff1();
        } catch (InvalidConst ex) {
            coeff1 = "1";
            source.setText("1");
            this.equationCoeff = 1;
        }
        this.myWindow.setCoeff2(equationCoeff);
        this.myWindow.getPaintWindow1().repaint();

    }
    
    /**
     * Returns the parsed const as string 
     * @return coeff 
     */
    public String getCoeff1() {
        return coeff1;
    }

    
    
}
