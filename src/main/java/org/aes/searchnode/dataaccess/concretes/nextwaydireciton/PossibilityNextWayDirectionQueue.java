package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.entities.concretes.DataSearchNodeWithChar;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PossibilityNextWayDirectionQueue implements ReachableNextWayDirection {
    private SearchNode searchNodeConnectionStart;

    public PossibilityNextWayDirectionQueue(SearchNode searchNodeConnectionStart) {
        this.searchNodeConnectionStart = searchNodeConnectionStart;
    }

    ReachableNextWayDirection reachableNextWayDirection = ConfigReachableNextWayDirection.getReachableNextWayDirectionObject();
    Queue<DataSearchNodeWithChar> queue = new LinkedList<>();

    @Override
    public DataResult<SearchNode> getNextWayOfChar(PriorityChar pc) {
        DataResult<SearchNode> dataResult = reachableNextWayDirection.getNextWayOfChar(pc);
        if (dataResult != null) {
            return dataResult;
        } else {
            createNextWayChar(pc);
        }
        return null;
    }

    @Override
    public DataResult<SearchNode> createNextWayChar(PriorityChar pc) {
        queue.add(new DataSearchNodeWithChar(pc, new SearchNode()));
        return null;
    }

    public SearchNode getSearchNodeConnectionStart() {
        return searchNodeConnectionStart;
    }
}
