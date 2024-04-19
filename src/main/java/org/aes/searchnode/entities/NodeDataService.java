package org.aes.searchnode.entities;

import org.aes.searchnode.entities.DataInfo;

import java.util.ArrayList;
import java.util.List;

public class NodeDataService<T> {
    private final int deep;
    private List<DataInfo<T>> listDataInfo = new ArrayList<>();
    private final int nextDirectionsTotalValueNumber; //burdan sonrasinda kac tane data varsa o sayi burada tutulur.
    private String locationAddress = "";  // suanki konuma gelmek icin hangi degerlerden/char'lardan gecildiyse hepsinin sirayla yazilmis halidir.

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

/*    public static NodeDataService build() {
        return new NodeDataService();
    }

    public NodeDataService setNDTVN(int value) {
        this.nextDirectionsTotalValueNumber = value;
        return this;
    }

    public NodeDataService setDeep(int deep) {
        this.deep = deep;
        return this;
    }

    public NodeDataService setListDataInfo(List<DataInfo<T>> listDataInfo) {
        this.listDataInfo = listDataInfo;
        return this;
    }*/
/*    public NodeDataService setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
        return this;
    }*/

    @Override
    public String toString() {
        return "NodeDataService{" +
                "deep=" + deep +
                ", listDataInfo=" + listDataInfo +
//                (listDataInfo.size() == 0 ? "" : "") +
                ", nextDirectionsTotalValueNumber=" + nextDirectionsTotalValueNumber +
                ", locationAddress='" + locationAddress + '\'' +
                '}';
    }
}
