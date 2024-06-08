package com.vit.cab.service;

import com.vit.cab.entity.Cab;
import com.vit.cab.entity.CabDepot;

public class CabRentalService {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    // Method to validate route
    public String validateRoute(String source, String destination) {
        String[] validRoutes = {"CBE", "MAD", "TEN", "KDL", "OTY"};

        if (source.isEmpty() || destination.isEmpty() || source.equals(destination)) {
            return "Invalid Route";
        }

        boolean isSourceValid = false;
        boolean isDestinationValid = false;

        for (String route : validRoutes) {
            if (route.equalsIgnoreCase(source)) {
                isSourceValid = true;
            }
            if (route.equalsIgnoreCase(destination)) {
                isDestinationValid = true;
            }
        }

        if (!isSourceValid || !isDestinationValid) {
            try {
                throw new ServiceUnavailableException("Invalid route");
            } catch (ServiceUnavailableException e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }

        return "Available";
    }

    // Method to validate data
    public String validateData(String source, String destination, String cabType, int days) {
        String routeValidation = validateRoute(source, destination);

        if (!routeValidation.equals("Available")) {
            return routeValidation;
        }

        if (!cabType.equalsIgnoreCase("mini") && 
            !cabType.equalsIgnoreCase("micro") && 
            !cabType.equalsIgnoreCase("sedan")) {
            try {
                throw new InvalidDataException("Invalid cab type");
            } catch (InvalidDataException e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }

        if (days <= 1) {
            try {
                throw new InvalidDataException("Days must be greater than 1");
            } catch (InvalidDataException e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }

        return "Valid";
    }

    // Method to book cab
    public String bookCab(String source, String destination, String cabType, int days) {
        String validationResponse = validateData(source, destination, cabType, days);

        if (!validationResponse.equals("Valid")) {
            return validationResponse;
        }

        CabDepot depot = new CabDepot();
        depot.calculateRent(cabType, days);

        if (depot.getRentAmount() == 0.0) {
            return "Car Not Available";
        }

        String bookedCabDetails = depot.getBookedCabDetails();
        float rentAmount = depot.getRentAmount();

        return bookedCabDetails + "\nAmount:Rs." + rentAmount;
    }
}

// Custom exception for service unavailability
class ServiceUnavailableException extends Exception {
    public ServiceUnavailableException(String message) {
        super(message);
    }
}

// Custom exception for invalid data
class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}
