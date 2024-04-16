package org.aes.searchnode.entities.concretes;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.core.utilities.SuccessDataResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeData<T> {
    public final static int NEW_VALUE_IS_ADDED = 1;
    public final static int NUMBER_OF_VALUE_IS_INCREASED = 2;
    private final List<DataInfo<T>> listDataInfo = new ArrayList<>();
    private int deep;
    //    private DataInfo dataInfo;
    private int nextDirectionsTotalValueNumber; //burdan sonrasinda kac tane data varsa o sayi burada tutulur.
    private String locationAddress = "";  // suanki konuma gelmek icin hangi degerlerden/char'lardan gecildiyse hepsinin sirayla yazilmis halidir.

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public DataResult<Integer> addData(T t, String explanation) {

        if (listDataInfo.size() > 0) {
            for (DataInfo tmp : listDataInfo) {
                if (tmp.getValue().equals(t) &&
//                        tmp.getExplanation() != null &&// explanation != null &&
                        tmp.getExplanation().equals(explanation)) {
                    tmp.increaseTotalSameNum();
                    return new SuccessDataResult<>(NUMBER_OF_VALUE_IS_INCREASED, " Data value number is increased");
                }
            }
        }
        addObjectToListDataInfo(t, explanation);
        return new SuccessDataResult<>(NEW_VALUE_IS_ADDED, " Data is added");

       /* if (listDataInfo.size() == 0) {
            addObjectToListDataInfo(o);
            return new SuccessDataResult<Integer>(NEW_VALUE_IS_ADDED, " Data is added");
        } else {
            for (DataInfo tmp : listDataInfo) {
                if (tmp.equals(o)) {
                    tmp.increaseTotalSameNum();
                    return new SuccessDataResult<Integer>(NUMBER_OF_VALUE_IS_INCREASED, " Data value number is increased");
                }
            }
            addObjectToListDataInfo(o);
            return new SuccessDataResult<Integer>(NEW_VALUE_IS_ADDED, " Data is added");
        }*/
    }

    //    public DataResult<List<DataInfo<T>>> search(Object o) {
    private void sortDataInfoList() {
        Collections.sort(listDataInfo);

        for (int i = 0; i < listDataInfo.size(); i++) {
            listDataInfo.get(i).index = i;
        }
    }

    public DataResult<NodeDataService<T>> search(Object o) {
        sortDataInfoList();
        for (DataInfo<T> tmp : listDataInfo) {
            if (tmp.getValue().equals(o)) {
//                list.add(this);
                return new SuccessDataResult<>(
                        new NodeDataService<>(this));
            }
        }
        return new ErrorDataResult<>("Data is not found");
    }

    private void addObjectToListDataInfo(T t, String explanation) {
        listDataInfo.add(new DataInfo<>(listDataInfo.size(), t, explanation));
    }

    public List<DataInfo<T>> getListDataInfo() {
        return listDataInfo;
    }
/*   public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }*/

    public int getNextDirectionsTotalValueNumber() {
        return nextDirectionsTotalValueNumber;
    }

    public void increaseNextDirectionsExistingTotalDataNumber() {
        nextDirectionsTotalValueNumber++;
    }

    public void decreaseNextDirectionsExistingTotalDataNumber() {
        nextDirectionsTotalValueNumber--;
    }
//    public void setNextDirectionsTotalValueNumber(int nextDirectionsTotalValueNumber) {
//        this.nextDirectionsTotalValueNumber = nextDirectionsTotalValueNumber;
//    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }


    /**
     * Next Way Direction Total Value also exist as NWDTV
     *
     * @return int This returns how many data is existed in next way directions.
     */
    public int getNextWayDirectionTotalValue() {
        return nextDirectionsTotalValueNumber;
    }

    /**
     * NWDTV : Next Way Direction Total Value
     * if added any new item goes through this location then increases NWDTV
     */
    public void increaseNextWayDirectionTotalValue() {
        nextDirectionsTotalValueNumber++;
    }

    public void decreaseNextWayDirectionTotalValue() {
        nextDirectionsTotalValueNumber--;
    }

    @Override
    public String toString() {
        return "NodeData{" +
                "deep=" + deep +
                ", data={" + getDataInfoListItems() + '}' +
                ", nextDirectionsTotalValueNumber=" + nextDirectionsTotalValueNumber +
                ", locationAddress='" + locationAddress + '\'' +
                '}';
    }

    private String getDataInfoListItems() {
        StringBuilder text = new StringBuilder();

        for (DataInfo<T> tmp : listDataInfo) {
            text.append(tmp + ",");
        }
        if (listDataInfo.size() > 1)
            text.deleteCharAt(text.length() - 1);
        return text.toString();

    }
}
