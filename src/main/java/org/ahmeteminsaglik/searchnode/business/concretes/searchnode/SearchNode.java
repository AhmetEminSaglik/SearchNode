package org.ahmeteminsaglik.searchnode.business.concretes.searchnode;

import lombok.Data;
import org.ahmeteminsaglik.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.ahmeteminsaglik.searchnode.business.abstracts.prioritychar.UpdatePriorityCharService;
import org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.ahmeteminsaglik.searchnode.business.concretes.prioritychar.PriorityCharManager;
import org.ahmeteminsaglik.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.ahmeteminsaglik.searchnode.utilities.*;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.ahmeteminsaglik.searchnode.dataaccess.concretes.nextwaydireciton.PossibilityNextWayDirection;
import org.ahmeteminsaglik.searchnode.entities.concretes.DataInfo;
import org.ahmeteminsaglik.searchnode.entities.concretes.NodeData;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;
import java.util.List;

@Data
public class SearchNode<T> implements SearchNodeService<T>, UpdatePriorityCharService {

    private ReachableNextWayDirection<T> reachableNWD = ConfigReachableNextWayDirection.getReachableNextWayDirectionObject();
    private NodeData<T> nodeData = new NodeData<>();
    private PossibilityNextWayDirection<T> pNWDQueue = null;
    private PriorityCharService pcService = new PriorityCharManager();
//    private List<SearchNode<T>> snListToIncreaseNWDTV = new ArrayList<>();

    SearchNodeService<T> searchNodeService = new SearchNodeManagement<>(this);

    @Override
    public DataResult<DataInfo<T>> search(String text) {
        return searchNodeService.search(text);
    }

    @Override
    public Result add(T t) {
        return searchNodeService.add(t);
    }

    @Override
    public Result addAll(List<T> list) {
        return searchNodeService.addAll(list);
    }


    @Override
    public DataResult<List<T>> getAll() {
        return searchNodeService.getAll();
    }

    @Override
    public DataResult<List<T>> getAllReverse() {
        return searchNodeService.getAllReverse();
    }

    @Override
    public DataResult<List<T>> getAllStartWith(String text) {
        return searchNodeService.getAllStartWith(text);
    }

    @Override
    public long getTotalItemNumber() {
        return searchNodeService.getTotalItemNumber();
    }


    public ReachableNextWayDirection<T> getReachableNWD() {
        return reachableNWD;
    }

    @Override
    public Result reset(char c) {
        return null;
    }

    @Override
    public DataResult<PriorityChar> update(char c) {
        return null;
    }

    @Override
    public String toString() {
        return "SearchNode{" +
                "nodeData=" + nodeData +
                '}';
    }

}
