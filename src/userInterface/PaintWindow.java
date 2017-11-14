package userInterface;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import listeners.MouseListenerPanel;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.event.FocusListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import static jdk.nashorn.internal.objects.NativeMath.round;
import listeners.TextListenerZoom;
import model.linear.Linear;
import model.logarithmic.Logarithmic;

/**
 * PaintWindow is a class that paints the graphics using the paintComponent
 *
 * @author Shardul
 */
public class PaintWindow extends JPanel {

    /**
     * Holds the value of the translated value by dragging
     */
    private int translateX;
    /**
     * Holds the value of the translated value by dragging
     */
    private int translateY;
    /**
     * Holds the value of the scale
     */
    private double scale;
    /**
     * Holds the UserInteface
     */
    private UserInterface ui;
    /**
     * Holds the value of the length for the ticks
     */
    private static final int SECOND_LENGHT = 5;
    /**
     * Holds the value of the distance of the strings in axes
     */
    private static final int AXIS_STRING_DISTANCE = 20;

    /**
     * Holds the value of the mouseListener
     */
    private MouseListenerPanel motionListener;

    /**
     * Holds the textListener for Zoom
     */
    private TextListenerZoom textListener;

    /**
     * Holds the value of the PointList
     */
    private List<Point> ptsList = new ArrayList<Point>();

    /**
     * Holds the value of the xList
     */
    private List<Integer> intXList = new ArrayList<>();

    /**
     * Holds the value of the yList
     */
    private List<Integer> intYList = new ArrayList<>();

    /**
     * Holds the image
     */
    private BufferedImage img;
    private BufferedImage imgXY;

    /**
     * Holds the xCoord Values
     */
    private int xCoordNumbers;

    /**
     * Holds the yCoord Values
     */
    private int yCoordNumbers;
    /**
     * Holds the xCoord Values
     */
    private double xCoordNumbersN;

    /**
     * Holds the yCoord Values
     */
    private double yCoordNumbersN;

    /**
     * Holds the xLength Val
     */
    private double xLength;

    /**
     * Holds the yLength Val
     */
    private double yLength;

    /**
     * Holds the value of the pixels of mouseX
     */
    private int mouseX;

    /**
     * Holds the value of the pixels of mouseY
     */
    private int mouseY;

    /**
     * An empty Constructor for paintWindow
     */
    private int panelHeight;
    private int panelWidth;

    public PaintWindow() {

    }

    /**
     * A paintWindow constructor that takes in userInferface as its parameter
     *
     * @param mw
     */
    public PaintWindow(UserInterface mw) {
        this.ui = mw;
        translateX = 0;
        translateY = 0;
        this.motionListener = new MouseListenerPanel(this);
        this.setLayout(new BorderLayout());
        //System.out.println("This is from PW " + ptsList);
        this.addMouseListener(this.motionListener);
        this.addMouseMotionListener(this.motionListener);

    }

    /**
     * PaintComponent is a method that paints the graphics
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        panelHeight = getHeight() + translateY;
        panelWidth = getWidth() + translateX;

        Graphics2D g2 = (Graphics2D) img.createGraphics();
        Graphics2D g3 = (Graphics2D) img.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.red);
        g2.translate(panelWidth / 2, panelHeight / 2);
        //g2.scale(this.ui.getScale() / 100, this.ui.getScale() / 100);
        g2.translate((-getWidth() + translateX) / 2, (-getHeight() + translateY) / 2);

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // x-axis
        g2.drawLine(0 - translateX, (getHeight()) / 2, getWidth() - translateX, (getHeight()) / 2);
        // y-axis

        g2.drawLine(getWidth() / 2, 0 - translateY, getWidth() / 2, getHeight() - translateY);

        // numerate axis
        xLength = (((getWidth() - 5)*this.ui.getScale()/100)/ 9);
//      / xCoordNumbers;
        yLength = (((getHeight() - 5)*this.ui.getScale()/100)
                / 8);
//        // numerate axis
//        xLength = (getWidth() - 5)/ 9;
////      / xCoordNumbers;
//        yLength = (getHeight() - 5)
//                / 8;

//        xCoordNumbers = 9 - this.pixToCoordInt(translateX);
//        yCoordNumbers = 9 - this.pixToCoordInt(translateY);
        if (this.pixToCoordInt(translateX) > 0) {
            xCoordNumbers = 50 + this.pixToCoordInt(translateX);
        } else {
            xCoordNumbers = 50 - this.pixToCoordInt(translateX);
        }
        if (this.pixToCoordInt(translateY) > 0) {
            yCoordNumbers = 50 + this.pixToCoordInt(translateY);
        } else {
           yCoordNumbers = 50 - this.pixToCoordInt(translateY);
        }

//        xCoordNumbersN = 9 + this.pixToCoordInt(translateX);
//        yCoordNumbersN = 9 + this.pixToCoordInt(translateY);
//        xCoordNumbers = 9 + translateX;
//        yCoordNumbers = 9 + translateY;
//
//        if (xCoordNumbers == 0) {
//            xCoordNumbers = 1;
//        }
//
//        if (yCoordNumbers == 0) {
//            yCoordNumbers = 1;
//        }
        Logarithmic logarithmic = new Logarithmic(this);
        Linear linear = new Linear(this);

        g3.setColor(Color.red);
        g3.drawString("x = ", (float) (getWidth() / 2 + 3.35 * (int) getWidth() / 9), (float) ((getHeight() / 2) - (4.20 * (int) getHeight() / 9)));
        DecimalFormat d = new DecimalFormat("#.##");
        g3.drawString(String.valueOf(Double.valueOf(d.format(this.pixToCoord((mouseX-translateX))*this.ui.getScale()/100))), (float) (getWidth() / 2 + 3.55 * (int) getWidth() / 9), (float) ((getHeight() / 2) - (4.2 * (int) getHeight() / 9)));
//        g3.drawString(String.valueOf(this.pixToCoord((mouseX-translateX))*this.ui.getScale()/100), (float) (getWidth() / 2 + 3.55 * (int) getWidth() / 9), (float) ((getHeight() / 2) - (4.2 * (int) getHeight() / 9)));

        if (this.ui.getEquationType().equals("x +")) {
            double valX = linear.solveThis(this.pixToCoord(mouseX-translateX)*this.ui.getScale()/100);
            DecimalFormat df = new DecimalFormat("#.##");
            g3.drawString("y = ", (float) (getWidth() / 2 + 3.35 * (int) getWidth() / 9), (float) ((getHeight() / 2) - (3.95 * (int) getHeight() / 9)));
            g3.drawString(String.valueOf(Double.valueOf(df.format(valX))), (float) (getWidth() / 2 + 3.55 * (int) getWidth() / 9), (float) ((getHeight() / 2) - (3.95 * (int) getHeight() / 9)));
        }

        if (this.ui.getEquationType().equals("log2(x) +")) {
            double valX = logarithmic.solveThis(this.pixToCoord(mouseX-translateX)*this.ui.getScale()/100);
            DecimalFormat df = new DecimalFormat("#.##");
            g3.drawString("y = ", (float) (getWidth() / 2 + 3.35 * (int) getWidth() / 9), (float) ((getHeight() / 2) - (3.95 * (int) getHeight() / 9)));
            try {
                g3.drawString(String.valueOf(Double.valueOf(df.format(valX))), (float) (getWidth() / 2 + 3.55 * (int) getWidth() / 9), (float) ((getHeight() / 2) - (3.95 * (int) getHeight() / 9)));
            } catch (NumberFormatException ex) {
                g3.drawString("NaN", (float) (getWidth() / 2 + 3.55 * (int) getWidth() / 9), (float) ((getHeight() / 2) - (3.95 * (int) getHeight() / 9)));
            }
        }

//      / yCoordNumbers;
//
//        if (Double.compare(this.ui.getScale() / 100, 1) == 0){
//            xCoordNumbersN = xCoordNumbers;
//        } 
//
//        if (Double.compare(this.ui.getScale() / 100, .75) == 0){
//            xCoordNumbersN = xCoordNumbers/2.;
//        } 
//  
        // draw x-axis for positive numbers
        for (double i = -xCoordNumbers; i <= xCoordNumbers; i++) {
            //ptsList.add(i);
            g2.draw(new Line2D.Double ((getWidth() / 2) + (i * xLength),
                    getHeight() / 2 - SECOND_LENGHT,
                    (getWidth() / 2) + (i * xLength),
                    getHeight() / 2 + SECOND_LENGHT));
            g2.drawString(Double.toString(i), (float) ((getWidth() / 2) + (i * xLength) - 3),
                    (float) getHeight() / 2 + AXIS_STRING_DISTANCE);
        }

//        // draw x-axis for negative numbers
//        for (int i = 1; i <= xCoordNumbersN; i++) {
//            g2.drawLine((getWidth() / 2) - (i * xLength),
//                    getHeight() / 2 - SECOND_LENGHT,
//                    (getWidth() / 2) - (i * xLength),
//                    getHeight() / 2 + SECOND_LENGHT);
//            g2.drawString(Integer.toString(-i),
//                    (getWidth() / 2) - (i * xLength) - 3,
//                    getHeight() / 2 + AXIS_STRING_DISTANCE);
//        }
//draw y-axis for positive numbers
        for (double i = -yCoordNumbers; i <= yCoordNumbers; i++) {
            g2.draw (new Line2D.Double((getWidth() / 2) - SECOND_LENGHT,
                    (getHeight() / 2) - (i * yLength),
                    (getWidth() / 2) + SECOND_LENGHT,
                    (getHeight() / 2) - (i * yLength))); 
            g2.drawString(Double.toString(i),
                    (getWidth() / 2) - AXIS_STRING_DISTANCE, (float) ((getHeight() / 2) - (i * yLength)));
        }
//
////draw y-axis for negative numbers
//        for (int i = -yCoordNumbers; i <= yCoordNumbers; i++) {
//            g2.drawLine((getWidth() / 2) - SECOND_LENGHT,
//                    (getHeight() / 2) + (i * yLength),
//                    (getWidth() / 2) + SECOND_LENGHT,
//                    (getHeight() / 2) + (i * yLength));
//            g2.drawString(Integer.toString(-i),
//                    (getWidth() / 2) - AXIS_STRING_DISTANCE,
//                    (getHeight() / 2) + (i * yLength));
//
//        }

        if (this.ui.getEquationType().equals("x +")) {

            for (int i = 1; i < linear.getxValue().size(); i++) {
                g2.draw( new Line2D.Double((getWidth() / 2) + linear.getxValue().get(i - 1) * xLength, (getHeight() / 2) + linear.getyValue().get(i - 1) * -yLength, (getWidth() / 2) + linear.getxValue().get(i) * xLength, (getHeight() / 2) + linear.getyValue().get(i) * -yLength));
            }
        }

        if (this.ui.getEquationType().equals("log2(x) +")) {
            //for (int i = 1; i < 2; i++) {
            for (int i = 1; i < logarithmic.getxValueLog().size(); i++) {
                g2.draw(new Line2D.Double((getWidth() / 2) + logarithmic.getxValueLog().get(i - 1) * xLength, (getHeight() / 2) + logarithmic.getyValueLog().get(i - 1) * -yLength, (getWidth() / 2) + logarithmic.getxValueLog().get(i) * xLength, (getHeight() / 2) + logarithmic.getyValueLog().get(i) * -yLength));

            }
        }

        g.drawImage(img, 0, 0, null);
    }

    /**
     * Adds point to the list
     *
     * @param x
     * @param y
     */
    public void addPoint(int x, int y) {
        this.ptsList.add(new Point(x, y));

    }

    /**
     * Getter for translatedX
     *
     * @return translatedX
     */
    public double getTranslateX() {
        return translateX;
    }

    /**
     * Getter for the translated Y val
     *
     * @return translatedY
     */
    public double getTranslateY() {
        return translateY;
    }

    /**
     * A setter for the translateX
     *
     * @param translateX
     */
    public void setTranslateX(int translateX) {
        this.translateX += translateX;
    }

    /**
     * A setter for the translateY
     *
     * @param translateY
     */
    public void setTranslateY(int translateY) {
        this.translateY += translateY;
    }

    /**
     * Getter for the zoom scale
     *
     * @return scale
     */
    public double getScale() {
        return scale;
    }

    /**
     * Sets the zoom scale
     *
     * @param scale
     */
    public void setScale(double scale) {
        this.scale = scale;
    }

    /**
     * Getter for the buffered Image
     *
     * @return
     */
    public BufferedImage getImg() {
        return img;
    }

    /**
     * Getter for xCoord
     *
     * @return xCoordNumbers
     */
    public int getxCoordNumbers() {
        return xCoordNumbers;
    }

    /**
     * Setter for xcoordinate
     *
     * @param xCoordNumbers
     */
    public void setxCoordNumbers(int xCoordNumbers) {
        this.xCoordNumbers = xCoordNumbers;
    }

    /**
     * setter for ycoordinate
     *
     * @param yCoordNumbers
     */
    public void setyCoordNumbers(int yCoordNumbers) {
        this.yCoordNumbers = yCoordNumbers;
    }

    /**
     * returns Points
     *
     * @return getsPoints
     */
    public List<Point> getPtsList() {
        return ptsList;
    }

    /**
     * Getter for yCoordNumbers
     *
     * @return Points
     */
    public int getyCoordNumbers() {
        return yCoordNumbers;
    }

    /**
     * Getter for the userInterface
     *
     * @return UI
     */
    public UserInterface getUi() {
        return ui;
    }

    /**
     * Getter for the mouse Pixel
     *
     * @return mouse Pixel
     */
    public int getMouseX() {
        return mouseX;
    }

    /**
     * Sets the mouse pixel
     *
     * @param mouseX
     */
    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    /**
     * Getter for the yMouse Coord
     *
     * @return the mouse y pixel
     */
    public int getMouseY() {
        return mouseY;
    }

    /**
     * Setting the Ycoord of the mouse
     *
     * @param mouseY
     */
    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    /**
     * Uses a formula to convert screen pixels to axis coordinate points
     *
     * @param pixels
     * @return the conversion of pixels to coordinates
     */
    public double pixToCoord(int pixels) {
//        DecimalFormat df = new DecimalFormat("#.##");
        return (2. * pixels - getWidth()) / (2. * xLength * this.ui.getScale() / 100);

    }
    /**
     * Uses a formula to convert screen pixels to axis coordinate points
     *
     * @param pixels
     * @return the conversion of pixels to coordinates
     */
    public int pixToCoordInt(int pixels) {
        return (int) ((2. * pixels - getWidth()) / (2. * xLength));
    }

}
