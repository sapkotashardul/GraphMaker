/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;


import exceptions.InvalidCoeff;
import exceptions.InvalidConst;
import exceptions.InvalidZoom;
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
import model.verifiers.InputVerifierZoom;
import userInterface.UserInterface;

/**
 * This class implements a textListener to get the value from the zoomField
 * @see listeners.ButtonListenerDec
 * @see listeners.ButtonListenerInc
 * @author Shardul
 */
public class TextListenerZoom implements FocusListener {

    private UserInterface myWindow;

    private String coeff1;
    private int coeff;
    
    
    /**
     * Constructor that takes UI as input 
     * @param mw 
     */
    public TextListenerZoom(UserInterface mw) {
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
            InputVerifierZoom iv = new InputVerifierZoom(coeff1);
            this.coeff1 = String.valueOf(iv.getCoeff1());
            this.coeff = iv.getCoeff1();
            source.setText(coeff1 + "%");

        } catch (InvalidZoom ex) {
            source.setText("100%");
            this.coeff1 = "100";
            this.coeff = 100;
        }
        this.myWindow.setScale(coeff);
        
        //schedule repaint
        this.myWindow.getPaintWindow1().repaint();
    }

    /**
     * Returns the zoom coeff
     * @return the zoom coeff
     */
    public String getCoeff1() {
        return coeff1;
    }
    
    /**
     * Sets the coeff from button listeners
     * @param coeff1 
     */
    public void setCoeff1(String coeff1) {
        this.coeff1 = coeff1;
    }

}
