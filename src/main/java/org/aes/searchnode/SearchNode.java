package org.aes.searchnode;

import org.aes.searchnode.business.concretes.prioritychar.PriorityCharManager;
import org.aes.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.PossibilityNextWayDirectionQueue;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldOrder;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;
import org.aes.searchnode.entities.concretes.NodeData;
import org.aes.searchnode.entities.concretes.PriorityChar;
import org.aes.searchnode.entities.example.Student;
import org.aes.searchnode.exception.ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException;
import org.aes.searchnode.exception.InvalidFieldOrFieldNameException;
import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotFoundRequestedFieldException;

public class SearchNode {
    private int deep;
    private ReachableNextWayDirection reachableNWD = ConfigReachableNextWayDirection.getReachableNextWayDirectionObject();
    private NodeData nodeData;
    private PossibilityNextWayDirectionQueue pNWDQueue;

    public void add(Class clazz, Object o) throws NotFoundAnyDeclaredFieldException, NotFoundRequestedFieldException, ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException, InvalidFieldOrFieldNameException {
        System.out.println("gelen object : " + o);

        PriorityFieldOrder pfOrder = new PriorityFieldOrder(clazz);
        PriorityFieldValue pfValue = new PriorityFieldValue(pfOrder);
        String fieldName = pfOrder.getPriorityFieldName(0).getName();
        Object value = pfValue.getValueOfField(o, fieldName);
        System.out.println("Gelen object : " + o + " / value : " + value);

        String text = value.toString();
        PriorityCharManager priorityCharManager = new PriorityCharManager();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            DataResult<PriorityChar> dataResult = priorityCharManager.getPriorityChar(chars[i]);
//            System.out.println(dataResult.toString());
            System.out.println("PriorityChar : " + dataResult.getData() + " / message : " + dataResult.getMsg());
//            System.exit(0);
//            System.out.println("PriorityChar : "+);;

        }
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
