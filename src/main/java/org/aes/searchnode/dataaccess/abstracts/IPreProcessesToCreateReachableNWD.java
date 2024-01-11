package org.aes.searchnode.dataaccess.abstracts;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.PriorityChar;

public interface IPreProcessesToCreateReachableNWD <T>{
    DataResult<SearchNode<T>> createNextWayPriorityChar(PriorityChar pc) throws Exception;
}
