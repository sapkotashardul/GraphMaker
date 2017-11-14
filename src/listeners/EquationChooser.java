/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import userInterface.UserInterface;

/**
 * This class implements a comboBoxListener to get the value from the comboBox
 * @author Shardul
 */
public class EquationChooser implements ActionListener {
    /**
     * UI holder 
     */
   private UserInterface myWindow;
   /**
    * Stores the choice
    */
   private String choice;
   
   /**
    * A constructor that take UI as input 
    * @param zm 
    */
    public EquationChooser(UserInterface zm) {
        this.myWindow = zm;
    }

    /**
     * ActionPerformed method that gets the chosen equation
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox source = (JComboBox) e.getSource();
        this.choice = (String) source.getSelectedItem();
        this.myWindow.setEquationType(choice);
        if ((choice.equals("x +"))||(choice.equals("log2(x) +"))) this.myWindow.getPaintWindow1().repaint();
    }
    
    
}
