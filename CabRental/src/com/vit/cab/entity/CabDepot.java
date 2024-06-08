package com.vit.cab.entity;

public class CabDepot {
    static Cab[] cabs;
    float rentAmount;
    Cab bookedCab;

    // Getter methods
    public static Cab[] getCabs() {
        return cabs;
    }

    public float getRentAmount() {
        return rentAmount;
    }

    public Cab getBookedCab() {
        return bookedCab;
    }

    // Setter methods
    public static void setCabs(Cab[] cabs) {
        CabDepot.cabs = cabs;
    }

    public void setRentAmount(float rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setBookedCab(Cab bookedCab) {
        this.bookedCab = bookedCab;
    }

    // Method to calculate rent
    public void calculateRent(String cabType, int days) {
        for (Cab cab : cabs) {
            if (cab.getCabType().equalsIgnoreCase(cabType) && cab.getIsAvailable()) {
                float ratePerDay = getRatePerDay(cabType);
                rentAmount = ratePerDay * days;
                bookedCab = cab;
                cab.setIsAvailable(false);
                break;
            }
        }
    }

    // Method to get rate per day
    public float getRatePerDay(String cabType) {
        switch (cabType.toLowerCase()) {
            case "micro":
                return 2525.0f * 1.10f;
            case "mini":
                return 3110.0f * 1.12f;
            case "sedan":
                return 3500.0f * 1.16f;
            default:
                return 0.0f;
        }
    }

    // Method to get booked cab details
    public String getBookedCabDetails() {
        if (bookedCab != null) {
            return "Cab Type:" + bookedCab.getCabType() + "\nCab No:" + bookedCab.getRegNo();
        }
        return "No cab booked.";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
