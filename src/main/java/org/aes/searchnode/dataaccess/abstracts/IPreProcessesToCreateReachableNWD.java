package org.aes.searchnode.dataaccess.abstracts;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.Queue;

public interface IPreProcessesToCreateReachableNWD {
    DataResult<SearchNode> createNextWayChar(PriorityChar pc) throws Exception;

    Queue<NextWayDirectionRequiredData> getQueueSearchNodeToAddReachableNWD();

}
