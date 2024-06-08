package com.vit.cab.exception;

public class InvalidDataException extends Exception {

    public InvalidDataException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Invalid Data";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
