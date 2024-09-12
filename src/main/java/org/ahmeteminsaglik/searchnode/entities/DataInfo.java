package org.ahmeteminsaglik.searchnode.entities;

public class DataInfo<T> implements Comparable<DataInfo<T>> {
    private final T value;
    protected int index;
    private String explanation;
    private int totalSameNum = 0;

    public DataInfo(int index, T t, String explanation) {
        this.index = index;
        this.value = t;
        this.explanation = explanation;
        increaseTotalSameNum();
    }

    public void increaseTotalSameNum() {
        totalSameNum++;
    }


    public T getValue() {
        return value;
    }

    public int getTotalSameNum() {
        return totalSameNum;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "DataInfo{" +
                "index=" + index +
                ", value=" + value +
                ", explanation=\"" + explanation + "\"" +
                ", totalSameNum=" + totalSameNum +
                '}';
    }

    @Override
    public int compareTo(DataInfo data) {
        int result = this.explanation.compareTo(data.explanation);
        if (result <= 0) {
            int tempIndex = index;
            index = data.index;
            data.index = tempIndex;
        }
        return result;
    }
}
