package org.aes.searchnode.dataaccess.abstracts;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
//import org.aes.searchnode.entities.concretes.DataSearchNodeWithChar;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.Queue;

public interface ReachableNextWayDirection {
    DataResult<SearchNode> getNextWayOfChar(PriorityChar pc) throws Exception;

    DataResult<SearchNode> addPossibilityNWDNodeToReachableNWD(SearchNode connectionStartSearchNode,Queue<NextWayDirectionRequiredData> queue);

    int size();


}
