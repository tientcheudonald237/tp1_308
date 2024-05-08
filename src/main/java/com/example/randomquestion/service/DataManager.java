package com.example.randomquestion.service;

public class DataManager {
    private static final DataManager instance = new DataManager();
    private String sharedData;

    private DataManager() {
    }

    public static DataManager getInstance() {
        return instance;
    }

    public String getSharedData() {
        return sharedData;
    }

    public void setSharedData(String sharedData) {
        this.sharedData = sharedData;
    }
}
