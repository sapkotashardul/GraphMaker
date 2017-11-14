/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import userInterface.UserInterface;

/**
 * This class implements a saveListener to get the value from the comboBox
 * @author Shardul
 */
public class SaveListener implements ActionListener {
    
    /**
     * Holds UI
     */
    private UserInterface myWindow;
    
    /**
     * Constructor that takes UI as input 
     * @param zm 
     */
    public SaveListener(UserInterface zm) {
        this.myWindow = zm;
    }
    
    /**
     * ActionPerformed method that saves the file as Jpeg 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser pickFile = new JFileChooser();
        //pickFile.addChoosableFileFilter(new jpgSaveFilter());
        //pickFile.addChoosableFileFilter(new jpegSaveFilter());
        //pickFile.addChoosableFileFilter(new PngSaveFilter());
        pickFile.setFileFilter(new FileNameExtensionFilter("JPG(*.jpg)", ".jpg"));
        int correct = pickFile.showSaveDialog(this.myWindow);

        
        if (correct == JFileChooser.APPROVE_OPTION) {
            BufferedImage img = this.myWindow.getPaintWindow1().getImg();
            try {
                File f = new File(pickFile.getSelectedFile() + ((FileNameExtensionFilter) pickFile.getFileFilter()).getExtensions()[0]);
                ImageIO.write(img, "JPG", f);
            } catch (IOException ex) {

            }
        }
    }

}
