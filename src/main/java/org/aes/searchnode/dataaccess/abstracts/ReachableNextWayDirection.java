package org.aes.searchnode.dataaccess.abstracts;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.List;

public interface ReachableNextWayDirection<T> {
    DataResult<SearchNode<T>> getNextSearchNodeWayOfChar(PriorityChar pc);

    DataResult<SearchNode<T>> addPossibilityNWDNodeToReachableNWD(PriorityChar pc,/*SearchNode connectionStartSearchNode,*/ SearchNode<T> searchNode);

    List<NextWayDirectionRequiredData<T>> getAllDataOfSearchNode();

    /**
     * return SearchNode Available Next Way Directions size in stored .
     */
    int size();

}
