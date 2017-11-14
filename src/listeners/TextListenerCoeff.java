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
import userInterface.UserInterface;

/**
 * This class implements a textListener to get the value from the textField
 * @author Shardul
 */
public class TextListenerCoeff implements FocusListener {
    
    private UserInterface myWindow;
    private String coeff;
    private int equationCoeff;
    
    /**
     * Constructor that takes UI as input 
     * @param mw 
     */
    public TextListenerCoeff (UserInterface mw)
	{
		this.myWindow = mw;
	}
    
    /**
     * ActionPerformed method for the textField when enter is pressed
     * @param e 
     */
	//@Override
	public void actionPerformed(ActionEvent e)
	{
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
            coeff = source.getText(); 
            InputVerifierCoeff iv = new InputVerifierCoeff(coeff);
            this.equationCoeff = (int) iv.getCoeff1();
        } catch (InvalidCoeff ex) {
            coeff = "1";
            source.setText("1");
            this.equationCoeff = 1;
        } 
        this.myWindow.setCoeff1(equationCoeff);
        this.myWindow.getPaintWindow1().repaint();
    }
    
    /**
     * Returns the parsed coeff as string 
     * @return coeff 
     */
    public String getCoeff() {
        return coeff;
    }
    
    
            
    
}


