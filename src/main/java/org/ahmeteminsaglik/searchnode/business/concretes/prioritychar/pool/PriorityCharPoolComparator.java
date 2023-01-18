package org.ahmeteminsaglik.searchnode.business.concretes.prioritychar.pool;

import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;

import java.util.Comparator;

public class PriorityCharPoolComparator implements Comparator<PriorityChar> {

    @Override
    public int compare(PriorityChar o1, PriorityChar o2) {
        System.err.println("Burada islemler  gozden gecirilecektir. Veri ekleme asamasi veya cekme asamasinda hangisi daha hizli olucaksa ona gore sorting yeri degisekctir.");
        if (o1.getValue() < o2.getValue())
            return -1;
        return 1;
    }
}
