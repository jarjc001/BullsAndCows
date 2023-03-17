package com.BullsCows.ui;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class UserIOConsoleImpl implements UserIO{

    /**Scanner object to take in console inputs from user*/
    final private Scanner sc = new Scanner(System.in);


    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        Scanner sc = new Scanner(System.in);
        //print prompt
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        Scanner sc = new Scanner(System.in);
        int num;
        while (true) {
            try {
                String stringValue = readString(prompt);
                // Get the input line, and parse into an int
                num = Integer.parseInt(stringValue);
                break;
            } catch (NumberFormatException e) {
                this.print("Input not a number, Try again");
            }
        }
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        //the loop will keep repeating until the input int is within range
        do {
            result = readInt(prompt);
        }while(result<min || result>max);

        return result;

    }

    @Override
    public List<Integer> readIntList(String prompt) {
        int result = readInt(prompt);
        ArrayList<Integer> array = new ArrayList<Integer>();

        do{
            array.add(0,result % 10); //gets the smallest digit
            result /= 10;       //removes the smallest digit
        } while (result > 0);
        return array;
    }


}
