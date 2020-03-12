package com.lab4.ciprianursulean;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var residents = IntStream.rangeClosed(0, 3)
                                 .mapToObj(i -> new Resident("Resident" + i) )
                                 .toArray(Resident[]::new);

        var hospitals = IntStream.rangeClosed(0, 2)
                                 .mapToObj(i -> new Hospital("Hospital" + i, i == 2 ? 2 : i % 2 + 1))
                                 .toArray(Hospital[]::new);

        // adaug preferintele rezidentilor
        residents[0].setHospitalList(hospitals[0], hospitals[1], hospitals[2]);
        residents[1].setHospitalList(hospitals[0], hospitals[1], hospitals[2]);
        residents[2].setHospitalList(hospitals[0], hospitals[1]);
        residents[3].setHospitalList(hospitals[0], hospitals[2]);

        // List<Resident> residentArrayList = Arrays.stream(residents).sorted(Comparator.comparing(Resident::getName)).collect(Collectors.toList());
        List<Resident> residentList = new ArrayList<>();
        Collections.addAll(residentList, residents);
        residentList.sort(Comparator.comparing(Resident::getName));

        // print residentList
        // residentList.forEach(System.out::println);

        Set<Hospital> hospitalSet = new TreeSet<>();
        Collections.addAll(hospitalSet, hospitals);

        // print hospitalsSet
        // hospitalSet.forEach(System.out::println);

        var residentPreferences1 = new HashMap<>();
        residentPreferences1.put(residents[0], Arrays.asList(hospitals[0], hospitals[1], hospitals[2]));
        residentPreferences1.put(residents[1], Arrays.asList(hospitals[0], hospitals[1], hospitals[2]));
        residentPreferences1.put(residents[2], Arrays.asList(hospitals[0], hospitals[1]));
        residentPreferences1.put(residents[3], Arrays.asList(hospitals[0], hospitals[2]));

        var residentPreferences2 = new LinkedHashMap<>(residentPreferences1);

        residentPreferences1.keySet().forEach(key -> System.out.println(key + " " + residentPreferences1.get(key)));
        System.out.println();
        residentPreferences2.keySet().forEach(key -> System.out.println(key + " " + residentPreferences2.get(key)));

        // printing the residents who accept H0 and H2
//        residentList.stream()
//                    .filter(res -> residentPreferences1.get(res).contains(hospitals[0]))
//                    .filter(res -> residentPreferences1.get(res).contains(hospitals[2]))
//                    .forEach(System.out::println);

        System.out.println();
        // printing hospitals with resident residents[0] on the top
        hospitalSet.stream()
                   .filter(hos -> hos.getResidentList().size() > 0 && hos.getResidentList().get(0).equals(residents[0]))
                   .forEach(System.out::println);
    }
}
