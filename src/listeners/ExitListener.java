/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userInterface.UserInterface;

/**
 * This class implements an exitListener to exit from the menu bar
 * @author Shardul
 */
public class ExitListener implements ActionListener {
    
    /**
     * holds the UI
     */
    private UserInterface myWindow;
    
    /**
     * A constructor that takes UI as input 
     * @param zm 
     */
	public ExitListener (UserInterface zm)
	{
		this.myWindow = zm;
	}
    
    /**
     * ActionPerformed method that closes the file
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
