package core;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class NestedJsonHandler {


    public static void parseObject(JSONObject json, String key) {
        System.out.println("Key : "+key+" has value : "+json.get(key));
    }
    public static void getKey(JSONObject json, String key) {
        boolean exists = json.has(key);
        Iterator<?> keys;
        String nextKeys;
        if (!exists) {
            keys = json.keys();
            while (keys.hasNext()) {
                nextKeys = (String) keys.next();
                try {
                    if (json.get(nextKeys) instanceof JSONObject) {
                        if (exists == false) {
                            getKey(json.getJSONObject(nextKeys), key);
                        }
                    } else if (json.get(nextKeys) instanceof JSONArray) {
                        JSONArray jsonarray = json.getJSONArray(nextKeys);
                        for (int i = 0; i < jsonarray.length(); i++) {
                            String jsonarrayString = jsonarray.get(i).toString();
                            JSONObject innerJSOn = new JSONObject(jsonarrayString);
                            if (exists == false) {
                                getKey(innerJSOn, key);
                            }
                        }
                    }
                } catch (Exception e) {
                }}
        } else {
            parseObject(json, key);
        }}
   /* public static void main(String[] args) {
        String inputJson = "{\"fid\":\"0001\",\"ftype\":\"donut\",\"fname\":\"Cake\",\"fppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\",\"type\":\"Chocolate\"},{\"id\":\"1003\",\"type\":\"Blueberry\"},{\"id\":\"1004\",\"type\":\"Devil's Food\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\"},{\"id\":\"5007\",\"type\":\"Powdered Sugar\"},{\"id\":\"5006\",\"type\":\"Chocolate with Sprinkles\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]}";
        JSONObject inputJSONOBject = new JSONObject(inputJson);
        getKey(inputJSONOBject, "id");
    }*/



}
