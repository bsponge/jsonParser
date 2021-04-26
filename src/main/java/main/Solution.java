package main;

import exceptions.JsonParseException;
import jsonParser.JsonArray;
import jsonParser.JsonObject;
import jsonParser.JsonParser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Solution {
    static ArrayList<JsonObject> flightJsonObjects = new ArrayList<>();
    static ArrayList<JsonObject> cargoJsonObjects = new ArrayList<>();
    static JsonParser jsonParser = new JsonParser();

    // parse json strings from DataSupplier to JsonObjects,
    // strings in DataSupplier are copied from json-generator.com
    public static void parseData() {
        JsonArray jsonArray = new JsonArray();
        try {
            jsonArray.parseArray(jsonParser.getStrings(DataSupplier.getFlightEntities()), 0);
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < jsonArray.getElements().size(); i++) {
            flightJsonObjects.add((JsonObject) jsonArray.getElements().get(i));
        }
        jsonArray = new JsonArray();
        try {
            jsonArray.parseArray(jsonParser.getStrings(DataSupplier.getCargoEntities()), 0);
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < jsonArray.getElements().size(); i++) {
            cargoJsonObjects.add((JsonObject) jsonArray.getElements().get(i));
        }
    }

    // returns total baggage weight in kg
    public static double getTotalBaggageWeight(int flightNumber, LocalDateTime date) {
        JsonObject jsonObject = null;
        int flightId;
        for (JsonObject jo : flightJsonObjects) {
            if (jo.getAsInt("flightNumber") == flightNumber && jo.getAsLocalDateTime("departureDate").equals(date)) {
                jsonObject = jo;
                break;
            }
        }
        double totalBaggageWeightInKg = 0.0;

        if (jsonObject != null) {
            flightId = jsonObject.getAsInt("flightId");
            for (JsonObject jo : cargoJsonObjects) {
                if (jo.getAsInt("flightId") == flightId) {
                    jsonObject = jo;
                }
            }
            JsonArray baggageArray = jsonObject.getAsJsonArray("baggage");
            for (Object obj : baggageArray.getElements()) {
                JsonObject baggage = (JsonObject) obj;
                if (baggage.getAsString("weightUnit").equals("kg")) {
                    totalBaggageWeightInKg += baggage.getAsInt("weight");
                } else {
                    totalBaggageWeightInKg += baggage.getAsInt("weight") * 0.45359237;
                }
            }
        } else {
            throw new NoSuchElementException();
        }

        return totalBaggageWeightInKg;
    }

    // returns total cargo weight in kg
    public static double getTotalCargoWeight(int flightNumber, LocalDateTime date) {
        JsonObject jsonObject = null;
        int flightId;
        for (JsonObject jo : flightJsonObjects) {
            if (jo.getAsInt("flightNumber") == flightNumber && jo.getAsLocalDateTime("departureDate").equals(date)) {
                jsonObject = jo;
                break;
            }
        }

        double totalCargoWeightInKg = 0.0;

        if (jsonObject != null) {
            flightId = jsonObject.getAsInt("flightId");
            for (JsonObject jo : cargoJsonObjects) {
                if (jo.getAsInt("flightId") == flightId) {
                    jsonObject = jo;
                }
            }
            JsonArray cargoArray = jsonObject.getAsJsonArray("cargo");
            for (Object obj : cargoArray.getElements()) {
                JsonObject cargoElement = (JsonObject) obj;
                if (cargoElement.getAsString("weightUnit").equals("kg")) {
                    totalCargoWeightInKg += cargoElement.getAsInt("weight");
                } else {
                    totalCargoWeightInKg += cargoElement.getAsInt("weight") * 0.45359237;
                }
            }
        } else {
            throw new NoSuchElementException();
        }

        return totalCargoWeightInKg;
    }

    // returns total weight in kg
    public static double getTotalWeight(int flightNumber, LocalDateTime date) {
        double totalWeightInKg = 0.0;
        JsonObject jsonObject = null;
        int flightId;
        for (JsonObject jo : flightJsonObjects) {
            if (jo.getAsInt("flightNumber") == flightNumber && jo.getAsLocalDateTime("departureDate").equals(date)) {
                jsonObject = jo;
                break;
            }
        }
        if (jsonObject != null) {
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
                    totalWeightInKg += cargoElement.getAsInt("weight");
                } else {
                    totalWeightInKg += cargoElement.getAsInt("weight") * 0.45359237;
                }
            }
            for (Object obj : baggageArray.getElements()) {
                JsonObject baggage = (JsonObject) obj;
                if (baggage.getAsString("weightUnit").equals("kg")) {
                    totalWeightInKg += baggage.getAsInt("weight");
                } else {
                    totalWeightInKg += baggage.getAsInt("weight") * 0.45359237;
                }
            }
        } else {
            throw new NoSuchElementException();
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
