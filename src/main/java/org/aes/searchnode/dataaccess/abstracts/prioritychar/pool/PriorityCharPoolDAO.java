package org.aes.searchnode.dataaccess.abstracts.prioritychar.pool;

import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.Comparator;

public interface PriorityCharPoolDAO {
    PriorityChar getPriorityChar(char c);
    void sort(Comparator<PriorityChar> comparator);

}
