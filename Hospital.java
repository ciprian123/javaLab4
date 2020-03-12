package com.lab4.ciprianursulean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hospital implements Comparable<Hospital> {
    private String name;
    private int capacity;
    private List<Resident> residentList;

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        residentList = new ArrayList<>();
    }

    public Hospital(String name, int capacity, Resident ... residentList) {
        this(name, capacity);
        if (residentList.length <= capacity) {
            Collections.addAll(this.residentList, residentList);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Resident> getResidentList() {
        return residentList;
    }

    public void setResidentList(List<Resident> residentList) {
        this.residentList = residentList;
    }

    public void addResident(Resident resident) {
        if (residentList.size() + 1 <= capacity) {
            residentList.add(resident);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hospital: ");
        stringBuilder.append(getName());
        stringBuilder.append("\n");
        stringBuilder.append("Capacity: ");
        stringBuilder.append(getCapacity());
        stringBuilder.append("\n");
        for (Resident resident : residentList) {
            stringBuilder.append("Resident: ");
            stringBuilder.append(resident.getName());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Hospital)) {
            return false;
        }
        Hospital hospital = (Hospital)obj;
        return this.getName().equals(hospital.getName()) && this.getCapacity() == hospital.getCapacity();
    }

    @Override
    public int compareTo(Hospital hospital) {
        int comparator = this.getName().compareTo(hospital.getName());
        if (comparator == 0) {
            return this.getCapacity() - hospital.getCapacity();
        }
        return comparator;
    }
}
