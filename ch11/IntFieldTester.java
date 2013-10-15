package ch11;

/*
 * File: IntFieldTester.java
 * Author: Java, Java, Java
 * Description: This program provides an interface for
 *  testing the IntField class. An IntField is a JTextField that
 *  accepts only integers within a certain bound. This program
 *  creates an IntField and lets the user input values. If the
 *  user inputs an invalid value, it handles the exception that is
 *  raised.
 
 * Note that all the exceptions are handled in the actionPerformed()
 *  method. This illustrates the principle that Java's exception handling
 *  can be organized separately from the program's main flow of execution.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IntFieldTester extends JPanel implements ActionListener  {
    public static final int WIDTH = 300, HEIGHT = 300;
    
    private JLabel prompt = new JLabel("Input an integer in range 100 to 200: ");
    private IntField intField = new IntField(12, 100, 200); // Add custom range?
    private int userInt;
    private String message = "Hello";
    
    /**
     * IntFieldTester() sets up the program's interface.
     */
    public IntFieldTester() {
        add(prompt);
        intField.addActionListener(this);
        add(intField);
        setSize(WIDTH, HEIGHT);
    } // IntFieldTester()
	
    /**
     * paintComponent() repaints the component's background and
     *  display's the contents of message.
     */
    public void paintComponent( Graphics g ) {
        g.setColor(getBackground());            // Clear the panel
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(getForeground());
        g.drawString(message, 10, 70);
    } // paintComponent()
	
    /**
     * actionPerformed() handles the program's action events. Since
     *  an action event can cause an exception, it also handles the
     *  various exceptions that can result. A NumberFormatException
     *  would result if the user typed a noninteger into the IntField.
     *  A IntOutOfRangeException would be thrown if the user typed an
     *  integer that was too large.
     */
    public void actionPerformed(ActionEvent evt) {
        try {
            userInt = intField.getInt();
            message = "You input " + userInt + " Thank you.";  
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
               "The input must be an integer. Please reenter.");
        } catch (IntOutOfRangeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } finally {
            repaint();
        }
    } // actionPerformed()
	
    /**
     * main() creates a top-level window and adds an instance of
     *  IntFieldTester to to. It uses an anonyous class to create
     *  a listener for window close events.
     */
    public static void main(String args[]) {
        JFrame f = new JFrame("IntField Tester");
        IntFieldTester panel = new IntFieldTester();
        f.getContentPane().add(panel);
        f.setSize(panel.WIDTH, panel.HEIGHT);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {      // Quit the application
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    } // main()
} // IntFieldTester
