package main;

import exceptions.JsonParseException;
import jsonParser.JsonArray;
import jsonParser.JsonObject;
import jsonParser.JsonParser;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Stack;

public class Solution {
    static String[] flightEntities = DataSupplier.getFlightEntities();
    static String[] cargoEntities = DataSupplier.getCargoEntities();
    static JsonObject[] flightJsonObjects = new JsonObject[flightEntities.length];
    static JsonObject[] cargoJsonObjects = new JsonObject[cargoEntities.length];
    static JsonParser jsonParser = new JsonParser();

    static {
        for (int i = 0; i < flightEntities.length; i++) {
            try {
                flightJsonObjects[i] = jsonParser.fromJson(flightEntities[i]);
            } catch (JsonParseException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < cargoEntities.length; i++) {
            try {
                cargoJsonObjects[i] = jsonParser.fromJson(cargoEntities[i]);
            } catch (JsonParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static double getTotalBaggageWeightInKg(int flightNumber, LocalDateTime date) {
        JsonObject jsonObject = new JsonObject();
        int flightId = -1;
        for (JsonObject jo : flightJsonObjects) {
            if (jo.getAsInt("flightNumber") == flightNumber && jo.getAsLocalDateTime("departureDate").equals(date)) {
                jsonObject = jo;
                break;
            }
        }
        flightId = jsonObject.getAsInt("flightId");
        for (JsonObject jo : cargoJsonObjects) {
            if (jo.getAsInt("flightId") == flightId) {
                jsonObject = jo;
            }
        }
        double totalBaggageWeightInKg = 0.0;
        JsonArray baggageArray = jsonObject.getAsJsonArray("baggage");
        for (Object obj : baggageArray.getElements()) {
            JsonObject baggage = (JsonObject) obj;
            if (baggage.getAsString("weightUnit").equals("kg")) {
                totalBaggageWeightInKg += baggage.getAsInt("weight") * baggage.getAsInt("pieces");
            } else {
                totalBaggageWeightInKg += baggage.getAsInt("weight") * baggage.getAsInt("pieces") * 0.45359237;
            }
        }
        return totalBaggageWeightInKg;
    }

    public static double getTotalCargoWeightInKg(int flightNumber, LocalDateTime date) {
        JsonObject jsonObject = new JsonObject();
        int flightId = -1;
        for (JsonObject jo : flightJsonObjects) {
            if (jo.getAsInt("flightNumber") == flightNumber && jo.getAsLocalDateTime("departureDate").equals(date)) {
                jsonObject = jo;
                break;
            }
        }
        flightId = jsonObject.getAsInt("flightId");
        for (JsonObject jo : cargoJsonObjects) {
            if (jo.getAsInt("flightId") == flightId) {
                jsonObject = jo;
            }
        }
        JsonArray cargoArray = jsonObject.getAsJsonArray("cargo");
        double totalCargoWeightInKg = 0.0;
        for (Object obj : cargoArray.getElements()) {
            JsonObject cargoElement = (JsonObject) obj;
            if (cargoElement.getAsString("weightUnit").equals("kg")) {
                totalCargoWeightInKg += cargoElement.getAsInt("weight") * cargoElement.getAsInt("pieces");
            } else {
                totalCargoWeightInKg += cargoElement.getAsInt("weight") * cargoElement.getAsInt("pieces") * 0.45359237;
            }
        }
        return totalCargoWeightInKg;
    }

    public static double getTotalWeightInKg(int flightNumber, LocalDateTime date) {
        double totalWeightInKg = 0.0;
        JsonObject jsonObject = new JsonObject();
        int flightId = -1;
        for (JsonObject jo : flightJsonObjects) {
            if (jo.getAsInt("flightNumber") == flightNumber && jo.getAsLocalDateTime("departureDate").equals(date)) {
                jsonObject = jo;
                break;
            }
        }
        flightId = jsonObject.getAsInt("flightId");
        for (JsonObject jo : cargoJsonObjects) {
            if (jo.getAsInt("flightId") == flightId) {
                jsonObject = jo;
            }
        }
        JsonArray cargoArray = jsonObject.getAsJsonArray("cargo");
        JsonArray baggageArray = jsonObject.getAsJsonArray("baggage");
        for (Object obj : cargoArray.getElements()) {
            JsonObject cargoElement = (JsonObject) obj;
            if (cargoElement.getAsString("weightUnit").equals("kg")) {
                totalWeightInKg += cargoElement.getAsInt("weight") * cargoElement.getAsInt("pieces");
            } else {
                totalWeightInKg += cargoElement.getAsInt("weight") * cargoElement.getAsInt("pieces") * 0.45359237;
            }
        }
        for (Object obj : baggageArray.getElements()) {
            JsonObject baggage = (JsonObject) obj;
            if (baggage.getAsString("weightUnit").equals("kg")) {
                totalWeightInKg += baggage.getAsInt("weight") * baggage.getAsInt("pieces");
            } else {
                totalWeightInKg += baggage.getAsInt("weight") * baggage.getAsInt("pieces") * 0.45359237;
            }
        }
        return totalWeightInKg;
    }

    public static int getNumberOfDepartingFlights(String IATAAirportCode) {
        int numOfDepartingFlights = 0;
        for (JsonObject obj : flightJsonObjects) {
            if (obj.getAsString("departureAirportIATACode").equals(IATAAirportCode)) {
                ++numOfDepartingFlights;
            }
        }
        return numOfDepartingFlights;
    }

    public static int getNumberOfArrivingFlights(String IATAAirportCode) {
        int numOfArrivingFlights = 0;
        for (JsonObject obj : flightJsonObjects) {
            if (obj.getAsString("arrivalAirportIATACode").equals(IATAAirportCode)) {
                ++numOfArrivingFlights;
            }
        }
        return numOfArrivingFlights;
    }

    public static int getNumberOfPiecesOfArrivingBaggage(String IATAAirportCode) {
        Stack<Integer> flightIds = new Stack<>();
        for (JsonObject jsonObject : flightJsonObjects) {
            if (jsonObject.getAsString("arrivalAirportIATACode").equals(IATAAirportCode)) {
                flightIds.push(jsonObject.getAsInt("flightId"));
            }
        }
        int numOfPieces = 0;
        while (!flightIds.empty()) {
            int flightId = flightIds.pop();
            for (JsonObject jsonObject : cargoJsonObjects) {
                if (jsonObject.getAsInt("flightId") == flightId) {
                    List<Object> baggageJsonArray = jsonObject.getAsJsonArray("baggage").getElements();
                    for (Object element : baggageJsonArray) {
                        JsonObject jo = (JsonObject) element;
                        numOfPieces += jo.getAsInt("pieces");
                    }
                }
            }
        }
        return numOfPieces;
    }

    public static int getNumberOfPiecesOfDepartingBaggage(String IATAAirportCode) {
        Stack<Integer> flightIds = new Stack<>();
        for (JsonObject jsonObject : flightJsonObjects) {
            if (jsonObject.getAsString("departureAirportIATACode").equals(IATAAirportCode)) {
                flightIds.push(jsonObject.getAsInt("flightId"));
            }
        }
        int numOfPieces = 0;
        while (!flightIds.empty()) {
            int flightId = flightIds.pop();
            for (JsonObject jsonObject : cargoJsonObjects) {
                if (jsonObject.getAsInt("flightId") == flightId) {
                    List<Object> baggageJsonArray = jsonObject.getAsJsonArray("baggage").getElements();
                    for (Object element : baggageJsonArray) {
                        JsonObject jo = (JsonObject) element;
                        numOfPieces += jo.getAsInt("pieces");
                    }
                }
            }
        }
        return numOfPieces;
    }
}
