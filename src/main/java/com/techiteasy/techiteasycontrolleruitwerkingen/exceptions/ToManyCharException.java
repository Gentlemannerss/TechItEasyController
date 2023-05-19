package com.techiteasy.techiteasycontrolleruitwerkingen.exceptions;

public class ToManyCharException extends RuntimeException{

    public ToManyCharException() {
        super();
    }

    public ToManyCharException(String message) {
        super(message);
    }
}
