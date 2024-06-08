package com.vit.cab.exception;

public class ServiceUnavailableException extends Exception {

    public ServiceUnavailableException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Service Unavailable";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
