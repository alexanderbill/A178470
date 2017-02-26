package com.mobcent.common;

import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by sun on 2016/8/23.
 */

public class JsonConverter {
    static Gson gson = new Gson();
    public static <T> T format(String json, Class<T> type){

        return  gson.fromJson(json,type);
    }

    public static String toString(Object obj) {
        return gson.toJson(obj);
    }

    public static String toStringBackslash(Object obj) {
        return gson.toJson(obj).replaceAll("\"","\\\\\"");
    }

}
