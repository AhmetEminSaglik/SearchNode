package org.ahmeteminsaglik.searchnode.entities.concretes;

import java.util.ArrayList;
import java.util.List;

public class PriorityCharPool {
    private static List<PriorityChar> pcList = new ArrayList<>();

    public static List<PriorityChar> getList() {
//        if (pcList.size() > 1) { // burada sortlamak yerine  veri ekledikten sonra veya veri alirken sortlanabilir.
//            pcList.sort(new PriorityCharPoolComparator());
//        }
        return pcList;
    }
}

