package org.aes.searchnode.testing;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ReadableStringFormat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TestingHashMap implements TestingObjects {
    Map<String, String> map = new HashMap<>();
    TimeCalculation timeCalculation = new TimeCalculation();

    @Override
    public void addData(List<String> list) {
        timeCalculation.start();
        System.out.println("put ONCE hashmap size : "+ ReadableStringFormat.getReadableValueIntToString(map.size()));
        for (String tmp : list) {
            map.put(tmp,tmp);
        }System.out.println("put SONRA hashmap size : "+ ReadableStringFormat.getReadableValueIntToString(map.size()));
        timeCalculation.stop();
        printElapsedTime("  > HashMap > data is ADDED : ", timeCalculation);
    }

    @Override
    public void sort() {
        timeCalculation.start();
        timeCalculation.stop();
        printElapsedTime("  > HashMap > data is SORT : ", timeCalculation);
    }

    @Override
    public void search(List<String> list) {
        int foundTextNumber = 0;
        int missingTextNumber = 0;
        timeCalculation.start();
        for (String tmpText : list) {
            String foundValue = map.get(tmpText);
            if (foundValue.length()>0) {
                foundTextNumber++;
            } else {
                missingTextNumber++;
            }
        }
        timeCalculation.stop();
        System.out.println("found Text Number : " + ReadableStringFormat.getReadableValueIntToString(foundTextNumber));
        System.out.println("missing  Text Number : " +  ReadableStringFormat.getReadableValueIntToString(missingTextNumber));
        System.out.println("list size IN SEARCHNODE : " +  ReadableStringFormat.getReadableValueIntToString(list.size()));

        printElapsedTime("  > HASHMAP >  SEARCHED ", timeCalculation);
        System.out.println("HashmapSize : "+ ReadableStringFormat.getReadableValueIntToString(map.size()));

    }
}
