package org.ahmeteminsaglik.searchnode.entities;

import org.ahmeteminsaglik.searchnode.business.concretes.prioritychar.pool.PriorityCharPoolComparator;

import java.util.ArrayList;
import java.util.List;

public class PriorityCharPool {
    private static final List<PriorityChar> pcList = new ArrayList<>();

    public static List<PriorityChar> getList() {
        if (pcList.size() > 1) {
            pcList.sort(new PriorityCharPoolComparator());
        }
        return pcList;
    }
}

