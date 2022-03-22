package com.nology;

public class Main {

    public static void main(String[] args) {
	/*
    Design a parking lot using object-oriented principles

    Goals:
    - Your solution should be in Java - if you would like to use another language, please let the interviewer know.
    - Boilerplate is provided. Feel free to change the code as you see fit

    Assumptions:
    - The parking lot can hold motorcycles, cars and vans
    - The parking lot has motorcycle spots, car spots and large spots
    - A motorcycle can park in any spot
    - A car can park in a single compact spot, or a regular spot
    - A van can park, but it will take up 3 regular spots
    - These are just a few assumptions. Feel free to ask your interviewer about more assumptions as needed

    Here are a few methods that you should be able to run:
    - Tell us how many spots are remaining
    - Tell us how many total spots are in the parking lot
    - Tell us when the parking lot is full
    - Tell us when the parking lot is empty
    - Tell us when certain spots are full e.g. when all motorcycle spots are taken
    - Tell us how many spots vans are taking up

    Hey candidate! Welcome to your interview. I'll start off by giving you a Solution class. To run the code at
    any time, please hit the run button located in the top left corner.
    */

        Motorcycle motorcycle = new Motorcycle("Motorcycle",1);
        Car car = new Car("Car", 2);
        Van van = new Van("Van", 3);

        ParkingLot parking = new ParkingLot(50, 50);

        parking.totalSpaces();
        parking.remainingSpaces();
        parking.isEmpty();
        parking.isFull();
        parking.isRegularFull();
        parking.isCompactFull();

        System.out.println("===================================================");

        parking.addVehicle(van);
        parking.addVehicle(van);
        parking.addVehicle(van);
        parking.addVehicle(car);
        parking.spacesByVehicle(van);
        parking.totalSpaces();
        parking.remainingSpaces();

        System.out.println("===================================================");

        parking.removeVehicle(van);
        parking.totalSpaces();
        parking.remainingSpaces();
    }
}

