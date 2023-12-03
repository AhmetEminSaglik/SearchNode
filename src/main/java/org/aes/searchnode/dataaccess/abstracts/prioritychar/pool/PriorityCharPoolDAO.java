package org.aes.searchnode.dataaccess.abstracts.prioritychar.pool;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.Comparator;
import java.util.List;

public interface PriorityCharPoolDAO {
    PriorityChar getPriorityChar(char c);

    DataResult<List<PriorityChar>> updatePriorityCharList(List<Character> characterList, char nextToThisChar);

    void sort(Comparator<PriorityChar> comparator);

    DataResult removePriorityChar(char c);

    Result removeAll();
//    void deletePriorityChar(PriorityChar pc);

    DataResult<PriorityChar> updatePriorityChar(char c, char nextToThisChar);

    void addToListToBeNotifedWhenPriorityCharIsUpdated(NextWayDirectionRequiredData<?> nextWayDirectionRequiredData);


}
