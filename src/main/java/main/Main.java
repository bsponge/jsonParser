package main;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String... args) {
        System.out.println("1.");
        System.out.println("a.");
        System.out.println("Flight number:");
        int flightNumber = Integer.parseInt(getInput());
        System.out.println("Date:");
        LocalDateTime date = LocalDateTime.parse(getInput());

        System.out.println("Cargo weight: " + Solution.getTotalCargoWeightInKg(flightNumber, date) + "kg");
        System.out.println("Baggage weight: " + Solution.getTotalBaggageWeightInKg(flightNumber, date) + "kg");
        System.out.println("Total weight: " + Solution.getTotalWeightInKg(flightNumber, date) + "kg");
        System.out.println();

        System.out.println("2.");
        System.out.println("IATA Airport Code:");
        String IATAAirportCode = getInput();

        System.out.println("Number of flights departing from the airport: " + Solution.getNumberOfDepartingFlights(IATAAirportCode));
        System.out.println("Number of flights arriving to the airport: " + Solution.getNumberOfArrivingFlights(IATAAirportCode));
        System.out.println("Total number of baggage arriving to the airport: " + Solution.getNumberOfPiecesOfArrivingBaggage(IATAAirportCode));
        System.out.println("Total number of baggage departing from the airport: " + Solution.getNumberOfPiecesOfDepartingBaggage(IATAAirportCode));

    }

    public static String getInput() {
        System.out.print('>');
        return scanner.nextLine();
    }
}
