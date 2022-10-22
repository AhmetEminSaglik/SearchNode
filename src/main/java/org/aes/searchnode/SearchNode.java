package org.aes.searchnode;

import org.aes.searchnode.business.abstracts.PriorityCharService;
import org.aes.searchnode.business.concretes.prioritychar.PriorityCharManager;
import org.aes.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.core.utilities.SuccessResult;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.PossibilityNextWayDirectionQueue;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldOrder;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.NodeData;
import org.aes.searchnode.entities.concretes.PriorityChar;
import org.aes.searchnode.exception.ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException;
import org.aes.searchnode.exception.InvalidFieldOrFieldNameException;
import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotFoundRequestedFieldException;

import java.util.Queue;

public class SearchNode {
    private int deep;
    private ReachableNextWayDirection reachableNWD = ConfigReachableNextWayDirection.getReachableNextWayDirectionObject();
    private NodeData nodeData = new NodeData();
    private PossibilityNextWayDirectionQueue pNWDQueue = null; //PossibilityNextWayDirectionQueue
    PriorityCharService pcService = new PriorityCharManager();

    public void add(Object object, Class<?> clazz) throws NotFoundAnyDeclaredFieldException, NotFoundRequestedFieldException, ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException, InvalidFieldOrFieldNameException {
        System.out.println("gelen object : " + object);
        Object value = getValueOfObjectToBeProcess(object, clazz);
        addTheValueToReachableNWD(value);

        /*char[] chars = stringOfValue.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            DataResult<PriorityChar> dataResult = priorityCharManager.getPriorityChar(chars[i]);
//            System.out.println(dataResult.toString());
            System.out.println("PriorityChar : " + dataResult.getData() + " / message : " + dataResult.getMsg());
//            System.exit(0);
//            System.out.println("PriorityChar : "+);;
        }*/
    }

    private PriorityChar getPriorityCharOfGivenChar(char c) {

        DataResult<PriorityChar> drPriorityChar = pcService.getPriorityChar(c);
        PriorityChar pc = drPriorityChar.getData();
        return pc;
    }

    void addTheValueToReachableNWD(Object value) {
        StringBuilder stringValue = new StringBuilder(value.toString());
//        stringOfValue = new StringBuilder(value.toString());
//        PriorityCharService pcService = new PriorityCharManager();

        try {
    /*        stringValue=stringValue.delete(0,1);
            System.out.println(stringValue);
            System.exit(0);*/
            for (int i = 0; i < stringValue.length(); i++) {
                PriorityChar pc = getPriorityCharOfGivenChar(stringValue.charAt(i));
                DataResult<SearchNode> drReachablNWD = moveReachableNWD(pc);
                if (!drReachablNWD.isSuccess()) {
                    System.out.println("ERROR : " + drReachablNWD.getMsg());
                    initializePossibilityNWD(value);
                    stringValue.delete(0, i);
                    movePossibilityNWD(stringValue);
                    break;
                }
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
    }

    private Result transferPossibilityNWDToReachableNWD() {
//        System.out.println("islem yapilacak derinlik : "+deep);
//        reachableNWD
        Queue<NextWayDirectionRequiredData> queue = pNWDQueue.getQueueSearchNodeToAddReachableNWD();
        reachableNWD.addPossibilityNWDNodeToReachableNWD(pNWDQueue.getSearchNodeConnectionStart(), queue);
//        reachableNWD.addCreatedSearchNodeToReachableNWD() burdan devam edilecek


        return new SuccessResult();
    }

    DataResult<SearchNode> moveReachableNWD(PriorityChar pc) throws Exception {
        DataResult<SearchNode> dataResult = reachableNWD.getNextWayOfChar(pc);
        System.out.println("moveReachableNWD MSG : " + dataResult.getMsg());
        if (dataResult.isSuccess()) {
            return dataResult;
        }
        return new ErrorDataResult<>("Can not move in ReachableNWD. Because direction is not found.");

    }

    private void movePossibilityNWD(StringBuilder stringBuilder/*PriorityChar pc*/) throws Exception {
        System.out.println("gelen String Builder : " + stringBuilder);
        System.out.println("Burdan possibility;e gidecek");
        for (int i = 0; i < stringBuilder.length(); i++) {
            PriorityChar pc = getPriorityCharOfGivenChar(stringBuilder.charAt(i));
            DataResult<SearchNode> dataResult = pNWDQueue.createNextWayChar(pc);
            System.out.println("dataResult : "+dataResult.toString());
//            System.out.println("dataResult : "+dataResult.getData().getNodeData().toString());

        }
        System.exit(0);
//        System.out.println("Data Result : " +
//                "------> data : "+dataResult.getData()+
//                "------> success : "+ dataResult.isSuccess()+
//                "------> Msg : "+ dataResult.getMsg());
//        System.out.println("returning data locationStringaddress : " + dataResult.getData().getNodeData().getLocationStringAddress());
    }

    private void clearPossibilityNWD() {
        pNWDQueue = null;
    }

    private void initializePossibilityNWD(Object data) {
//        return
        pNWDQueue = new PossibilityNextWayDirectionQueue(this, data);
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

    public PossibilityNextWayDirectionQueue getpNWDQueue() {
        return pNWDQueue;
    }

    public void setpNWDQueue(PossibilityNextWayDirectionQueue pNWDQueue) {
        this.pNWDQueue = pNWDQueue;
    }

    @Override
    public String toString() {
        return "SearchNode{" +
                "deep=" + deep +
                ", nodeData=" + nodeData +
                '}';
    }
    /*   private int deep;
    T data;

    public void add(T t) {
        this.data = t;
    }

    public void add(List<T> tList) {
    }

    public void add(T[] tArr) {

    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }*/

//    @Override
//    public List<Field> getPriorityFields() {
//        System.out.println("sonsuz dongu");
//        return  this.getPriorityFields();
//        return IPriorityFields.super.getPriorityFields();
//    }
    //    int deep;

    //    NodeData<T>
//    public void add(T t) {
//
//    }
}
