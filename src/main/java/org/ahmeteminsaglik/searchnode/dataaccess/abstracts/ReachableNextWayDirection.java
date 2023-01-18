package org.ahmeteminsaglik.searchnode.dataaccess.abstracts;

import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;
import org.ahmeteminsaglik.searchnode.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;

import java.util.List;

public interface ReachableNextWayDirection<T> {
    DataResult<SearchNode<T>> getNextSearchNodeWayOfChar(PriorityChar pc);

    DataResult<SearchNode<T>> addPossibilityNWDNodeToReachableNWD(PriorityChar pc,/*SearchNode connectionStartSearchNode,*/ SearchNode<T> searchNode);

    List<NextWayDirectionRequiredData<T>> getAllDataOfSearchNode();

//    List<T> getAll(SearchNode<T> searchNode);

    /**
     * return SearchNode Available Next Way Directions size in stored .
     */
    int size();


}
