package org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.pool;

import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;

import java.util.Comparator;

public interface PriorityCharPoolDAO {
    PriorityChar getPriorityChar(char c);
    void sort(Comparator<PriorityChar> comparator);
    void deletePriorityChar(char c);
    void updatePriorityChar(char c);


}
