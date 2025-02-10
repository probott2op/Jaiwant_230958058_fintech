package com.lab7.UI_Test;

public class ResoruceNotFoundException extends RuntimeException{
    ResoruceNotFoundException(String message)
    {
        super(message);
    }

    ResoruceNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
