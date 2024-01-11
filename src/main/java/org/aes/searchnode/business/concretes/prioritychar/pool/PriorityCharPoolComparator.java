package org.aes.searchnode.business.concretes.prioritychar.pool;

import org.aes.searchnode.entities.PriorityChar;

import java.util.Comparator;

public class PriorityCharPoolComparator implements Comparator<PriorityChar> {

    @Override
    public int compare(PriorityChar o1, PriorityChar o2) {
        if (o1.getValue() < o2.getValue())
            return -1;
        return 1;
    }
}
