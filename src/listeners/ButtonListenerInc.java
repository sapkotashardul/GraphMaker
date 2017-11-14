package listeners;

import exceptions.InvalidZoom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.verifiers.InputVerifierZoom;

import userInterface.PaintWindow;
import userInterface.UserInterface;

/**
 * This class implements a button listener when the zoom value is increased 
 * @author Shardul
 */
public class ButtonListenerInc implements ActionListener {

	 /**
     * UI holder 
     */
	private UserInterface myZoom;
    /**
     * zoomValue holder
     */
    private String zoomValString;
    /**
     * gets the string value of the zoom in text
     */
    private String zoomValGetStringVal;
    /**
     * removes the '%' sign from the textField
     */
    private String zoomValParsed;
    /**
     * Holds the int value of the zoom field 
    */
    private int zoomValInt;
    /**
     * Holds the coeff1
     */
    private int coeff1; 
   
	/**
     * A constructor that takes UI as input 
     * @param zm 
     */
    public ButtonListenerInc (UserInterface zm)
	{
		this.myZoom = zm;
	}

	/**
     * ActionPerformed method that sets the textField and updates the zoom
     * @param e 
     */
    @Override
	public void actionPerformed(ActionEvent e)
	{
		zoomValGetStringVal = this.myZoom.getZoom().getText();
        zoomValParsed = zoomValGetStringVal.substring(0, zoomValGetStringVal.indexOf("%"));
        zoomValInt = Integer.parseInt(zoomValParsed) + 25;
        zoomValString = String.valueOf(zoomValInt);
        
        
        try {
            InputVerifierZoom iv = new InputVerifierZoom(zoomValString);
            coeff1 = iv.getCoeff1();
            this.myZoom.getZoom().setText(String.valueOf(iv.getCoeff1()) + "%");
            
        } catch (InvalidZoom ex) {
            this.myZoom.getZoom().setText("100%");
            coeff1 = 100;
        }
        
        this.myZoom.setScale(coeff1);
        this.myZoom.getPaintWindow1().repaint();
	}

}