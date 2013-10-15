package ch05;

/*
 * File: CyberPet.java
 * Author: Java, Java, Java
 * Description:  This version of the CyberPet class uses the int
 *  type to represent the CyberPet's state. This makes it easier 
 *  incorporate new states into the model, since each state can 
 *  can be given a distinct integer value. It also simplifies the
 *  access methods, which can now just assign the appropriate value
 *  to the state variable. There's less chance of logical inconsistencies.

 *  Note the use of class constants, EATING, SLEEPING, THINKING, to 
 *  represent different states.
 */

public class CyberPet 
{
    public static final int EATING = 0;   // Class constants
    public static final int SLEEPING = 1;
    public static final int THINKING = 2;

    private int petState;   // Instance variables
    private String name;

    /**
     *  CyberPet() initializes the pet's state to EATING
     */
    public CyberPet() {            // Constructor #1
        name = "no name";
        petState = EATING;
    } 

    /**
     *  CyberPet(str) initializes the pet's name
     *  @param str -- a string giving pet's name
     */
    public CyberPet(String str) {  // Constructor #2
        name = str;
        petState = EATING;
    }

    /**
     *  CyberPet(str, inState) initializes the pet's name and state
     *  @param str -- a string giving pet's name
     *  @param inState -- an int giving the pet's state
     */
    public CyberPet(String str, int inState) { // Constructor #3
        name = str;
        petState = inState;
    } 

    /**
     *  CyberPet(str, sleeping) preserves backward compatibility 
     *  with previous versions of CyberPet by taking a boolean parameter 
     *  representing the pet's state. 
     *  @param str -- a string giving the pet's name
     *  @param sleeping  -- a boolean set to SLEEPING (true) or EATING (false)
     */
    public CyberPet(String str, boolean sleeping) {  // Constructor #4
        name = str;
        if (sleeping == true)
            petState = SLEEPING;
        else
            petState = EATING;
    }

    /**
     *  setName() sets the CyberPet's name.
     *  @param str -- a string giving the pet's name
     */
    public void setName(String str) { 
        name = str; 
    } // setName()

    /**
     *  getName() returns the CyberPet's name.
     *  @return -- a string giving the CyberPet's name
     */
    public String getName() { 
        return name;         
    } // getName()

    /**
     *  eat() sets the pet's state to EATING
     */
    public void eat() { 
        petState = EATING;   
    } // eat()

    /**
     *  sleep() sets the pet's state to SLEEPING
     */
    public void sleep() { 
        petState = SLEEPING; 
    } // sleep()

    /**
     *  think() sets the pet's state to THINKING
     */
    public void think() { 
        petState = THINKING; 
    } // think()

    /**
     *  toString() returns a string representation of CyberPet
     */
    public String toString() { 
        return "I am a CyberPet named " + name;  
    }

    /**
     *  getState() returns the pet's state
     *  @return a String representing the pet's state
     */
    public String getState() {
        if (petState == EATING)
            return "Eating";           // Exit the method
        if (petState == SLEEPING) 
            return "Sleeping";         // Exit the method
        if (petState == THINKING)
            return "Thinking";
        return "Error in State";       // Exit the method
    } // getState()
} // CyberPet
