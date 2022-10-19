package org.aes.searchnode;

import org.aes.searchnode.business.abstracts.PriorityCharService;
import org.aes.searchnode.business.concretes.prioritychar.PriorityCharManager;
import org.aes.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.PossibilityNextWayDirectionQueue;
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
    private NodeData nodeData;
    private PossibilityNextWayDirectionQueue pNWDQueue;

    public void add(Object object, Class clazz) throws NotFoundAnyDeclaredFieldException, NotFoundRequestedFieldException, ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException, InvalidFieldOrFieldNameException {
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

    void addTheValueToReachableNWD(Object value) {
        StringBuilder stringValue = new StringBuilder(value.toString());
//        stringOfValue = new StringBuilder(value.toString());
        PriorityCharService pcService = new PriorityCharManager();

        for (int i = 0; i < stringValue.length(); i++) {
            DataResult<PriorityChar> drPriorityChar = pcService.getPriorityChar(stringValue.charAt(i));
            PriorityChar pc = drPriorityChar.getData();
//            reachableNWD.getNextWayOfChar(pc);
//            reachableNWD.getNextWayOfChar(pc).isSuccess();
            DataResult<SearchNode> drReachablNWD = moveReachableNWD(pc);


            if (!drReachablNWD.isSuccess()) {
                System.out.println("ERROR : " + drReachablNWD.getMsg());


            }

//            System.exit(0);
//            System.out.println("PriorityChar : " + dataResult.getData() + " / message : " + dataResult.getMsg());
        }
    }

    DataResult<SearchNode> moveReachableNWD(PriorityChar pc) {
        DataResult<SearchNode> dataResult = reachableNWD.getNextWayOfChar(pc);
        System.out.println("moveReachableNWD MSG : " + dataResult.getMsg());
//        System.exit(0);
        if (dataResult.isSuccess()) {
            return dataResult;
        }
        return new ErrorDataResult<>("Can not move in ReachableNWD. Because direction is not found.");

    }

    void workOnPossibilityNWDQueue(PriorityChar pc) {
        

    }

    Object getValueOfObjectToBeProcess(Object o, Class clazz) throws NotFoundRequestedFieldException, ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException, InvalidFieldOrFieldNameException, NotFoundAnyDeclaredFieldException {
        PriorityFieldOrder pfOrder = new PriorityFieldOrder(clazz);
        PriorityFieldValue pfValue = new PriorityFieldValue(pfOrder);
        String fieldName = pfOrder.getPriorityFieldName(0).getName();
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
