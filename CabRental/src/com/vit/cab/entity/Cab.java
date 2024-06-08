package com.vit.cab.entity;

public class Cab {
    int cabId;
    String cabType;
    String regNo;
    boolean isAvailable;

    public Cab(int cabId, String cabType, String regNo, boolean isAvailable) {
        this.cabId = cabId;
        this.cabType = cabType;
        this.regNo = regNo;
        this.isAvailable = isAvailable;
    }

    // Getter methods
    public int getCabId() {
        return cabId;
    }

    public String getCabType() {
        return cabType;
    }

    public String getRegNo() {
        return regNo;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    // Setter methods
    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
