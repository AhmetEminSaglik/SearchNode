package org.ahmeteminsaglik.searchnode.entities;

import org.ahmeteminsaglik.searchnode.core.utilities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeData<T> {
    public final static int NEW_VALUE_IS_ADDED = 1;
    public final static int NUMBER_OF_VALUE_IS_INCREASED = 2;
    private final List<DataInfo<T>> listDataInfo = new ArrayList<>();
    private int deep;
    private int nextDirectionsTotalValueNumber; //has total value of existing data in next directions.
    private String locationAddress = "";

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
                        tmp.getExplanation().equals(explanation)) {
                    tmp.increaseTotalSameNum();
                    return new SuccessDataResult<>(NUMBER_OF_VALUE_IS_INCREASED, " Data value number is increased");
                }
            }
        }
        addObjectToListDataInfo(t, explanation);
        return new SuccessDataResult<>(NEW_VALUE_IS_ADDED, " Data is added");
    }

    private void sortDataInfoList() {
        Collections.sort(listDataInfo);

        for (int i = 0; i < listDataInfo.size(); i++) {
            listDataInfo.get(i).index = i;
        }
    }

    public DataResult<NodeData<T>> search(Object o) {
        sortDataInfoList();
        for (DataInfo<T> tmp : listDataInfo) {
            if (tmp.getValue().equals(o)) {
                return new SuccessDataResult<>(this);
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

    public int getNextDirectionsTotalValueNumber() {
        return nextDirectionsTotalValueNumber;
    }

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
                ", data={" + getDataInfoListItems() + "},\n" +
                "NDTVN=" + nextDirectionsTotalValueNumber +
                ", locationAddress='" + locationAddress + '\'' +
                '}';
    }

    private String getDataInfoListItems() {
        StringBuilder text = new StringBuilder();

        for (DataInfo<T> tmp : listDataInfo) {
            text.append("\n" + tmp + ",");
        }
        if (listDataInfo.size() > 1)
            text.deleteCharAt(text.length() - 1);
        return text.toString();

    }

    public Result update(String path, String oldExp, String newExp) {
        if (path.equals(locationAddress)) {
            for (DataInfo<T> tmp : listDataInfo) {
                if (tmp.getExplanation().equals(oldExp)) {
                    tmp.setExplanation(newExp);
                    return new SuccessResult("Explanation is updated");
                }
            }
            return new ErrorResult("Explanation \"" + oldExp + "\" is not found");
        }
        return new ErrorResult(path + " is not equals to " + locationAddress);
    }

}
