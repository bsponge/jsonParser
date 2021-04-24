package exceptions;

import jsonParser.JsonParser;

public class JsonParseException extends Exception {
    public JsonParseException(String errorMessage) {
        super(errorMessage);
    }
}
