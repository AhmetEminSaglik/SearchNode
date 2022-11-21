package org.aes.searchnode.testing;

import java.lang.reflect.Array;
import java.util.*;

public class TestingArrayList implements TestingObjects {

    List<String> arrayList = new ArrayList<>();
    TimeCalculation timeCalculation = new TimeCalculation();

    @Override
    public void addData(List<String> list) {
        timeCalculation.start();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i));
        }
//        arrayList.addAll(list); // this is faster about
        timeCalculation.stop();
        timeCalculation.printElapsedTime();
        printElapsedTime("  > Arraylist - Data is added  : ", timeCalculation);
    }

    @Override
    public void sort() {
        timeCalculation.start();
        Collections.sort(arrayList);
        timeCalculation.stop();
        printElapsedTime("ArrayList data is sorted", timeCalculation);
    }

    @Override
    public void search(List<String> list) {
        int foundTextNumber = 0;
        int missingTextNumber = 0;
        timeCalculation.start();
        for (String tmpTxt : list) {
            int result = Arrays.binarySearch(arrayList.toArray(), tmpTxt);
            if (result >= 0) {
                foundTextNumber++;
            } else {
                missingTextNumber++;
            }

        }
        timeCalculation.stop();

        System.out.println("found Text Number : " + foundTextNumber);
        System.out.println("missing  Text Number : " + missingTextNumber);

        printElapsedTime("ArrayList data searched all given data", timeCalculation);
    }
}
