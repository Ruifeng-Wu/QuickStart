package com.ruifeng.quickstart.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("This object not found");
    }

    public NotFoundException(String element) {
        super(element + " not found");
    }
}
