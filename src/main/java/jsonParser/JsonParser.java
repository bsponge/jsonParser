package jsonParser;

import exceptions.JsonParseException;

import java.lang.reflect.Field;
import java.util.*;

public class JsonParser {
    public JsonParser() {

    }

    public List<String> getStrings(String json) {
        List<String> list = new ArrayList<>();
        int length = json.length();
        for (int i = 0; i < length; i++) {
            char c = json.charAt(i);
            switch (c) {
                case '\'', '\"' -> {
                    int last = ++i;
                    while (i < length && json.charAt(i) != c) {
                        ++i;
                    }
                    if (i < length) {
                        list.add(json.substring(last, i));
                    }
                }
                case ' ' -> {}
                case '{', '}', '[', ']', ',', ':' -> list.add(json.substring(i, i + 1));
                default -> {
                    if (Character.isDigit(c)) {                                             // parse numbers
                        int last = i;
                        while (i < length && Character.isDigit(json.charAt(i))) {
                            ++i;
                        }
                        if (i < length) {
                            list.add(json.substring(last, i));
                        }
                        --i;
                    } else if (c == 'n') {                                                  // parse null values
                        if (i + 3 < length && json.substring(i, i + 4).equals("null")) {
                            list.add("null");
                        }
                    } else if (c == 't') {                                                  // parse boolean true
                        if (i + 3 < length && json.substring(i, i + 4).equals("true")) {
                            list.add("true");
                        }
                    } else if (c == 'f') {                                                  // parse boolean false
                        if (i + 4 < length && json.substring(i, i + 5).equals("false")) {
                            list.add("false");
                        }
                    }
                }
            }
        }
        return list;
    }

    public JsonObject fromJson(String json) throws JsonParseException {
        List<String> list = getStrings(json);
        JsonObject jsonObject = new JsonObject();
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case "{" -> i = jsonObject.parseObject(list, i);
            }
        }
        return jsonObject;
    }
}
