package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.SuccessDataResult;
import org.aes.searchnode.core.utilities.SuccessResult;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.entities.concretes.DataSearchNodeWithChar;
import org.aes.searchnode.entities.concretes.NodeData;
import org.aes.searchnode.entities.concretes.PriorityChar;

import javax.swing.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PossibilityNextWayDirectionQueue implements ReachableNextWayDirection {
    private StringBuilder currentLocationStringAddress = new StringBuilder();
    Object data;
    private SearchNode searchNodeConnectionStart;
    private ReachableNextWayDirection reachableNextWayDirection = ConfigReachableNextWayDirection.getReachableNextWayDirectionObject();
    private Queue<DataSearchNodeWithChar> queue = new LinkedList<>();

    public PossibilityNextWayDirectionQueue(SearchNode searchNodeConnectionStart, Object data) {
        this.searchNodeConnectionStart = searchNodeConnectionStart;
        this.data = data;
    }

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
        SearchNode searchNode = new SearchNode();

        createCurrentLocationStringAddress(searchNode, pc);
        setSearchNodeDeep(searchNode);
        fillNodeData(searchNode);
        queue.add(new DataSearchNodeWithChar(pc, searchNode));
        return new SuccessDataResult<SearchNode>(searchNode, "Searchnode is created in for " + getClass().getSimpleName());
    }

    void createCurrentLocationStringAddress(SearchNode searchNode, PriorityChar pc) {
        currentLocationStringAddress.append(searchNode.getNodeData().getLocationStringAddress()).append(pc.getChar());
    }

    void setSearchNodeDeep(SearchNode searchNode) {
        int deep = currentLocationStringAddress.length();
        searchNode.setDeep(deep);

    }

    void fillNodeData(SearchNode searchNode) {
        NodeData nodeData = searchNode.getNodeData();
        nodeData.setLocationStringAddress(currentLocationStringAddress.toString());
        nodeData.increaseNextDirectionsExistingTotalDataNumber();
        addDataToDataNode(nodeData);
//        nodeData.set
    }

    void addDataToDataNode(NodeData nodeData) {
        JOptionPane.showMessageDialog(null, "data to string : " + data.toString());

        if (nodeData.getLocationStringAddress().equals(data.toString())) {
            nodeData.setData(data);
        }
    }

    public SearchNode getSearchNodeConnectionStart() {
        return searchNodeConnectionStart;
    }
}
