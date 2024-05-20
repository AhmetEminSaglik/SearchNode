package org.aes.searchnode.dataaccess.comparator;

import org.aes.searchnode.entities.NextWayDirectionRequiredData;

import java.util.Comparator;

public class ComparatorNextWayDirectionRequiredData implements Comparator<NextWayDirectionRequiredData> {
    public ComparatorNextWayDirectionRequiredData() {

    }

    @Override
    public int compare(NextWayDirectionRequiredData o1, NextWayDirectionRequiredData o2) {
        return o1.getPriorityChar().getValue() > o2.getPriorityChar().getValue() ? 1 : -1;
    }

}
