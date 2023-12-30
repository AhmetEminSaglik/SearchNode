package org.aes.searchnode.entities.concretes;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.core.utilities.SuccessDataResult;

import java.util.ArrayList;
import java.util.List;

public class NodeData<T> {
    public static int NEW_VALUE_IS_ADDED = 1;
    public static int NUMBER_OF_VALUE_IS_INCREASED = 2;
    private int deep;


    private List<DataInfo<T>> listDataInfo = new ArrayList<>();
    //    private DataInfo dataInfo;
    private int nextDirectionsTotalValueNumber; //burdan sonrasinda kac tane data varsa o sayi burada tutulur.
    private String locationStringAddress = "";  // suanki konuma gelmek icin hangi degerlerden/char'lardan gecildiyse hepsinin sirayla yazilmis halidir.

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public DataResult<Integer> addData(T t) {

        if (listDataInfo.size() > 0) {
            for (DataInfo tmp : listDataInfo) {
                if (tmp.getValue().equals(t)) {
                    tmp.increaseNumberOfHowManyTimesAddedThisValue();
                    return new SuccessDataResult<>(NUMBER_OF_VALUE_IS_INCREASED, " Data value number is increased");
                }
            }
        }
        addObjectToListDataInfo(t);
        return new SuccessDataResult<>(NEW_VALUE_IS_ADDED, " Data is added");

       /* if (listDataInfo.size() == 0) {
            addObjectToListDataInfo(o);
            return new SuccessDataResult<Integer>(NEW_VALUE_IS_ADDED, " Data is added");
        } else {
            for (DataInfo tmp : listDataInfo) {
                if (tmp.equals(o)) {
                    tmp.increaseNumberOfHowManyTimesAddedThisValue();
                    return new SuccessDataResult<Integer>(NUMBER_OF_VALUE_IS_INCREASED, " Data value number is increased");
                }
            }
            addObjectToListDataInfo(o);
            return new SuccessDataResult<Integer>(NEW_VALUE_IS_ADDED, " Data is added");
        }*/
    }

    public DataResult<DataInfo<T>> search(Object o) {
        for (DataInfo<T> tmp : listDataInfo) {

            if (tmp.getValue().equals(o)) {

                return new SuccessDataResult<>(tmp);
            }
        }
        return new ErrorDataResult<>("Data is not found");
    }

    private void addObjectToListDataInfo(T t) {
        listDataInfo.add(new DataInfo<>(t));
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

    public String getLocationStringAddress() {
        return locationStringAddress;
    }

    public void setLocationStringAddress(String locationStringAddress) {
        this.locationStringAddress = locationStringAddress;
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
                ", locationStringAddress='" + locationStringAddress + '\'' +
                '}';
    }

    private String getDataInfoListItems() {
        StringBuilder text = new StringBuilder("");

        for (DataInfo<T> tmp : listDataInfo) {
            text.append(tmp + ",");
        }
        if (listDataInfo.size() > 1)
            text.deleteCharAt(text.length() - 1);
        return text.toString();

    }
}
