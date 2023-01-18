package org.ahmeteminsaglik.searchnode.dataaccess.comparator;

import org.ahmeteminsaglik.searchnode.entities.concretes.NextWayDirectionRequiredData;

import java.util.Comparator;

public class ComparatorNextWayDirectionRequiredData implements Comparator<NextWayDirectionRequiredData> {

    @Override
    public int compare(NextWayDirectionRequiredData o1, NextWayDirectionRequiredData o2) {
//        return new Order().getComparator(OrderBy.ASC)
//        return   Order.getComparator(ConfigOrderBy.getOrderByNextWayDirectionRequiredData()) .
//                compare(o1.getPriorityChar().getValue(), o2.getPriorityChar().getValue());
        return o1.getPriorityChar().getValue() > o2.getPriorityChar().getValue() ? 1 : -1;
    }

}
