package com.lab4.ciprianursulean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Resident {
    private String name;
    private List<Hospital> hospitalList;

    public Resident(String name) {
        this.name = name;
        hospitalList = new ArrayList<>();
    }

    public Resident(String name, Hospital ... hospitalList) {
        this(name);
        Collections.addAll(this.hospitalList, hospitalList);
        Arrays.stream(hospitalList).forEach(item -> item.addResident(this));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(Hospital ... hospitalList) {
        Collections.addAll(this.hospitalList, hospitalList);
        Arrays.stream(hospitalList).forEach(item -> item.addResident(this));
    }

    public void addHospital(Hospital hospital) {
        this.hospitalList.add(hospital);
        hospital.addResident(this);
    }

    public int compareByName(Resident resident1, Resident resident2) {
        return resident1.getName().compareTo(resident2.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Resident)) {
            return false;
        }
        Resident resident = (Resident)obj;
        return this.getName().compareTo(resident.getName()) == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rezident: ");
        stringBuilder.append("\"");
        stringBuilder.append(getName());
        stringBuilder.append("\"");
        stringBuilder.append("\n");
        stringBuilder.append("Lista spitale aplicate: ");
        for (Hospital hospital : hospitalList) {
            stringBuilder.append("\"");
            stringBuilder.append(hospital.getName());
            stringBuilder.append("\"");
            stringBuilder.append(" ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
