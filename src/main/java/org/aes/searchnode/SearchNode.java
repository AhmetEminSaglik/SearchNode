package org.aes.searchnode;

import org.aes.searchnode.business.abstracts.PriorityCharService;
import org.aes.searchnode.business.concretes.prioritychar.PriorityCharManager;
import org.aes.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.core.utilities.SuccessResult;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.PossibilityNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldOrder;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;
import org.aes.searchnode.entities.concretes.NodeData;
import org.aes.searchnode.entities.concretes.PriorityChar;
import org.aes.searchnode.exception.ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException;
import org.aes.searchnode.exception.InvalidFieldOrFieldNameException;
import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotFoundRequestedFieldException;

public class SearchNode {
    private int deep;
    private ReachableNextWayDirection reachableNWD = ConfigReachableNextWayDirection.getReachableNextWayDirectionObject();
    private NodeData nodeData = new NodeData();
    private PossibilityNextWayDirection pNWDQueue = null; //PossibilityNextWayDirection
    PriorityCharService pcService = new PriorityCharManager();
    SearchNode movedLastSearchNodeConnection = null;


    public void add(Object object, Class<?> clazz) throws NotFoundAnyDeclaredFieldException, NotFoundRequestedFieldException, ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException, InvalidFieldOrFieldNameException {
        Object value = getValueOfObjectToBeProcess(object, clazz);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Yeni value ekleme >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("type : " + clazz.getSimpleName() + " -->  gelen object : " + value);
        StringBuilder stringValue = new StringBuilder(value.toString());
        movedLastSearchNodeConnection = this;
        try {
            for (int i = 0; i < stringValue.length(); i++) {
                PriorityChar pc = getPriorityCharOfGivenChar(stringValue.charAt(i));
                DataResult<SearchNode> drReachablNWD = movedLastSearchNodeConnection.moveReachableNWD(pc);
                if (!drReachablNWD.isSuccess()) {
                    System.out.println("!!! ERROR : " + drReachablNWD.getMsg());
//                    connectionSearchNodeForPossibilityNWD = new NextWayDirectionRequiredData(pc, lastReachableSearchNode);
                    stringValue.delete(0, i);
                    initializePossibilityNWD(object/*,getPriorityCharOfGivenChar(stringBuilder.charAt(0))*/);

                    movePossibilityNWD(value, stringValue);
                    break;
                }
                /*Eger NWD'de deger bulunur ve datamiz stringLocationAddress ile ayni olursa o halde datamizi  datanode'a datasina ekleyebiliriz*/
                movedLastSearchNodeConnection = drReachablNWD.getData();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        if (pNWDQueue != null) {
            transferPossibilityNWDToReachableNWD();
            clearPossibilityNWD();
        }
        System.out.println("size of reachableNWD after add process : " + reachableNWD.size());
    }

    private PriorityChar getPriorityCharOfGivenChar(char c) {

        DataResult<PriorityChar> drPriorityChar = pcService.getPriorityChar(c);
        PriorityChar pc = drPriorityChar.getData();
        return pc;
    }

    /*void addTheValueToReachableNWD(Object value) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Yeni value ekleme >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("gelen object : "+value);
        StringBuilder stringValue = new StringBuilder(value.toString());
//        SearchNode lastReachableSearchNode = this;
        movedLastSearchNodeConnection = this;
//        stringOfValue = new StringBuilder(value.toString());
//        PriorityCharService pcService = new PriorityCharManager();

        try {
    *//*        stringValue=stringValue.delete(0,1);
            System.out.println(stringValue);
            System.exit(0);*//*
            for (int i = 0; i < stringValue.length(); i++) {
                PriorityChar pc = getPriorityCharOfGivenChar(stringValue.charAt(i));
                DataResult<SearchNode> drReachablNWD = movedLastSearchNodeConnection.moveReachableNWD(pc);
                if (!drReachablNWD.isSuccess()) {
                    System.out.println("!!! ERROR : " + drReachablNWD.getMsg());
//                    connectionSearchNodeForPossibilityNWD = new NextWayDirectionRequiredData(pc, lastReachableSearchNode);
                    stringValue.delete(0, i);
                    movePossibilityNWD(value, stringValue);
                    break;
                }
//                drReachablNWD.getData().getReachableNWD().printAllDataOfSearchNode();
//                System.out.println(">>>>>>>drReachablNWD.getData() : " + drReachablNWD.getData());
                movedLastSearchNodeConnection = drReachablNWD.getData();
//                } //else {
//                    movePossibilityNWD(pc);
//                }
//            System.exit(0);
//            System.out.println("PriorityChar : " + dataResult.getData() + " / message : " + dataResult.getMsg());
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        transferPossibilityNWDToReachableNWD();
        if (pNWDQueue != null) {
            clearPossibilityNWD();
        }
        System.out.println("size of reachableNWD after add process : " + reachableNWD.size());
    }*/

    private Result transferPossibilityNWDToReachableNWD() {
        if (pNWDQueue != null)
            movedLastSearchNodeConnection.getReachableNWD().addPossibilityNWDNodeToReachableNWD(pNWDQueue.getPcForFirstSNToConnectRootSN()
                    , pNWDQueue.getFirstSearchNodeToConnectRootSearchNode());
        return new SuccessResult();
    }

    DataResult<SearchNode> moveReachableNWD(PriorityChar pc) {
        DataResult<SearchNode> dataResult = reachableNWD.getNextWayOfChar(pc);
        System.out.println("moveReachableNWD MSG : " + dataResult);
        if (dataResult.isSuccess()) {
            System.out.println(">>>>>>>>>>???????????? " + dataResult.getData());
            movedLastSearchNodeConnection = dataResult.getData();
            return dataResult;
        }
        return new ErrorDataResult<>("Can not move in ReachableNWD. Because direction is not found.");
    }

    private void movePossibilityNWD(Object value, StringBuilder stringBuilder/*PriorityChar pc*/) throws Exception {
        System.out.println("gelen String Builder : " + stringBuilder);
        System.out.println("Burdan possibility;e gidecek");

        for (int i = 0; i < stringBuilder.length(); i++) {
            PriorityChar pc = getPriorityCharOfGivenChar(stringBuilder.charAt(i));
            DataResult<SearchNode> dataResult = pNWDQueue.createNextWayChar(pc);
            System.out.println("dataResult : " + dataResult.toString());

        }
    }

    private void clearPossibilityNWD() {

        pNWDQueue = null;

    }

    private void initializePossibilityNWD(Object data/*,PriorityChar pc*/) {
        pNWDQueue = new PossibilityNextWayDirection(data, movedLastSearchNodeConnection/*,pc*//*, movedLastSearchNodeConnection*/);
    }

    Object getValueOfObjectToBeProcess(Object o, Class<?> clazz) throws NotFoundRequestedFieldException, ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException, InvalidFieldOrFieldNameException, NotFoundAnyDeclaredFieldException {
        /*TODO  if Object is a custom object than index of priorityFieldName parameter must be dynamic
         *  pfOrder.getPriorityFieldName(index).getName()
         * */
        PriorityFieldOrder pfOrder = new PriorityFieldOrder(clazz);
        PriorityFieldValue pfValue = new PriorityFieldValue(pfOrder);
        String fieldName = pfOrder.getPriorityFieldName(1).getName();
        Object value = pfValue.getValueOfField(o, fieldName);
        System.out.println(" Returning Value Of Object : " + value);
        return value;

    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public ReachableNextWayDirection getReachableNWD() {
        return reachableNWD;
    }

    public void setReachableNWD(ReachableNextWayDirection reachableNWD) {
        this.reachableNWD = reachableNWD;
    }

    public NodeData getNodeData() {
        return nodeData;
    }

    public void setNodeData(NodeData nodeData) {
        this.nodeData = nodeData;
    }

    public PossibilityNextWayDirection getpNWDQueue() {
        return pNWDQueue;
    }

    public void setpNWDQueue(PossibilityNextWayDirection pNWDQueue) {
        this.pNWDQueue = pNWDQueue;
    }

    @Override
    public String toString() {
        return "SearchNode{" +
                "deep=" + deep +
                ", nodeData=" + nodeData +
                '}';
    }
}
