package org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.pool;

import org.ahmeteminsaglik.searchnode.core.utilities.Result;
import org.ahmeteminsaglik.searchnode.entities.NextWayDirectionRequiredData;
import org.ahmeteminsaglik.searchnode.entities.PriorityChar;

import java.util.Comparator;
import java.util.List;

public interface PriorityCharPoolDAO {
    PriorityChar getPriorityChar(char c);

    List<PriorityChar> getAll();

    PriorityChar getNextPriorityChar(char c);


    List<PriorityChar> updatePriorityCharList(List<Character> characterList, char nextToThisChar);

    void sort(Comparator<PriorityChar> comparator);

    Result removePriorityChar(char c);

    Result removeAll();

    PriorityChar updatePriorityChar(char c, char nextToThisChar);

    void addToListToBeNotifedWhenPriorityCharIsUpdated(NextWayDirectionRequiredData<?> nextWayDirectionRequiredData);


}
