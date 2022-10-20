package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.core.utilities.SuccessDataResult;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.PriorityChar;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class NextWayDirectionList implements ReachableNextWayDirection {
    List<NextWayDirectionRequiredData> list = new ArrayList<>();

    @Override
    public DataResult<SearchNode> getNextWayOfChar(PriorityChar pc) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPriorityChar().getChar() == pc.getChar())
                return new SuccessDataResult<>(list.get(i).getSearchNode(), "Data is retreived");
        }
        return new ErrorDataResult<SearchNode>("Data is not found in " + getClass().getSimpleName());
    }

    @Override
    public DataResult<SearchNode> addPossibilityNWDNodeToReachableNWD(SearchNode connectionStartSearchNode, Queue<NextWayDirectionRequiredData> queue) {

        return null;
    }



/*
    @Override
    public DataResult<SearchNode> addPossibilityNWDNodeToReachableNWD(PriorityChar pc) {
        return null;
    }
*/


//    @Override
//    public DataResult<SearchNode> createNextWayChar(PriorityChar pc) {
//        return null;
//    }

    @Override
    public int size() {
        return list.size();
    }
}
