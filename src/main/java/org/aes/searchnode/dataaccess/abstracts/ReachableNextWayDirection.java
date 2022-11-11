package org.aes.searchnode.dataaccess.abstracts;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.concretes.PriorityChar;

public interface ReachableNextWayDirection {
    DataResult<SearchNode> getNextWayOfChar(PriorityChar pc);

    DataResult<SearchNode> addPossibilityNWDNodeToReachableNWD(PriorityChar pc,/*SearchNode connectionStartSearchNode,*/ SearchNode searchNode);

    void printAllDataOfSearchNode();

    /**
     * return SearchNode Available Next Way Directions size in stored .
     * */
    int size();


}
