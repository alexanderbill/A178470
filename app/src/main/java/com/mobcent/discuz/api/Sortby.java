package com.mobcent.discuz.api;

/**
 * Created by sun on 2016/9/10.
 */

public enum Sortby {
    ALL("all"),
    ESSENCE("essence"),
    TOP("top"),
    NEW("new");

    private String name;

    Sortby(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
