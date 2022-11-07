package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.aes.searchnode.core.utilities.*;
import org.aes.searchnode.dataaccess.abstracts.IPreProcessesToCreateReachableNWD;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.NodeData;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.Queue;

public class PossibilityNextWayDirection implements IPreProcessesToCreateReachableNWD {
    private StringBuilder currentLocationStringAddress = new StringBuilder();
    Object data;

    private SearchNode firstSearchNodeToConnectRootSearchNode = null;
    private SearchNode searchNodeAddingProcess;
    private PriorityChar pcForFirstSNToConnectRootSN = null;

    public PossibilityNextWayDirection(Object data, SearchNode movedLastSearchNodeConnection/*, PriorityChar pcForNextSearchNodeConnection*/) {
        this.data = data;
        this.searchNodeAddingProcess = movedLastSearchNodeConnection;
    }
    @Override
    public DataResult<SearchNode> createNextWayChar(PriorityChar pc) throws Exception /*throws Exception*/ {
        if (pcForFirstSNToConnectRootSN == null) {
            pcForFirstSNToConnectRootSN = pc;
        }

        SearchNode newSearchNode = new SearchNode();

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

    void initializeSearchNodeFundamentals(SearchNode searchNode) {
        searchNode.setNodeData(new NodeData());
    }

    void createCurrentLocationStringAddress(PriorityChar pc/*, SearchNode searchNode*/) {
        if (currentLocationStringAddress.toString().equals("")) {
            currentLocationStringAddress.append(searchNodeAddingProcess.getNodeData().getLocationStringAddress());
        }
        currentLocationStringAddress.append(pc.getChar());
    }

    void setSearchNodeDeep(SearchNode searchNode) {
        int deep = currentLocationStringAddress.length();
        searchNode.getNodeData().setDeep(deep);
    }

    void fillNodeData(SearchNode searchNode) throws Exception {
        NodeData nodeData = searchNode.getNodeData();
        nodeData.setLocationStringAddress(currentLocationStringAddress.toString());
        Result result = addDataToDataNode(nodeData);
        if (!result.isSuccess()) {
            nodeData.increaseNextDirectionsExistingTotalDataNumber();
        }
    }

    Result addDataToDataNode(NodeData nodeData) throws Exception {

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
