package org.aes.searchnode.testing.abstracts;

import org.aes.searchnode.testing.concretes.TimeCalculation;

import java.util.List;

public interface TestingDataStructorFeature {
    void addData(List<String> list);

    void sort();

    void search(List<String> list);

    default void printElapsedTime(String text, TimeCalculation timeCalculation) {
        System.out.print(text+" : ");timeCalculation.printElapsedTime();
    }
}
