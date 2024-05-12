package org.aes.searchnode.entities;

import java.util.ArrayList;
import java.util.List;

public class NodeDataService<T> {
    private final int deep;
    private final int nextDirectionsTotalValueNumber; //burdan sonrasinda kac tane data varsa o sayi burada tutulur.
    private List<DataInfo<T>> listDataInfo = new ArrayList<>();
    private String locationAddress = "";

    public NodeDataService(NodeData<T> nodeData) {
        this.deep = nodeData.getDeep();
        this.listDataInfo = new ArrayList<>(nodeData.getListDataInfo());
        this.nextDirectionsTotalValueNumber = nodeData.getNextDirectionsTotalValueNumber();
        this.locationAddress = nodeData.getLocationAddress();
    }

    public int getDeep() {
        return deep;
    }

    public List<DataInfo<T>> getListDataInfo() {
        return listDataInfo;
    }

    public int getNextDirectionsTotalValueNumber() {
        return nextDirectionsTotalValueNumber;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    @Override
    public String toString() {
        return "NodeDataService{" +
                "deep=" + deep +
                ", listDataInfo=" + listDataInfo +
                ", nextDirectionsTotalValueNumber=" + nextDirectionsTotalValueNumber +
                ", locationAddress='" + locationAddress + '\'' +
                '}';
    }
}
