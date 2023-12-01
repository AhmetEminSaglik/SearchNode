package org.aes.searchnode.dataaccess.abstracts.prioritychar.pool;

import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.Comparator;
import java.util.List;

public interface PriorityCharPoolDAO {
    PriorityChar getPriorityChar(char c);

    PriorityChar updatePriorityCharList(List<Character> characterList, char nextToThisChar);

    void sort(Comparator<PriorityChar> comparator);

    void deletePriorityChar(char c);

    void updatePriorityChar(char c, char nextToThisChar);


}
