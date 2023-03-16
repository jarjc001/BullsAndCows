package com.BullsCows.ui;

import java.util.List;

public interface UserIO {

    /**
     * Will print a String message onto Console
     * @param message - message to get printed
     */
    void print(String message);

    /**
     * Takes in a String prompt to display to the user on the console,
     * Will then Read a String input the user enters into the console,
     * then will return said String input
     * @param prompt - String prompt to be displayed on console
     * @return - the answer of the prompt as a String
     */
    String readString(String prompt);
    /**
     * Takes in a String prompt to display to the user on the console,
     * Will then Read an int input the user enters into the console,
     * then will return said int input
     * @param prompt - String prompt to be displayed on console
     * @return - the answer of the prompt as an int
     */
    int readInt(String prompt);

    /**
     * Takes in a String prompt to display to the user on the console,
     * Will then Read an int input the user enters into the console,
     * then will return said int input if it is in an inclusive range
     * @param prompt - String prompt to be displayed on console
     *@param min - min of the inclusive range
     *@param max - max of the inclusive range
     * @return - the answer of the prompt as an int
     */
    int readInt(String prompt, int min, int max);

    /*** Takes in a String prompt to display to the user on the console,
     * Will then Read an int input the user enters into the console,
     * then will return said int as a List array of its digits
     * @param prompt - String prompt to be displayed on console
     * @return the answer of the prompt as a list array of digits
     */
    List<Integer> readIntList(String prompt);

}
