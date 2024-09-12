package org.ahmeteminsaglik.searchnode.dataaccess.abstracts;

import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;
import org.ahmeteminsaglik.searchnode.core.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.core.utilities.Result;
import org.ahmeteminsaglik.searchnode.entities.NextWayDirectionRequiredData;
import org.ahmeteminsaglik.searchnode.entities.PriorityChar;

import java.util.List;

public interface ReachableNextWayDirection<T> {
    DataResult<SearchNode<T>> getNextSearchNodeWayOfChar(PriorityChar pc);

    DataResult<SearchNode<T>> addPossibilityNWDNodeToReachableNWD(PriorityChar pc,/*SearchNode connectionStartSearchNode,*/ SearchNode<T> searchNode);

    List<NextWayDirectionRequiredData<T>> getAllDataOfSearchNode();

    /**
     * return SearchNode Available Next Way Directions size in stored .
     */
    int size();

    Result clearList();

    Result clearPc(PriorityChar pc);
}
