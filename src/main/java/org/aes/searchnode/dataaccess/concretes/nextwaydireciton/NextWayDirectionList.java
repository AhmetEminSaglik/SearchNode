package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.*;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.comparator.ComparatorNextWayDirectionRequiredData;
import org.aes.searchnode.entities.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.PriorityChar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NextWayDirectionList<T> implements ReachableNextWayDirection<T> {
    private static final ComparatorNextWayDirectionRequiredData comparatorNextWayDirectionRequiredData = new ComparatorNextWayDirectionRequiredData();
    private final List<NextWayDirectionRequiredData<T>> list = new ArrayList<>();

    @Override
    public DataResult<SearchNode<T>> getNextSearchNodeWayOfChar(PriorityChar pc) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPriorityChar().getChar() == pc.getChar()) {
                return new SuccessDataResult<>(list.get(i).getSearchNode(), "Data is retrieved");
            }
        }
        return new ErrorDataResult<>("Data is not found in " + getClass().getSimpleName());
    }

    @Override
    public DataResult<SearchNode<T>> addPossibilityNWDNodeToReachableNWD(PriorityChar pc, SearchNode<T> searchNode) {
        list.add(new NextWayDirectionRequiredData(pc, searchNode));
        return new SuccessDataResult<>("--> SearchNode is added to List");
    }

    @Override
    public List<NextWayDirectionRequiredData<T>> getAllDataOfSearchNode() {
        Collections.sort(list, new ComparatorNextWayDirectionRequiredData());
        return new ArrayList<>(list);
    }

    @Override
    public int size() {
        System.out.println(list.size());
        return list.size();
    }

    @Override
    public Result clearList() {
        list.clear();
        return new SuccessResult("All data is removed");
    }


    @Override
    public Result clearPc(PriorityChar pc) {
        String msg = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPriorityChar().getChar() == pc.getChar()) {
                list.remove(i);
                msg = pc + " Data is removed";
                return new SuccessDataResult<>(msg);
            }
        }
        msg = pc + "Data is not removed because is not found.";
        return new ErrorResult(msg);
    }

    public List<NextWayDirectionRequiredData<T>> getNextWayDirectionRequiredDataList() {
        return new ArrayList<>(list);
    }
}
