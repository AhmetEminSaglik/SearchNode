package org.aes.searchnode.dataaccess.abstracts;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.concretes.PriorityChar;

public interface IPreProcessesToCreateReachableNWD {
    DataResult<SearchNode<Object>> createNextWayChar(PriorityChar pc) throws Exception;
}
