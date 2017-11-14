/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import exceptions.InvalidCoeff;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import listeners.ButtonListenerDec;
import listeners.ButtonListenerInc;
import listeners.EquationChooser;
import listeners.ExitListener;
import listeners.SaveListener;
import listeners.TextListenerCoeff;
import listeners.TextListenerConst;
import listeners.TextListenerZoom;
import model.verifiers.InputVerifierCoeff;

/**
 *A UserInterface is a class that implements the GUI interface to plot equations. 
 * This class also contains the main for this project.
 * This class uses verifiers for different types of inputs. 
 * @see model.verifiers
 * @author Shardul
 * @version 1.8, October 2017
 */
public class UserInterface extends javax.swing.JFrame {
    
    /**
     * Holds a TextListener to get the value of the coefficient
     */
    private TextListenerCoeff textListener1;
    /**
     * Holds a TextListener to get the value of the constant
     */
    private TextListenerConst textListener2;
    /**
     * Holds a TextListener to get the value of the zoom
     */
    private TextListenerZoom textListener3;
    /**
     * Holds a ButtonListener to get the value of the increased zoom value 
     */
    private ButtonListenerInc buttonListener1;
    /**
     * Holds a ButtonListener to get the value of the decreased zoom value 
     */
    private ButtonListenerDec buttonListener2;
    /**
     * Holds a MenuListener to get the value of the exit menu 
     */
    private ExitListener exitListener;
    /**
     * Holds a MenuListener to get the value of the save menu 
     */
    private SaveListener saveListener;
    /**
     * Holds a ComboBoxListener to get the value of the equation
     */
    private EquationChooser equationListener;
     /**
     * Holds the value of zoom scale
     */
    private double scale = 100.;
     /**
     * Holds the value of the coefficient
     */
    private int coeff1 = 1;
    /**
     * Holds the value of the constant
     */
    private int coeff2 = 0;
    /**
     * Holds the value of the equationSelected
     */
    private String equationSelected = "x +";
    //private int mouseCoordY = 0;

    /**
     * Creates new form UserInterface 
     */
    public UserInterface() {
        initComponents();
        this.textListener1 = new TextListenerCoeff(this);
        this.textListener2 = new TextListenerConst(this);
        this.textListener3 = new TextListenerZoom(this);
        this.buttonListener1 = new ButtonListenerInc(this);
        this.buttonListener2 = new ButtonListenerDec(this);
        this.exitListener = new ExitListener(this);
        this.saveListener = new SaveListener(this);
        this.equationListener = new EquationChooser(this);
        //this.paintWindow = new PaintWindow(this);
        equationInput1.addFocusListener(textListener1);
        equationInput2.addFocusListener(textListener2);
        zoom.addFocusListener(textListener3);
        zoomIn.addActionListener(buttonListener1);
        zoomOut.addActionListener(buttonListener2);
        exit.addActionListener(exitListener);
        save.addActionListener(saveListener);
        equationType.addActionListener(equationListener);
//        mouseX.setText(String.valueOf(this.paintWindow1.getMousePosition()));
       // mouseX.addActionListener(mousePointerX);
    }

     /**
     * Returns a textField for Zoom
     *
     * @return JTextField for the zoom text
     */
    public JTextField getZoom() {
        return zoom;
    }

    /**
     * Returns a textListener for coefficients
     *
     * @return TextListenerCoeff for the coeff
     */
    public TextListenerCoeff getTextListener1() {
        return textListener1;
    }

    /**
     * Returns a textListener for coefficients
     *
     * @return TextListenerCoeff for the coeff
     */
    public TextListenerConst getTextListener2() {
        return textListener2;
    }
    
    /**
     * A setter for setting the zoom scale 
     * @param scale 
     */
    public void setScale(double scale) {
        this.scale = scale;
        
    }
    
    
    /**
     * Returns a PaintWindow where the graphics is painted
     *
     * @return PaintWindow
     */
    public PaintWindow getPaintWindow1() {
        return paintWindow1;
    }
    
    
    /**
     * Returns a the coefficient
     *
     * @return coefficient 
     */
    public int getCoeff1() {
        return coeff1;
    }
    
    /**
     * A setter for the coefficient.
     * @param coeff1 
     */
    public void setCoeff1(int coeff1) {
        this.coeff1 = coeff1;
    }

    public int getCoeff2() {
        return coeff2;
    }

    
    /**
     * A setter for the constant 
     * @param coeff2
     */
    public void setCoeff2(int coeff2) {
        this.coeff2 = coeff2;
    }
    /**
     * Returns the scale in doubles 
     * @return double getScale
     */
    public double getScale() {
        //System.out.println("UI scale received " + this.scale/100);
        return this.scale;
    }
    
    /**
     * Returns the type of equation
     * @return String Eq type 
     */
    public String getEquationType() {
        return equationSelected;
    }

    /**
     * Sets the equation type 
     * @param equationType 
     */    
    public void setEquationType(String equationType) {
        this.equationSelected = equationType;
    }

//
    
//    }
//
//    public int getMouseCoordY() {
//        return mouseCoordY;
//    }
//
//    public void setMouseCoordY(int mouseY) {
//        this.mouseCoordY = mouseY;
//    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        toolPanel = new javax.swing.JPanel();
        equationLabel = new javax.swing.JLabel();
        equationInput1 = new javax.swing.JTextField();
        equationType = new javax.swing.JComboBox<>();
        equationInput2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        zoomIn = new javax.swing.JButton();
        zoom = new javax.swing.JTextField();
        zoomOut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        paintWindow1 = new userInterface.PaintWindow(this);
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        save = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setPreferredSize(new java.awt.Dimension(600, 800));
        setSize(new java.awt.Dimension(450, 500));

        equationLabel.setText("Equation: ");

        equationInput1.setText("1");
        equationInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equationInput1ActionPerformed(evt);
            }
        });

        equationType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "x +", "log2(x) +" }));
        equationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equationTypeActionPerformed(evt);
            }
        });

        equationInput2.setText("0");
        equationInput2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equationInput2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Zoom:");

        zoomIn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        zoomIn.setText("+");

        zoom.setText("100%");
        zoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomActionPerformed(evt);
            }
        });

        zoomOut.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        zoomOut.setText("-");

        javax.swing.GroupLayout toolPanelLayout = new javax.swing.GroupLayout(toolPanel);
        toolPanel.setLayout(toolPanelLayout);
        toolPanelLayout.setHorizontalGroup(
            toolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(equationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(equationInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(equationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(equationInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(zoomIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zoom, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zoomOut)
                .addGap(12, 12, 12))
        );
        toolPanelLayout.setVerticalGroup(
            toolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(toolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equationLabel)
                    .addComponent(equationInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(equationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(equationInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(toolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zoomIn)
                    .addComponent(zoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zoomOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paintWindow1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paintWindow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paintWindow1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        file.setText("File");
        file.setToolTipText("");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        file.add(save);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        file.add(exit);

        jMenuBar1.add(file);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        
    }//GEN-LAST:event_exitActionPerformed

    private void equationInput2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equationInput2ActionPerformed

    }//GEN-LAST:event_equationInput2ActionPerformed

    private void equationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equationTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equationTypeActionPerformed

    private void equationInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equationInput1ActionPerformed

    }//GEN-LAST:event_equationInput1ActionPerformed

    private void zoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zoomActionPerformed

    /**
     * The main of the userInterface 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField equationInput1;
    private javax.swing.JTextField equationInput2;
    private javax.swing.JLabel equationLabel;
    private javax.swing.JComboBox<String> equationType;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu file;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private userInterface.PaintWindow paintWindow1;
    private javax.swing.JMenuItem save;
    private javax.swing.JPanel toolPanel;
    private javax.swing.JTextField zoom;
    private javax.swing.JButton zoomIn;
    private javax.swing.JButton zoomOut;
    // End of variables declaration//GEN-END:variables
}

