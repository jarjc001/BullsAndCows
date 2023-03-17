package com.BullsCows.dao;

public class BullsCowsDataException extends Exception{

    public BullsCowsDataException  (String message) {
        super(message);
    }

    public BullsCowsDataException(String message, Throwable cause) {
        super(message, cause);
    }

}
