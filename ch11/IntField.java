package ch11;

/*
 * File: IntField.java
 * Author: Java, Java, Java
 * Description:  This version of IntField has a bound
 *  associated with it, with the idea being that the
 *  user should not type a number greater than the bound 
 *  into the field. A programmer defined exception,
 *  IntOutOfRangeException, is thrown if the bound is
 *  exceeded.
 */

import javax.swing.*;

public class IntField extends JTextField {  
    private int bound = Integer.MAX_VALUE;
   
    /**
     * IntField() constructor merely invokes its superclass 
     *  constructor, in this way inheriting all the properties
     *  of a JTextField.
     */
    public IntField (int size) {
        super(size);
    }
   
    /**
     * This IntField() constructor sets the field's bound. 
     */
    public IntField(int size, int max) {
        super(size);
        bound = max;
    }

    /**
     * getInt() converts the field's text to an int and returns it. 
     *  This version also checks that the field's bound is not exceeded
     *  and raises an exception if it is. The method also makes clear tha
     *  a NumberFormatException could be thrown. This would happen if the
     *  user types a value that is not a valid integer.
     * @return an int representing the integer typed into the text field
     */
    public int getInt() throws NumberFormatException, IntOutOfRangeException {
        int num = Integer.parseInt(getText());            
        if (num > bound)
            throw new IntOutOfRangeException(bound);
        return num;
    } // getInt()

} // IntField
