package ch10;

/*
 *  File: MousePaint.java
 *  Author: Java, Java, Java
 *  Description: This class illustrates the use of methods from
 *   the MouseListener and MouseMotionListener interfaces. The user
 *   draws within a drawing panel by dragging the mouse. The panel
 *   is cleared when the user clicks on a small rectangle in the upper-left
 *   corner of the window.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MousePaint extends JPanel implements MouseListener,
                                                 MouseMotionListener {

    private static final int WIDTH = 300, HEIGHT = 300; // Initial size
    private static final int LEFT = 10;                 // Reference points
    private static final int TOP = 10;
    private static final int BORDER = 30;

    private static final Color backColor = Color.gray;  // Background color 
    private static final Color lineColor = Color.red;   // Outline color
    Color  mouseColor[] = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
    int  currentColor = 0;
    
    private Point mouse = new Point();                  // Mouse's current location
  
    /**
     *  MousePaint() constructor sets the size of the window and registers
     *  the mouse listeners. A MouseMotionListener listens for drag and move
     *  events. A MoustListener listens for click events.
     */
    public MousePaint() {    
        addMouseMotionListener(this);    // Add mouse and mouse motion listeners
        addMouseListener(this);
        setSize(WIDTH, HEIGHT);
    } // MousePaint()

    /**
     *  paintComponent() paints the component each time it is invoked. It must
     *   distinguish whether the mouse is in the top-left corner of the window,
     *   in which case it clears the window, or whether the user is drawing.
     */
    public void paintComponent(Graphics g) {
        Dimension d = getSize();                              
        g.setColor(lineColor);                              
        g.fillRect(0, 0, LEFT, TOP);                                // The clear rectangle
        g.drawRect(LEFT, TOP, d.width - BORDER, d.height - BORDER); // The drawing area
        g.drawString("Drag to draw; Click the red rectangle to clear.", LEFT, d.height - 5);
        g.setColor(mouseColor[currentColor]); 
        // Set drawing color

                   // If the mouse is within the drawing area, draw a dot
        if ((mouse.x > LEFT) && (mouse.x < LEFT + d.width - BORDER)
                         && (mouse.y > TOP) && (mouse.y < TOP + d.height - BORDER))
            g.fillRect(mouse.x, mouse.y, 3, 3); 
      
                   // If the mouse is clicked at top left corner clear the drawing
        if ((mouse.x < LEFT) && (mouse.y < TOP))   
            g.clearRect(LEFT + 1, TOP + 1, d.width - BORDER - 1, d.height - BORDER - 1);  
    } // paintComponent()

  /* Mouse Handling Interfaces:   MouseMotionListener and MouseListener */

    /**
     *  mouseDragged() handles the mouse drag event. In this case it merely
     *   gets the mouse's location and repaints the window.
     */
    public void mouseDragged(MouseEvent e) {   // When the mouse is dragged (mouse motion listener)
        mouse = e.getPoint();                    //  get its coordinates
        repaint();
    }

    /**
     *  mouseClick() handles mouse click events. In this case it just
     *   gets the mouse's location and repaints the window.
     */
    public void mouseClicked(MouseEvent e) {   // When mouse is clicked (mouse listener)
        mouse = e.getPoint();                    //  get its coordinates
        repaint();
    }
    public void mouseEntered(MouseEvent e) { } // These five interface methods are not used
    public void mouseExited(MouseEvent e)  { } //  but must be defined.
    public void mousePressed(MouseEvent e) {
    	if (e.getModifiers() == MouseEvent.BUTTON3_MASK){
    		currentColor++;
    		//System.out.println(currentColor); // Debug
    		if(currentColor > 8){
    			currentColor = 0;
    		}
    		repaint();
        }
    } 
    public void mouseReleased(MouseEvent e){ }   
    public void mouseMoved(MouseEvent e)   { }


    /**
     *  main() creates a top-level window and gives it a drawing panel.
     */
    public static void main(String args[]) {
        JFrame f = new JFrame("Drawing Window");  // Create the top-level window
        MousePaint mp = new MousePaint();         // And give it a drawing panel
        f.getContentPane().add(mp);
        f.setSize(mp.WIDTH, mp.HEIGHT);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {      // Quit the application
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    } // main()
} // MousePaint
