package jsonParser;

import exceptions.JsonParseException;

import java.util.*;

public class JsonParser {
    public JsonParser() {

    }

    public List<String> getStrings(String json) throws JsonParseException {
        List<String> list = new ArrayList<>();
        int length = json.length();
        for (int i = 0; i < length; i++) {
            char c = json.charAt(i);
            switch (c) {
                case '\'', '\"' -> {
                    int last = ++i;
                    while (i < length && json.charAt(i) != c) {                             // read until next " or '
                        ++i;
                    }
                    if (i < length) {
                        list.add(json.substring(last, i));
                    } else {
                        throw new JsonParseException("Missing '\"' !");
                    }
                }
                case ' ' -> {}
                case '{', '}', '[', ']', ',', ':' -> list.add(json.substring(i, i + 1));
                default -> {
                    if (Character.isDigit(c)) {                                             // parse unsigned integers
                        int last = i;
                        while (i < length && Character.isDigit(json.charAt(i))) {
                            ++i;
                        }
                        if (i < length && isSpecial(json.charAt(i))) {
                            list.add(json.substring(last, i));
                        } else {
                            throw new JsonParseException("Wrong number format!");
                        }
                        --i;
                    } else if (c == 'n') {                                                  // parse null values
                        if (i + 4 < length && json.startsWith("null", i) && isSpecial(json.charAt(i + 4))) {
                            list.add("null");
                            i += 3;
                        } else {
                            throw new JsonParseException("Wrong json syntax!");
                        }
                    } else if (c == 't') {                                                  // parse boolean true
                        if (i + 4 < length && json.startsWith("true", i) && isSpecial(json.charAt(i + 4))) {
                            list.add("true");
                            i += 3;
                        } else {
                            throw new JsonParseException("Wrong json syntax!");
                        }
                    } else if (c == 'f') {                                                  // parse boolean false
                        if (i + 5 < length && json.startsWith("false", i) && isSpecial(json.charAt(i + 5))) {
                            list.add("false");
                            i += 4;
                        } else {
                            throw new JsonParseException("Wrong json syntax!");
                        }
                    }
                }
            }
        }
        return list;
    }

    private boolean isSpecial(char c) {
        return c == ',' || c == ']' || c == '}' || Character.isWhitespace(c);
    }

    public JsonObject fromJson(String json) throws JsonParseException {
        List<String> list = getStrings(json);
        JsonObject jsonObject = new JsonObject();
        for (int i = 0; i < list.size(); i++) {
            if ("{".equals(list.get(i))) {
                i = jsonObject.parseObject(list, i);
            }
        }
        return jsonObject;
    }
}
