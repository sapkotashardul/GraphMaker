package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import userInterface.PaintWindow;
import userInterface.UserInterface;

/**
 * This class implements a mouseListener for various actions performed
 * @author Shardul
 */
public class MouseListenerPanel implements MouseListener, MouseMotionListener {
    
    /**
     * Holds PaintW
     */
	private PaintWindow myWindow;
    /**
     * Holds UI 
     */
	private UserInterface uIWindow;
    
    /**
     * Holds x and y values 
     */
    private int valX, valY;
    
    /**
     * Constructor that take PW as input 
     * @param pw 
     */
	public MouseListenerPanel (PaintWindow pw)
	{
		this.myWindow = pw;
	}

    /**
     * ActionPerformed method when mouse is dragged to pan
     * @param e 
     */
	@Override
	public void mouseDragged(MouseEvent e) {
		this.myWindow.addPoint(e.getX(), e.getY());
	    int deltaX = e.getX() - valX;
	    int deltaY = e.getY() - valY;

	    // make the reference point be the new mouse point. 
	    valX = e.getX();
	    valY = e.getY();
	    
	   	myWindow.setTranslateX(deltaX);
	    myWindow.setTranslateY(deltaY);
 
	    // schedule a repaint.
        myWindow.repaint();
	}

    /**
     * ActionPerformed method when mouse is moved
     * @param e 
     */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
			//System.out.println("Mouse moved to x=" + e.getX() + ", y=" + e.getY());	
            
                myWindow.setMouseX(e.getX());
                //uIWindow.setMouseCoordX(e.getX());
//                uIWindow.getMouseX().setText("a");
                //uIWindow.getMouseX().setText(String.valueOf(e.getX()));
                myWindow.repaint();
                
           
                
            
            //uIWindow.setMouseCoordY(e.getY());
//            myWindow.setMouseX(e.getX());
//            myWindow.setMouseY(e.getY());
            
	}

    
    /**
     * ActionPerformed method when mouse is clicked
     * @param e 
     */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
				System.out.println("Mouse clicked: x=" + e.getX() + ", y=" + e.getY());
	}
    
    
    /**
     * ActionPerformed method when mouse is pressed
     * @param e 
     */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		valX = e.getX(); 
        valY = e.getY();
	}
    
    
    /**
     * ActionPerformed method when mouse is released
     * @param e 
     */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    
    /**
     * ActionPerformed method when mouse enters a field
     * @param e 
     */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    /**
     * ActionPerformed method when mouse is existed form a field
     * @param e 
     */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
