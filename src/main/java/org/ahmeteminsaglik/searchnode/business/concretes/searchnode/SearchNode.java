package org.ahmeteminsaglik.searchnode.business.concretes.searchnode;

import org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.ahmeteminsaglik.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.ahmeteminsaglik.searchnode.core.utilities.Result;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.ahmeteminsaglik.searchnode.dataaccess.concretes.nextwaydireciton.PossibilityNextWayDirection;
import org.ahmeteminsaglik.searchnode.entities.DataInfo;
import org.ahmeteminsaglik.searchnode.entities.NodeData;
import org.ahmeteminsaglik.searchnode.entities.NodeDataService;
import org.ahmeteminsaglik.searchnode.entities.PriorityChar;

import java.util.ArrayList;
import java.util.List;

public class SearchNode<T> implements SearchNodeService<T> {

    SearchNodeService<T> searchNodeService = new SearchNodeManagement<>(this);
    private ReachableNextWayDirection<T> reachableNWD = new ConfigReachableNextWayDirection<T>().getReachableNextWayDirectionObject();
    private NodeData<T> nodeData = new NodeData<>();
    private PossibilityNextWayDirection<T> pNWDQueue = null;
    private List<SearchNode<T>> sNListToIncreaseNWDTV = new ArrayList<>();

    @Override
    public NodeDataService<T> search(String text) {
        return searchNodeService.search(text);
    }

    @Override
    public NodeDataService<T> getExplanationOf(String text) {
        return searchNodeService.getExplanationOf(text);
    }

    @Override
    public Result add(T t) {
        return searchNodeService.add(t);
    }

    @Override
    public Result add(T t, String explanation) {
        return searchNodeService.add(t, explanation);
    }

    @Override
    public Result add(T t, List<String> expList) {
        return searchNodeService.add(t, expList);
    }

    @Override
    public Result addAll(List<T> list) {
        return searchNodeService.addAll(list);
    }

    @Override
    public Result update(T t, String oldExp, String newExp) {
        return searchNodeService.update(t, oldExp, newExp);
    }

    @Override
    public Result update(T t, String oldExp, List<String> expList) {
        return searchNodeService.update(t, oldExp, expList);
    }

    @Override
    public Result update(T t, List<String> expList) {
        return searchNodeService.update(t, expList);
    }


    @Override
    public List<DataInfo<T>> getAll() {
        return searchNodeService.getAll();
    }

    @Override
    public List<DataInfo<T>> getAllReverse() {
        return searchNodeService.getAllReverse();
    }

    @Override
    public List<DataInfo<T>> getAllStartWith(String text) {
        return searchNodeService.getAllStartWith(text);
    }

    @Override
    public int getTotalItemNumber() {
        return searchNodeService.getTotalItemNumber();
    }


    public ReachableNextWayDirection<T> getReachableNWD() {
        return reachableNWD;
    }

    public void setReachableNWD(ReachableNextWayDirection<T> reachableNWD) {
        this.reachableNWD = reachableNWD;
    }

    public NodeData<T> getNodeData() {
        return nodeData;
    }

    public void setNodeData(NodeData<T> nodeData) {
        this.nodeData = nodeData;
    }

    @Override
    public Result remove(T t) {
        return searchNodeService.remove(t);
    }

    @Override
    public Result removeAll(List<T> list) {
        return searchNodeService.removeAll(list);
    }

    public PossibilityNextWayDirection<T> getpNWDQueue() {
        return pNWDQueue;
    }

    public void setpNWDQueue(PossibilityNextWayDirection<T> pNWDQueue) {
        this.pNWDQueue = pNWDQueue;
    }

    public List<SearchNode<T>> getsNListToIncreaseNWDTV() {
        return sNListToIncreaseNWDTV;
    }

    public void setsNListToIncreaseNWDTV(List<SearchNode<T>> sNListToIncreaseNWDTV) {
        this.sNListToIncreaseNWDTV = sNListToIncreaseNWDTV;
    }


    public Result updatePriorityChar(char c, char nextToThisChar) {
        return searchNodeService.updatePriorityChar(c, nextToThisChar);
    }

    @Override
    public NodeData<T> searchNodeData(String text) {
        return searchNodeService.searchNodeData(text);
    }

    @Override
    public List<NodeData<T>> getAllNodeData(String text) {
        return searchNodeService.getAllNodeData(text);
    }

    @Override
    public Result updatePriorityChar(List<Character> cList, char nextToThisChar) {
        return searchNodeService.updatePriorityChar(cList, nextToThisChar);
    }

    @Override
    public Result resetPriorityChar(char c) {
        return searchNodeService.resetPriorityChar(c);
    }

    @Override
    public Result resetAllPriorityChars() {
        return searchNodeService.resetAllPriorityChars();
    }

    @Override
    public String toString() {
        return "SearchNode{" +
                "nodeData=" + nodeData +
                '}';
    }

    @Override
    public PriorityChar getPc(char c) {
        return searchNodeService.getPc(c);
    }

    @Override
    public List<PriorityChar> getAllPc() {
        return searchNodeService.getAllPc();
    }

    @Override
    public PriorityChar getNextPc(char c) {
        return searchNodeService.getNextPc(c);
    }
}
