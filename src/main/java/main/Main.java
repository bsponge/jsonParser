package main;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String... args) {
        Solution.parseData();

        System.out.println("1.");
        System.out.println("a.");
        System.out.println("Flight number:");
        int flightNumber = Integer.parseInt(getInput());
        System.out.println("Date:");
        LocalDateTime date = LocalDateTime.parse(getInput());

        System.out.printf("Cargo weight: %f kg\n", Solution.getTotalCargoWeight(flightNumber, date));
        System.out.printf("Baggage weight: %f kg\n", Solution.getTotalBaggageWeight(flightNumber, date));
        System.out.printf("Total weight: %f kg\n", Solution.getTotalWeight(flightNumber, date));
        System.out.println();

        System.out.println("2.");
        System.out.println("IATA Airport Code:");
        String IATAAirportCode = getInput();

        System.out.printf("Number of flights departing from the airport: %d\n", Solution.getNumberOfDepartingFlights(IATAAirportCode));
        System.out.printf("Number of flights arriving to the airport: %d\n", Solution.getNumberOfArrivingFlights(IATAAirportCode));
        System.out.printf("Total number of baggage arriving to the airport: %d\n", Solution.getNumberOfPiecesOfArrivingBaggage(IATAAirportCode));
        System.out.printf("Total number of baggage departing from the airport: %d\n", Solution.getNumberOfPiecesOfDepartingBaggage(IATAAirportCode));

    }

    public static String getInput() {
        System.out.print('>');
        return scanner.nextLine();
    }
}
