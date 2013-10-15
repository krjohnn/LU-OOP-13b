package ch05;

/*
 * File: CyberPetApplet.java
 * Author: Java, Java, Java
 * Description: This apply provides a graphical user
 *  interface to the CyberPet class. The interface consists
 *  of two Buttons that can be clicked to tell the CyberPet
 *  to eat or drink, and a TextField which reports the 
 *  CyberPet's state. 
 *  
 *  The interface is initialized in the init() method and
 *  user actions are handled in the actionPerformed() method.
 */

//import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.*;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
//import javax.swing.JRadioButtonMenuItem;

public class CyberPetApplet extends JApplet implements ActionListener
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// Declare instance variables
   private CyberPet pet1;                   // The CyberPet
   private TextField stateField;            // A TextField
   private JMenuItem eatButton;
   private JMenuItem sleepButton;   // Two Buttons
   private Image sleep, eat;
   private JLabel image;
   
   // ld06
   // MenuBar, Menu, RadioButtons
   private JMenuBar menuBar;
   private JMenu commandMenu;
   //private JMenu radioMenu;
   private JRadioButton eatRadioButton;
   private JRadioButton sleepRadioButton;

   /* 
    * The init() method instantiates the instance variables, including both the 
    * CyberPet (pet1) and the GUI elements that are displayed on the applet.
    */
    public void init() 
    { 
       setLayout(new BorderLayout());
    	
       pet1 = new CyberPet("Socrates");   // CyberPet
        // Create the GUI components
       try {
	   URL sleeps = new URL(getDocumentBase(), "bakersleep.jpg");
	   sleep = ImageIO.read(sleeps);
	   URL eats = new URL(getDocumentBase(), "bakereat.jpg");
	   eat = ImageIO.read(eats);
	} catch (MalformedURLException e) {
	   e.printStackTrace();
	} catch (Exception ex) {
       ex.printStackTrace();
	}
       new Label("Hi! My name is " + pet1.getName() + 
                              " and currently I am : ");  
       stateField = new TextField(12);
       image = new JLabel(new ImageIcon(eat));
       
       // Add MenuBar and Menu
       menuBar = new JMenuBar();
       
   	   commandMenu = new JMenu("Command");
	   //radioMenu = new JMenu("Radio buttons");
	   
	   // Buttons and RadioButtons
       eatButton = new JMenuItem("Eat!");     
       sleepButton = new JMenuItem("Sleep!");
       
       eatRadioButton = new JRadioButton("Eat");
	   sleepRadioButton = new JRadioButton("Sleep");
	   eatRadioButton.setSelected(true);
	   
	   // Assign the listeners.

       eatButton.addActionListener(this);    
       sleepButton.addActionListener(this);
       
       eatRadioButton.addActionListener(this);
       sleepRadioButton.addActionListener(this);
       
       
       
       eatButton.setVisible(false);
 
        // Initialize the TextField

      stateField.setText(pet1.getState());
      stateField.setEditable(false);
      
      commandMenu.add(sleepButton);
	  commandMenu.add(eatButton);
	  
	  ButtonGroup buttonGroup = new ButtonGroup();
	  // Create ButtonGroup
	  buttonGroup.add(sleepRadioButton);
	  buttonGroup.add(eatRadioButton);
	  
	  // Add RadioMenuButtons to Menu
	  add(eatRadioButton);
	  add(sleepRadioButton);
      

      // Add the components to the applet.
	  
      JPanel buttonpanel = new JPanel(new GridLayout(1, 2));
	  buttonpanel.add(eatRadioButton);
      buttonpanel.add(sleepRadioButton);
	  
	  menuBar.add(commandMenu);
	  //menuBar.add(radioMenu);
	  setJMenuBar(menuBar);
      add(image, BorderLayout.CENTER);
      add(buttonpanel, BorderLayout.SOUTH);

      setSize(450,300);          // Set the applet's size to 450 x 300 pixels
    } 
    
    
    // init
   

	public void paint(Graphics g) {
		super.paint(g);
	}

    /*
     * The actionPerformed() method is called whenever 
     * one of the buttons is pressed.
     */
    public void actionPerformed( ActionEvent e) 
    {
        if (e.getSource() == eatButton || e.getSource() == eatRadioButton ){
            pet1.eat();
            eatButton.setVisible(false);
            sleepButton.setVisible(true);
            
            eatRadioButton.setSelected(true);
            image.setIcon(new ImageIcon(eat));
        }
        else if (e.getSource() == sleepButton || e.getSource() == sleepRadioButton){
            pet1.sleep();
            eatButton.setVisible(true);
            sleepButton.setVisible(false);
            
            sleepRadioButton.setSelected(true);
            image.setIcon(new ImageIcon(sleep));
        }
        stateField.setText(pet1.getState());
        repaint();
    }//actionPerformed
   
} // CyberPetApplet
