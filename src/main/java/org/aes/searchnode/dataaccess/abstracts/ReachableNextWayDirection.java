package org.aes.searchnode.dataaccess.abstracts;

import org.aes.searchnode.SearchNode;

public interface ReachableNextWayDirection {
    SearchNode getNextWayOfChar(char c);

    SearchNode createNextWayChar(char c);


}
