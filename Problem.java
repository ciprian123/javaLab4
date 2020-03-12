package com.lab4.ciprianursulean;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    List<Hospital> someHospitals;
    List<Resident> someResidents;
    List<Element> stableMatching;

    Problem() {
        someHospitals = new ArrayList<>();
        someResidents = new ArrayList<>();
        stableMatching = new ArrayList<>();
    }

    public List<Hospital> getSomeHospitals() {
        return someHospitals;
    }

    public void setSomeHospitals(List<Hospital> someHospitals) {
        this.someHospitals = someHospitals;
    }

    public List<Resident> getSomeResidents() {
        return someResidents;
    }

    public void setSomeResidents(List<Resident> someResidents) {
        this.someResidents = someResidents;
    }

    public List<Element> getStableMatching() {
        return stableMatching;
    }

    public void solve() {

    }
}
