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
    //    static int index = 0;
    private StringBuilder currentLocationStringAddress = new StringBuilder();
    Object data;

    private SearchNode firstSearchNodeToConnectRootSearchNode = null;
    private SearchNode searchNodeAddingProcess;
    private PriorityChar pcForFirstSNToConnectRootSN = null;

//    SearchNode movedLastSearchNodeConnection = null;

    public PossibilityNextWayDirection(Object data, SearchNode movedLastSearchNodeConnection/*, PriorityChar pcForNextSearchNodeConnection*/) {
        this.data = data;
//        this.firstSearchNodeToConnectRootSearchNode = movedLastSearchNodeConnection;
        this.searchNodeAddingProcess = movedLastSearchNodeConnection;
    }

    @Override
    public DataResult<SearchNode> createNextWayChar(PriorityChar pc) throws Exception /*throws Exception*/ {
        if (pcForFirstSNToConnectRootSN == null) {
            pcForFirstSNToConnectRootSN = pc;
        }
//        System.out.println("gelen pc : "+pc.getChar());
        /*
         * create SearchNode
         * fillNode
         * if firstSN...Connection is null th */

        SearchNode newSearchNode = new SearchNode();
/*//        searchNodeAddingProcess=newSearchNode;
//        if (searchNodeAddingProcess != null) {
//            System.out.println("iceri gelen pc : "+pc.getChar());
//        System.out.println("AAAAAAAAA");

//        searchNodeAddingProcess.getReachableNWD().addPossibilityNWDNodeToReachableNWD(pc, newSearchNode);
//        System.out.println("BBBBBBBB");

//            System.out.println(searchNode.toString());
//        System.out.println(" searchNodeAddingProcess : " + searchNodeAddingProcess);
//        System.out.println("SearchNode's connections : " + newSearchNode.getNodeData().getLocationStringAddress());
//        searchNodeAddingProcess.getReachableNWD().printAllDataOfSearchNode();
//        System.exit(0);
           StringBuilder test = new StringBuilder("ayser");
            PriorityCharService pcService = new PriorityCharManager();

            DataResult<PriorityChar> drPriorityChar = pcService.getPriorityChar(test.charAt(index));
            PriorityChar pc2 = drPriorityChar.getData();System.out.println("AAA");
            DataResult<SearchNode> dataResult=searchNode.getReachableNWD().getNextWayOfChar(pc2);
            System.out.println("Data Result : "+dataResult.getData().toString());
            index++;*//*
//        }*/


        createCurrentLocationStringAddress(pc/*, searchNodeAddingProcess*/);
//        initializeSearchNodeFundamentals();
        setSearchNodeDeep(newSearchNode);
        fillNodeData(newSearchNode);
//        if (firstSearchNodeOfPossibilityNWDConnection == null) {
//            firstSearchNodeOfPossibilityNWDConnection = searchNode;
//        }
//        System.out.println("searchNodeAddingProcess : " + searchNodeAddingProcess.toString());
//        System.out.println("newSearchNode; : " + newSearchNode);

        if (firstSearchNodeToConnectRootSearchNode == null) {
            firstSearchNodeToConnectRootSearchNode = newSearchNode;
            searchNodeAddingProcess = newSearchNode;
        } else {
            searchNodeAddingProcess.getReachableNWD().addPossibilityNWDNodeToReachableNWD(pc, newSearchNode);
            searchNodeAddingProcess = newSearchNode;
        }/*


        searchNodeAddingProcess = newSearchNode;
        if (firstSearchNodeToConnectRootSearchNode == null) {
            firstSearchNodeToConnectRootSearchNode = searchNodeAddingProcess;
        }
        searchNodeAddingProcess = newSearchNode;


        if (firstSearchNodeToConnectRootSearchNode == searchNodeAddingProcess) {
            searchNodeAddingProcess = null;
        }
        if (searchNodeAddingProcess == null) {
            searchNodeAddingProcess = newSearchNode;
            firstSearchNodeToConnectRootSearchNode.getReachableNWD().addPossibilityNWDNodeToReachableNWD(pc, searchNodeAddingProcess);
        } else {
            searchNodeAddingProcess.getReachableNWD().addPossibilityNWDNodeToReachableNWD(pc, newSearchNode);
        }*/

//        newSearchNode.getReachableNWD().addPossibilityNWDNodeToReachableNWD(pc, newSearchNode);
//        searchNodeAddingProcess = newSearchNode;

//        if (firstSearchNodeForConnection == null)
//            firstSearchNodeForConnection = newSearchNode;


//        System.out.println("firstSearchNodeOfPossibilityNWDConnection : "+firstSearchNodeOfPossibilityNWDConnection.toString());
//        System.out.println("searchNodeAddingProcess : "+searchNodeAddingProcess.toString());
//        queue.add(new NextWayDirectionRequiredData(pc, searchNode));
        return new SuccessDataResult<>(newSearchNode, "Searchnode is created in for " + getClass().getSimpleName());
    }

/*    @Override
    public Queue<NextWayDirectionRequiredData> getQueueSearchNodeToAddReachableNWD() {
        return null;
    }*/

   /* @Override
    public int size() {
        return queue.size();
    }*/

    void initializeSearchNodeFundamentals(SearchNode searchNode) {
        searchNode.setNodeData(new NodeData());
    }

    void createCurrentLocationStringAddress(PriorityChar pc/*, SearchNode searchNode*/) {
//        JOptionPane.showMessageDialog(null,"aappendlenecek lcoation address :"+searchNodeConnectionStart.getNodeData().getLocationStringAddress());
        if (currentLocationStringAddress.toString().equals("")) {
            currentLocationStringAddress.append(searchNodeAddingProcess.getNodeData().getLocationStringAddress());
        }
        currentLocationStringAddress.append(pc.getChar());
        System.out.println("currentLocationStringAddress :  ----> " + currentLocationStringAddress);
    }

    void setSearchNodeDeep(SearchNode searchNode) {
        int deep = currentLocationStringAddress.length();
        searchNode.setDeep(deep);
//        System.out.println("ISLEM YAPILAN NODE DERINLIK : "+deep);

    }

    void fillNodeData(SearchNode searchNode) throws Exception {
        NodeData nodeData = searchNode.getNodeData();
        nodeData.setLocationStringAddress(currentLocationStringAddress.toString());
        Result result = addDataToDataNode(nodeData);
        if (!result.isSuccess()) {
            nodeData.increaseNextDirectionsExistingTotalDataNumber();
        }
//        nodeData.set
    }

    Result addDataToDataNode(NodeData nodeData) throws Exception {
//        JOptionPane.showMessageDialog(null, "data to string : " + data.toString());

        if (nodeData.getLocationStringAddress().equals(data.toString())) {
            if (nodeData.getData() == null) {
                nodeData.setData(data);
                return new SuccessResult();
            }
            throw new Exception("Data is not null\n --> given data : " + data + "\n -->  registered data : " + nodeData.getData());
        }
        return new ErrorResult("Data is not added");
    }

  /*  public SearchNode getSearchNodeToConnectRootSN() {
        return searchNodeToConnectRootSN;
    }*/

    public PriorityChar getPcForFirstSNToConnectRootSN() {
        return pcForFirstSNToConnectRootSN;
    }

    public SearchNode getFirstSearchNodeToConnectRootSearchNode() {
        return firstSearchNodeToConnectRootSearchNode;
    }
}
