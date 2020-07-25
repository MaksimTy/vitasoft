package org.example.vitasoft.domain;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Comparator;

public class StringsSorter {


    private String[] strings ;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    private String jsonObjectKey = "Коллекция";

    public StringsSorter(String[] strings) {
        this.strings = strings;
    }

    public StringsSorter() {
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonObject() {
        this.jsonObject = new JSONObject();
        this.jsonArray = new JSONArray();

        for (String string : strings
        ) {
            String item = String.format("(%d): %s", string.length(), string);
            jsonArray.put(item);
        }
        jsonObject.put(this.jsonObjectKey, jsonArray);
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }









    public void sort() {
        Arrays.sort(this.strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length = o1.length() - o2.length();
                return length != 0 ? length : o1.compareTo(o2);
            }
        });
    }
}
