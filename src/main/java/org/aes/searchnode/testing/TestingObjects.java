package org.aes.searchnode.testing;

import java.util.List;

public interface TestingObjects {
    void addData(List<String> list);

    void sort();

    void search(List<String> list);

    default void printElapsedTime(String text,TimeCalculation timeCalculation) {
        System.out.print(text+" :");timeCalculation.printElapsedTime();
    }
}
