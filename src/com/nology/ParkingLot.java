package com.nology;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot implements IParkingLot {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private int compactSpaces;
    private int regularSpaces;
    private int compactSpacesUsed;
    private int regularSpacesUsed;

    public ParkingLot(int compactSpaces, int regularSpaces) {
        this.compactSpaces = compactSpaces;
        this.regularSpaces = regularSpaces;
    }

    public ArrayList<Vehicle> getVehicles() {
        List<String> vehicleTypes = this.vehicles.stream().map(vehicle -> vehicle.getType()).collect(Collectors.toList());
        System.out.println(vehicleTypes);
        return vehicles;
    }

    @Override
    public int totalSpaces() {
        int output = compactSpaces + regularSpaces;
        System.out.println("Total spaces: " + output);
        System.out.println("Compact spaces: " + compactSpaces);
        System.out.println("Regular spaces: " + regularSpaces);
        return output;
    }

    @Override
    public int remainingSpaces() {
        int remainingCompact = compactSpaces - this.compactSpacesUsed;
        int remainingRegular = regularSpaces - this.regularSpacesUsed;
        int output = remainingCompact + remainingRegular;
        System.out.println("Total remaining spaces: " + output);
        System.out.println("Remaining compact spaces: " + remainingCompact);
        System.out.println("Remaining regular spaces: " + remainingRegular);
        return output;
    }

    @Override
    public boolean isFull() {
        boolean output = this.isCompactFull() && this.isRegularFull();
        System.out.println("Is the space full " + output);
        return output;
    }

    @Override
    public boolean isEmpty() {
        boolean output = compactSpacesUsed == 0 && this.regularSpacesUsed == 0;
        System.out.println("Is the space empty " + output);
        return output;
    }

    @Override
    public boolean isCompactFull() {
        boolean output = compactSpaces == this.compactSpacesUsed;
        return output;
    }

    @Override
    public boolean isRegularFull() {
        boolean output = regularSpaces == this.regularSpacesUsed;
        return output;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        if (this.addSpaceBySize(vehicle.getSize())) {
            System.out.println("Adding vehicle " + vehicle.getType());
            this.vehicles.add(vehicle);
            this.getVehicles();
        };
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        System.out.println("Removing vehicle " + vehicle.getType());
        this.vehicles.remove(vehicle);
        this.removeSpaceBySize(vehicle.getSize());
        this.getVehicles();
    }

    @Override
    public ArrayList<String> spacesByVehicle(Vehicle vehicleToCheck) {
        List<String> vehicleSpacesList = this.vehicles.stream().filter(vehicle -> vehicle == vehicleToCheck).map(vehicle -> vehicle.getType()).collect(Collectors.toList());
        ArrayList<String> vehicleSpaces = new ArrayList<>(vehicleSpacesList);
        System.out.println("The list of spaces by vehicle is " + vehicleSpaces.toArray().length + ": " + vehicleSpaces);
        return vehicleSpaces;
    }

    private boolean addSpaceBySize(int size) {
        if (!this.isCompactFull()) {
            if (size == 1 || size == 2) {
                this.compactSpacesUsed = this.compactSpacesUsed + 1;
                return true;
            }
        }

        if (this.isCompactFull() && !this.isRegularFull()) {
            if (size == 1 || size == 2) {
                this.regularSpacesUsed = this.regularSpacesUsed + 1;
                return true;
            }
        }

        if (!this.isRegularFull()) {
            if (size == 3 && (this.regularSpaces - this.regularSpacesUsed >= 3)  ) {
                this.regularSpacesUsed = this.regularSpacesUsed + 3;
                return true;
            }
        }

        System.out.println("Sorry parking lot full, go away!");
        return false;
    }

    private void removeSpaceBySize(int size) {
        if (size == 1 || size == 2 && this.regularSpacesUsed >= 1) {
            this.regularSpacesUsed -= 1;
            return;
        }

        if (size == 1 || size == 2 && this.compactSpacesUsed >= 1) {
            this.compactSpacesUsed -= 1;
            return;
        }

        if (size == 3 && (this.regularSpacesUsed >= 3)  ) {
            this.regularSpacesUsed -= 3;
            return;
        }

        System.out.println("Sorry parking lot is empty, can't remove the car");
    }
}
