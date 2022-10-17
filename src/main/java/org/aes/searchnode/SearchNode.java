package org.aes.searchnode;

import org.aes.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.entities.concretes.NodeData;

public class SearchNode/* implements IPriorityFields */ {
    private int deep;
    ReachableNextWayDirection reachableNextWayDirection = ConfigReachableNextWayDirection.getReachableNextWayDirectionObject();
    NodeData nodeData;

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
