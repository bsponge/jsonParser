package jsonParser;

import exceptions.JsonParseException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonObject {
    private final Map<String, Object> jsonMap;

    public JsonObject() {
        this.jsonMap = new HashMap<>();
    }

    int parseObject(List<String> list, int index) throws JsonParseException {
        int length = list.size();
        ++index;
        int i = 0;
        String name = "";
        while (index < length && !list.get(index).equals("}")) {
            if (i == 0) {
                name = list.get(index);
            } else if (i == 1) {
                if (!list.get(index).equals(":")) {
                    throw new JsonParseException("Wrong token after property name!");
                }
            } else if (i == 2) {
                if (list.get(index).equals("{")) {
                    JsonObject nestedJsonObject = new JsonObject();
                    this.add(name, nestedJsonObject);
                    index = nestedJsonObject.parseObject(list, index);
                } else if (list.get(index).equals("[")) {
                    JsonArray jsonArray = new JsonArray();
                    this.add(name, jsonArray);
                    index = jsonArray.parseArray(list, index);
                } else {
                    this.add(name, list.get(index));
                }
            } else if (i == 3) {
                if (!list.get(index).equals(",")) {
                    throw new JsonParseException("Missing ',' after " + name + " value!");
                }
                i = -1;
            }
            ++index;
            ++i;
        }
        return index;
    }

    public void add(String name, Object obj) {
        jsonMap.put(name, obj);
    }

    public int getAsInt(String name) {
        return Integer.parseInt((String) jsonMap.get(name));
    }

    public String getAsString(String name) {
        return (String) jsonMap.get(name);
    }

    public LocalDateTime getAsLocalDateTime(String name) {
        return LocalDateTime.parse((String) jsonMap.get(name));
    }

    public JsonArray getAsJsonArray(String name) {
        return (JsonArray) jsonMap.get(name);
    }

    public JsonObject getAsJsonObject(String name) {
        return (JsonObject) jsonMap.get(name);
    }

    public void print() {
        System.out.println("{");
        for (String key : jsonMap.keySet()) {
            System.out.print(key + " ---> ");
            if (jsonMap.get(key) instanceof JsonArray) {
                List<Object> list = ((JsonArray) jsonMap.get(key)).getElements();
                System.out.println("[");
                for (Object s : list) {
                    ((JsonObject)(s)).print();

                }
                System.out.println();
                System.out.println("]");
            } else if (jsonMap.get(key) instanceof JsonObject) {
                ((JsonObject) jsonMap.get(key)).print();
            } else if (jsonMap.get(key) instanceof String) {
                System.out.println(jsonMap.get(key) + ",");
            }
        }
        System.out.println("},");
    }
}
