package jsonParser;

import exceptions.JsonParseException;

import java.util.ArrayList;
import java.util.List;

public class JsonArray {
        private final ArrayList<Object> arrayList;

        public JsonArray() {
                this.arrayList = new ArrayList<>();
        }

        int parseArray(List<String> list, int index) throws JsonParseException {
                int length = list.size();
                ++index;
                boolean b = true;

                while (index < length && !list.get(index).equals("]")) {
                        if (b) {
                                if (list.get(index).equals("{")) {
                                        JsonObject nestedJsonObject = new JsonObject();
                                        index = nestedJsonObject.parseObject(list, index);
                                        this.add(nestedJsonObject);
                                } else if (list.get(index).equals("[")) {
                                        JsonArray nestedJsonArray = new JsonArray();
                                        index = nestedJsonArray.parseArray(list, index);
                                        this.add(nestedJsonArray);
                                } else {
                                        this.add(list.get(index));
                                        ++index;
                                }
                                b = false;
                        } else {
                                if (!list.get(index).equals(",")) {
                                        throw new JsonParseException("Missing \",\" in array");
                                }
                                b = true;
                        }
                        ++index;
                }
                return index;
        }

        public void add(Object obj) {
                arrayList.add(obj);
        }

        public List<Object> getElements() {
                return arrayList;
        }
}
