package com.vit.cab.main;

import com.vit.cab.entity.Cab;
import com.vit.cab.entity.CabDepot;
import com.vit.cab.service.CabRentalService;
import java.util.Scanner;
public class MainClass {

    public static void main(String[] args) {
        // Initialize the cab inventory
        Cab[] cabs = new Cab[5];
        cabs[0] = new Cab(1, "micro", "TN37AP0001", true);
        cabs[1] = new Cab(2, "mini", "TN37AP0002", true);
        cabs[2] = new Cab(3, "sedan", "TN37AP0003", true);
        cabs[3] = new Cab(4, "micro", "TN37AP0004", true);
        cabs[4] = new Cab(5, "sedan", "TN37AP0005", true);

        // Set the cabs to the CabDepot
        CabDepot.setCabs(cabs);

        // Create an object of CabRentalService
        CabRentalService cabRentalService = new CabRentalService();

        // Test booking a cab
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter source");
        String source = sc.nextLine();
        System.out.println("Enter destination");
        String destination = sc.nextLine();
        System.out.println("Enter Cab Type");
        String cabType = sc.nextLine();
        System.out.println("Enter Number of Days");
        int days = sc.nextInt();

        String bookingResult = cabRentalService.bookCab(source, destination, cabType, days);
        System.out.println(bookingResult);
    }
}
