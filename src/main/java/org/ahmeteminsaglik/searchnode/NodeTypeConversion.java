package org.ahmeteminsaglik.searchnode;

import java.util.ArrayList;
import java.util.List;

public class NodeTypeConversion {
    public String convertTypeStringTobeReadyForProcessingData(int integer) {
        return Integer.toString(integer);
    }

    public List<String> convertTypeStringTobeReadyForProcessingData(List<Integer> integerList) {

        List<String> list = new ArrayList<>();
        for (Integer tmp : integerList)
            list.add(convertTypeStringTobeReadyForProcessingData(tmp));
        return list;
    }
}
