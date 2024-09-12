package org.ahmeteminsaglik.searchnode.dataaccess.concretes.nextwaydireciton;

import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;
import org.ahmeteminsaglik.searchnode.core.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.core.utilities.ErrorResult;
import org.ahmeteminsaglik.searchnode.core.utilities.Result;
import org.ahmeteminsaglik.searchnode.core.utilities.SuccessDataResult;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.IPreProcessesToCreateReachableNWD;
import org.ahmeteminsaglik.searchnode.entities.NodeData;
import org.ahmeteminsaglik.searchnode.entities.PriorityChar;

public class PossibilityNextWayDirection<T> implements IPreProcessesToCreateReachableNWD<T> {
    private final StringBuilder currentLocationAddress = new StringBuilder();
    T data;
    String explanation;
    private SearchNode<T> firstSearchNodeToConnectRootSearchNode = null;
    private SearchNode<T> searchNodeAddingProcess;
    private PriorityChar pcForFirstSNToConnectRootSN = null;

    public PossibilityNextWayDirection(T data, String explanation, SearchNode<T> movedLastSearchNodeConnection) {
        this.data = data;
        this.explanation = explanation;
        this.searchNodeAddingProcess = movedLastSearchNodeConnection;

    }

    @Override
    public DataResult<SearchNode<T>> createNextWayPriorityChar(PriorityChar pc) throws Exception /*throws Exception*/ {
        if (pcForFirstSNToConnectRootSN == null) {
            pcForFirstSNToConnectRootSN = pc;
        }

        SearchNode<T> newSearchNode = new SearchNode<T>();

        createCurrentLocationAddress(pc/*, searchNodeAddingProcess*/);
        setSearchNodeDeep(newSearchNode);
        fillNodeData(newSearchNode);

        if (firstSearchNodeToConnectRootSearchNode == null) {
            firstSearchNodeToConnectRootSearchNode = newSearchNode;
            searchNodeAddingProcess = newSearchNode;
        } else {
            searchNodeAddingProcess.getReachableNWD().addPossibilityNWDNodeToReachableNWD(pc, newSearchNode);
            searchNodeAddingProcess = newSearchNode;
        }
        return new SuccessDataResult<>(newSearchNode, "Searchnode is created in for " + getClass().getSimpleName());
    }

    void initializeSearchNodeFundamentals(SearchNode<T> searchNode) {
        searchNode.setNodeData(new NodeData<T>());
    }

    void createCurrentLocationAddress(PriorityChar pc/*, SearchNode searchNode*/) {
        if (currentLocationAddress.toString().equals("")) {
            currentLocationAddress.append(searchNodeAddingProcess.getNodeData().getLocationAddress());
        }
        currentLocationAddress.append(pc.getChar());
    }

    void setSearchNodeDeep(SearchNode<T> searchNode) {
        int deep = currentLocationAddress.length();
        searchNode.getNodeData().setDeep(deep);
    }

    void fillNodeData(SearchNode<T> searchNode) throws Exception {
        NodeData<T> nodeData = searchNode.getNodeData();
        nodeData.setLocationAddress(currentLocationAddress.toString());
        Result result = addDataToDataNode(nodeData);
        if (!result.isSuccess() && !currentLocationAddress.toString().equals(data.toString())) {
            nodeData.increaseNextWayDirectionTotalValue();
        }
    }

    Result addDataToDataNode(NodeData<T> nodeData) throws Exception {

        if (nodeData.getLocationAddress().equals(data.toString())) {
            nodeData.addData(data, explanation);
        }
        return new ErrorResult("Data is not added");
    }

    public PriorityChar getPcForFirstSNToConnectRootSN() {
        return pcForFirstSNToConnectRootSN;
    }

    public SearchNode getFirstSearchNodeToConnectRootSearchNode() {
        return firstSearchNodeToConnectRootSearchNode;
    }
}
