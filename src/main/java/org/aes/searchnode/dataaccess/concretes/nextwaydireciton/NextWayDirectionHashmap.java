package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;

import java.util.HashMap;

public class NextWayDirectionHashmap implements ReachableNextWayDirection {
    HashMap<Character, SearchNode> hashMap = new HashMap();

    @Override
    public SearchNode getNextWayOfChar(char c) {
        return hashMap.get(c);
    }

    @Override
    public SearchNode createNextWayChar(char c) {
        SearchNode searchNode= new SearchNode();
        hashMap.put(c,searchNode);
        return searchNode;
    }
}
