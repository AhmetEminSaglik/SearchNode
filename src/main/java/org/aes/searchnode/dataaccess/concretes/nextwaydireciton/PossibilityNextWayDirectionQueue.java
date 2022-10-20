package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.SuccessDataResult;
import org.aes.searchnode.dataaccess.abstracts.IPreProcessesToCreateReachableNWD;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.NodeData;
import org.aes.searchnode.entities.concretes.PriorityChar;
import java.util.LinkedList;
import java.util.Queue;

public class PossibilityNextWayDirectionQueue implements IPreProcessesToCreateReachableNWD {
    private StringBuilder currentLocationStringAddress = new StringBuilder();
    Object data;
    private SearchNode searchNodeConnectionStart;
    private ReachableNextWayDirection reachableNextWayDirection = ConfigReachableNextWayDirection.getReachableNextWayDirectionObject();
    private Queue<NextWayDirectionRequiredData> queue = new LinkedList<>();

    public PossibilityNextWayDirectionQueue(SearchNode searchNodeConnectionStart, Object data) {
        this.searchNodeConnectionStart = searchNodeConnectionStart;
        this.data = data;
    }

  /*  @Override
    public DataResult<SearchNode> getNextWayOfChar(PriorityChar pc) throws Exception {
        DataResult<SearchNode> dataResult = reachableNextWayDirection.getNextWayOfChar(pc);
        if (dataResult != null) {
            return dataResult;
        } else {
            createNextWayChar(pc);
        }
        return null;
    }*/

    @Override
    public DataResult<SearchNode> createNextWayChar(PriorityChar pc) throws Exception /*throws Exception*/ {
        SearchNode searchNode = new SearchNode();

        createCurrentLocationStringAddress(pc);
//        initializeSearchNodeFundamentals();
        setSearchNodeDeep(searchNode);
        fillNodeData(searchNode);
        queue.add(new NextWayDirectionRequiredData(pc, searchNode));
        return new SuccessDataResult<>(searchNode, "Searchnode is created in for " + getClass().getSimpleName());
    }

    @Override
    public Queue<NextWayDirectionRequiredData> getQueueSearchNodeToAddReachableNWD() {
        return queue;
    }

   /* @Override
    public int size() {
        return queue.size();
    }*/

    void initializeSearchNodeFundamentals(SearchNode searchNode) {
        searchNode.setNodeData(new NodeData());
    }

    void createCurrentLocationStringAddress(PriorityChar pc) {
//        JOptionPane.showMessageDialog(null,"aappendlenecek lcoation address :"+searchNodeConnectionStart.getNodeData().getLocationStringAddress());
        currentLocationStringAddress.append(searchNodeConnectionStart.getNodeData().getLocationStringAddress()).append(pc.getChar());
    }

    void setSearchNodeDeep(SearchNode searchNode) {
        int deep = currentLocationStringAddress.length();
        searchNode.setDeep(deep);
//        System.out.println("ISLEM YAPILAN NODE DERINLIK : "+deep);

    }

    void fillNodeData(SearchNode searchNode) throws Exception {
        NodeData nodeData = searchNode.getNodeData();
        nodeData.setLocationStringAddress(currentLocationStringAddress.toString());
        nodeData.increaseNextDirectionsExistingTotalDataNumber();
        addDataToDataNode(nodeData);
//        nodeData.set
    }

    void addDataToDataNode(NodeData nodeData) throws Exception {
//        JOptionPane.showMessageDialog(null, "data to string : " + data.toString());

        if (nodeData.getLocationStringAddress().equals(data.toString())) {
            if (nodeData.getData() == null) {
                nodeData.setData(data);
            }
            throw new Exception("Data is not null\n --> given data : " + data + "\n -->  registered data : " + nodeData.getData());
        }
    }

    public SearchNode getSearchNodeConnectionStart() {
        return searchNodeConnectionStart;
    }
}
