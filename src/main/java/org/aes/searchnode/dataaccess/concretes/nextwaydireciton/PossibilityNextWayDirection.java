package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.*;
import org.aes.searchnode.dataaccess.abstracts.IPreProcessesToCreateReachableNWD;
import org.aes.searchnode.entities.concretes.NodeData;
import org.aes.searchnode.entities.concretes.PriorityChar;

public class PossibilityNextWayDirection<T> implements IPreProcessesToCreateReachableNWD<T> {
    private StringBuilder currentLocationStringAddress = new StringBuilder();
    T data;

    private SearchNode<T> firstSearchNodeToConnectRootSearchNode = null;
    private SearchNode<T> searchNodeAddingProcess;
    private PriorityChar pcForFirstSNToConnectRootSN = null;

    public PossibilityNextWayDirection(T data, SearchNode<T> movedLastSearchNodeConnection/*, PriorityChar pcForNextSearchNodeConnection*/) {
        this.data = data;
        this.searchNodeAddingProcess = movedLastSearchNodeConnection;
    }

    @Override
    public DataResult<SearchNode<T>> createNextWayPriorityChar(PriorityChar pc) throws Exception /*throws Exception*/ {
        if (pcForFirstSNToConnectRootSN == null) {
            pcForFirstSNToConnectRootSN = pc;
        }

        SearchNode<T> newSearchNode = new SearchNode<T>();

        createCurrentLocationStringAddress(pc/*, searchNodeAddingProcess*/);
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

    void createCurrentLocationStringAddress(PriorityChar pc/*, SearchNode searchNode*/) {
        if (currentLocationStringAddress.toString().equals("")) {
            currentLocationStringAddress.append(searchNodeAddingProcess.getNodeData().getLocationStringAddress());
        }
        currentLocationStringAddress.append(pc.getChar());
    }

    void setSearchNodeDeep(SearchNode<T> searchNode) {
        int deep = currentLocationStringAddress.length();
        searchNode.getNodeData().setDeep(deep);
    }

    void fillNodeData(SearchNode<T> searchNode) throws Exception {
        NodeData<T> nodeData = searchNode.getNodeData();
        nodeData.setLocationStringAddress(currentLocationStringAddress.toString());
        Result result = addDataToDataNode(nodeData);
        if (!result.isSuccess()) {
            nodeData.increaseNextDirectionsExistingTotalDataNumber();
        }
    }

    Result addDataToDataNode(NodeData<T> nodeData) throws Exception {

        if (nodeData.getLocationStringAddress().equals(data.toString())) {

          /*  if (nodeData.getData() == null) {
                nodeData.setData(data);
                return new SuccessResult();
            }*/
            nodeData.addData(data);
//            throw new Exception("Data is not null\n --> given data : " + data + "\n -->  registered data : " + nodeData.getData());
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
