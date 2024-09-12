package org.ahmeteminsaglik.searchnode.dataaccess.concretes.nextwaydireciton;

import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;
import org.ahmeteminsaglik.searchnode.core.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.core.utilities.ErrorDataResult;
import org.ahmeteminsaglik.searchnode.core.utilities.Result;
import org.ahmeteminsaglik.searchnode.core.utilities.SuccessDataResult;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.ahmeteminsaglik.searchnode.entities.NextWayDirectionRequiredData;
import org.ahmeteminsaglik.searchnode.entities.PriorityChar;

import java.util.HashMap;
import java.util.List;

public class NextWayDirectionHashmap<T> implements ReachableNextWayDirection<T> {
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

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public Result clearList() {
        return null;
    }

    @Override
    public Result clearPc(PriorityChar pc) {
        return null;
    }
}
