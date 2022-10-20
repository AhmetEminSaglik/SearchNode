package org.aes.searchnode.dataaccess.abstracts;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.concretes.PriorityChar;

public interface ReachableNextWayDirection {
    DataResult<SearchNode> getNextWayOfChar(PriorityChar pc);
    DataResult<SearchNode> createNextWayChar(PriorityChar pc);
    DataResult<Integer> size();



}
