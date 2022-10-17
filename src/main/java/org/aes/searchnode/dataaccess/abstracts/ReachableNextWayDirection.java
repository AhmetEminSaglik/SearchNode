package org.aes.searchnode.dataaccess.abstracts;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;

public interface ReachableNextWayDirection {
    DataResult<SearchNode> getNextWayOfChar(char c);

    DataResult<SearchNode> createNextWayChar(char c);


}
