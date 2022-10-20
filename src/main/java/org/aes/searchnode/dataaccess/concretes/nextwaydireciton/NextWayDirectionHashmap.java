package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.core.utilities.SuccessDataResult;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.HashMap;

public class NextWayDirectionHashmap implements ReachableNextWayDirection {
    HashMap<Character, SearchNode> hashMap = new HashMap<>();

    @Override
    public DataResult<SearchNode> getNextWayOfChar(PriorityChar pc) {
        SearchNode searchNode = hashMap.get(pc.getChar());
        if (searchNode != null)
            return new SuccessDataResult<>(searchNode, "Data is retreived");
        return new ErrorDataResult<SearchNode>("Data is not found in " + getClass().getSimpleName());
    }

    @Override
    public DataResult<SearchNode> createNextWayChar(PriorityChar pc) {
//        SearchNode searchNode= new SearchNode();
//        hashMap.put(c,searchNode);
        return null;
    }

    @Override
    public DataResult<Integer> size() {
        return new SuccessDataResult<>(hashMap.size());
    }
}
