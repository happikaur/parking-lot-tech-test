package com.nology;

public class Vehicle {
    private String type;
    private int size;

    public Vehicle(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
