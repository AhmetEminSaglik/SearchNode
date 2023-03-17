package org.aes.searchnode.business.concretes.searchnode;

import lombok.Data;
import org.aes.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.business.concretes.prioritychar.PriorityCharManager;
import org.aes.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.aes.searchnode.core.utilities.*;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.PossibilityNextWayDirection;
import org.aes.searchnode.entities.concretes.DataInfo;
import org.aes.searchnode.entities.concretes.NodeData;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchNode<T> implements SearchNodeService<T> {

    private ReachableNextWayDirection<T> reachableNWD = ConfigReachableNextWayDirection.getReachableNextWayDirectionObject();
    private NodeData<T> nodeData = new NodeData<>();
    private PossibilityNextWayDirection<T> pNWDQueue = null;
    private PriorityCharService pcService = new PriorityCharManager();
//    private List<SearchNode<T>> snListToIncreaseNWDTV = new ArrayList<>();

    SearchNodeService<T> searchNodeService = new SearchNodeManagement(this);

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
/*
    public void setReachableNWD(ReachableNextWayDirection<T> reachableNWD) {
        this.reachableNWD = reachableNWD;
    }

    public NodeData<T> getNodeData() {
        return nodeData;
    }

    public void setNodeData(NodeData<T> nodeData) {
        this.nodeData = nodeData;
    }

    public PossibilityNextWayDirection<T> getpNWDQueue() {
        return pNWDQueue;
    }

    public void setPNWDQueue(PossibilityNextWayDirection<T> pNWDQueue) {
        this.pNWDQueue = pNWDQueue;
    }

    public PriorityCharService getPcService() {
        return pcService;
    }

    public void setPcService(PriorityCharService pcService) {
        this.pcService = pcService;
    }

    public List<SearchNode<T>> getSnListToIncreaseNWDTV() {
        return sNListToIncreaseNWDTV;
    }

    public void setSNListToIncreaseNWDTV(List<SearchNode<T>> sNListToIncreaseNWDTV) {
        this.sNListToIncreaseNWDTV = sNListToIncreaseNWDTV;
    }*/

//    public List<SearchNode<T>> getSnListToIncreaseNWDTV() {
//        return snListToIncreaseNWDTV;
//    }
//
//    public void setSNListToIncreaseNWDTV(List<SearchNode<T>> snListToIncreaseNWDTV) {
//        this.snListToIncreaseNWDTV = snListToIncreaseNWDTV;
//    }
    @Override
    public String toString() {
        return "SearchNode{" +
                "nodeData=" + nodeData +
                '}';
    }
}