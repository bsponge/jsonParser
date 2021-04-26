package exceptions;


public class JsonParseException extends Exception {
    public JsonParseException(String errorMessage) {
        super(errorMessage);
    }
}
