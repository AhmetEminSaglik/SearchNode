package org.aes.searchnode.testing;

import java.util.HashMap;
import java.util.List;

public class TestingHashmap implements TestingObjects {
    HashMap<String, String> hashMap = new HashMap();
    TimeCalculation timeCalculation = new TimeCalculation();

    @Override
    public void addData(List<String> list) {
        timeCalculation.start();
        list.forEach(e -> {
            hashMap.put(e, e);
        });
        timeCalculation.stop();
        printElapsedTime("  > Hashmap > data is ADDED : ", timeCalculation);
    }

    @Override
    public void sort() {
        printElapsedTime("  > Hashmap > data is sorted : ", timeCalculation);
    }

    @Override
    public void search(List<String> list) {
        int foundTextNumber = 0;
        int missingTextNumber = 0;
        timeCalculation.start();
        for (String tmpTxt : list) {
            String result = hashMap.get(tmpTxt);
            if (result != null) {
                foundTextNumber++;
            } else {
                missingTextNumber++;
            }

        }
        timeCalculation.stop();
        System.out.println("found Text Number : " + foundTextNumber);
        System.out.println("missing  Text Number : " + missingTextNumber);

        printElapsedTime("  > ArrayList >  data searched all given data : ", timeCalculation);
    }
}
