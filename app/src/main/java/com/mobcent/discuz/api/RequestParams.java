package com.mobcent.discuz.api;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sun on 2016/8/21.
 */

public class RequestParams {
    public final JSONObject json = new JSONObject();
    private boolean useCache;
    private int timeout;

    public void add(String name, Object value) {
        try {
            json.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("json err param :" + name + "," + value + ";" + e.toString());
        }
    }
    public String getJsonStr(){
        return json.toString();
    }

    public boolean isUseCache() {
        return useCache;
    }

    public void setUseCache(boolean cache) {
        this.useCache = cache;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
