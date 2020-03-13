package com.lab4.ciprianursulean;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemGenerator {
    private int noOfInstances;
    private List<Problem> randomProblemList;
    private static final int NO_OF_RANDOM_DATA = 10;

    public ProblemGenerator(int noOfInstances) {
        this.noOfInstances = noOfInstances;
        randomProblemList = new ArrayList<>();
    }

    public void setNoOfInstances(int noOfInstances) {
        this.noOfInstances = noOfInstances;
    }

    public List<Problem> getRandomProblemList() {
        return randomProblemList;
    }

    /**
     *  Generez un numar random de spitale fiecare cu nume random si capacitate random
     *  Generez un numar random de rezidenti fiecare cu nume random si capacitate random
     */
    public void generateRandomProblem() {
        List<Hospital> someHospitals = new ArrayList<>();
        List<Resident> someResidents = new ArrayList<>();
        Faker faker = new Faker();
        int hospitalCounter = (int)(Math.random() * NO_OF_RANDOM_DATA + 1);
        int residentCounter = (int)(Math.random() * NO_OF_RANDOM_DATA + 1);
        for (int i = 0; i < hospitalCounter; ++i) {
            Hospital randomHospital = new Hospital(faker.name().fullName(), (int)(Math.random() * NO_OF_RANDOM_DATA + 1));
            someHospitals.add(randomHospital);
        }
        for (int i = 0; i < residentCounter; ++i) {
            Resident randomResident = new Resident(faker.name().fullName());
            Set<Integer> indexSet = new HashSet<>();
            for (int j = 0; j < hospitalCounter; ++j) {
                int index = (int)(Math.random() * NO_OF_RANDOM_DATA + 1) % hospitalCounter;
                indexSet.add(index);
            }
            for (Integer index : indexSet) {
                randomResident.addHospital(someHospitals.get(index));
            }
            someResidents.add(randomResident);
        }
        randomProblemList.add(new Problem(someHospitals, someResidents));
    }

    public void generateRandomProblems() {
        for (int i = 0; i < noOfInstances; ++i) {
            generateRandomProblem();
        }
    }

    public void printRandomProblems() {
        for (Problem problem : randomProblemList) {
            System.out.println(problem);
        }
    }
}
