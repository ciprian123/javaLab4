package com.lab4.ciprianursulean;

public class Element {
    private Resident resident;
    private Hospital hospital;

    public Element(Resident resident, Hospital hospital) {
        this.resident = resident;
        this.hospital = hospital;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
