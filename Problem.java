package com.lab4.ciprianursulean;

import java.util.*;

public class Problem {
    private List<Hospital> someHospitals;
    private List<Resident> someResidents;
    private List<Element> someMatching;

    Problem() {
        someHospitals = new ArrayList<>();
        someResidents = new ArrayList<>();
        someMatching = new ArrayList<>();
    }

    public List<Hospital> getSomeHospitals() {
        return someHospitals;
    }

    public void setSomeHospitals(Hospital ... someHospitals) {
        Collections.addAll(this.someHospitals, someHospitals);
    }

    public List<Resident> getSomeResidents() {
        return someResidents;
    }

    public void setSomeResidents(Resident ... someResidents) {
        Collections.addAll(this.someResidents, someResidents);
    }

    public List<Element> getSomeMatching() {
        return someMatching;
    }

    public void solve() {
        Set<Resident> residentSet = new HashSet<>();
        for (Hospital hospital : someHospitals) {
            int currentCapacity = hospital.getCapacity();
            for (Resident resident : someResidents) {
                if (!residentSet.contains(resident) && currentCapacity > 0) {
                    currentCapacity--;
                    someMatching.add(new Element(resident, hospital));
                    residentSet.add(resident);
                }
            }
        }
    }
}
