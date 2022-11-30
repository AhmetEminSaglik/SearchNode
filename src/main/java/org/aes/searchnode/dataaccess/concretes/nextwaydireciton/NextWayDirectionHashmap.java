package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.core.utilities.SuccessDataResult;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.HashMap;
import java.util.List;

public class NextWayDirectionHashmap<T> implements ReachableNextWayDirection <T>{
    HashMap<Character, SearchNode> hashMap = new HashMap<>();

    @Override
    public DataResult<SearchNode<T>> getNextSearchNodeWayOfChar(PriorityChar pc) {
        SearchNode<T> searchNode = hashMap.get(pc.getChar());
        if (searchNode != null)
            return new SuccessDataResult<>(searchNode, "Data is retreived");
        return new ErrorDataResult<>("Data is not found in " + getClass().getSimpleName());
    }

    @Override
    public DataResult<SearchNode<T>> addPossibilityNWDNodeToReachableNWD(PriorityChar pc, SearchNode<T> searchNode) {
        hashMap.put(pc.getChar(), searchNode);
        return new SuccessDataResult<>("SearchNode is added to hashmap");
    }

    @Override
    public List<NextWayDirectionRequiredData<T>> getAllDataOfSearchNode() {
        return null;
    }

   /* @Override
    public List<> printAllDataOfSearchNode() {
        for (Character tmp : hashMap.keySet()) {
            System.out.println(tmp + " : " + hashMap.keySet());
        }
        System.out.println("Hashmap is over");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
    }*/

    @Override
    public int size() {
        return hashMap.size();
    }
}
