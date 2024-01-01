package org.aes.searchnode.testing.concretes;

import org.aes.searchnode.core.utilities.ReadableStringFormat;
import org.aes.searchnode.testing.abstracts.CalculateDataStructorComplexity;
import org.aes.searchnode.testing.abstracts.TestingDataStructorFeature;

import java.util.*;

public class TestingArrayList implements TestingDataStructorFeature, CalculateDataStructorComplexity {

    List<String> arrayList = new ArrayList<>();
    List<String> poolList = new ArrayList<>();
    List<String> searchList = new ArrayList<>();
    TimeCalculation timeCalculation = new TimeCalculation();

    public TestingArrayList() {
    }

    public TestingArrayList(List<String> poolList, List<String> searchList) {
        this.poolList = poolList;
        this.searchList = searchList;
    }

    @Override
    public void addData(List<String> list) {
        System.out.println("[AL] Word Pool Size : " + ReadableStringFormat.getReadableValueIntToString(list.size()));
        timeCalculation.start();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i));
        }
        timeCalculation.stop();
        printElapsedTime("[AL] Arraylist > Add Process", timeCalculation);
    }

    @Override
    public void sort() {
        timeCalculation.start();
        Collections.sort(arrayList);
        timeCalculation.stop();
        printElapsedTime("[AL] ArrayList > Sort Process", timeCalculation);
    }

    @Override
    public void search(List<String> list) {
        System.out.println("[AL] Search Data Size : " + ReadableStringFormat.getReadableValueIntToString(list.size()));

        int foundTextNumber = 0;
        int missingTextNumber = 0;
        timeCalculation.start();

        Object[] arr = arrayList.toArray();
//        Arrays.binarySearch();
        for (String tmpTxt : list) {
            int result = Arrays.binarySearch(arr, tmpTxt);
            if (result >= 0) {
                foundTextNumber++;
            } else {
                missingTextNumber++;
            }

        }
        timeCalculation.stop();

        System.out.println("[AL] Found Data Number : " + ReadableStringFormat.getReadableValueIntToString(foundTextNumber));
        System.out.println("[AL] Missing Data Number : " + ReadableStringFormat.getReadableValueIntToString(missingTextNumber));

        printElapsedTime("[AL] ArrayList > Search Process", timeCalculation);
        System.out.println("----------------------------------------------------------------------------------------");
    }

    @Override
    public void run() {
        addData(poolList);
        sort();
        search(searchList);
    }
}
