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

    public Problem(List<Hospital> someHospitals, List<Resident> someResidents) {
        this.someHospitals = someHospitals;
        this.someResidents = someResidents;
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

    /**
     *
     * @return false if resident prefers another hospital, and the hospital prefers the resident, true otherwise
     */
    public boolean isStableMatching() {
//        for w in women:
//        for m in [men w would prefer over current_partner(w)]:
//        if m prefers w to current_partner(m) return false
//
//        return true
        for (Hospital hospital : someHospitals) {
            for (Resident resident : hospital.getResidentList()) {

            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("****************************************************\n");
        for (Resident resident : someResidents) {
            stringBuilder.append(resident);
            stringBuilder.append("\n");
        }
        for (Hospital hospital : someHospitals) {
            stringBuilder.append(hospital);
            stringBuilder.append("\n");
        }
        stringBuilder.append("**********************************************************\n");
        return stringBuilder.toString();
    }
}
