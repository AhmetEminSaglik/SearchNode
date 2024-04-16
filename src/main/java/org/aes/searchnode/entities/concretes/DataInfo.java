package org.aes.searchnode.entities.concretes;

public class DataInfo<T> {
    private int index;
    private final T value;
    private String explanation;
    private int totalSameNum = 0;

    public DataInfo(int index, T t, String explanation) {
        this.index = index;
        this.value = t;
        this.explanation = explanation;
        increaseTotalSameNum();
        System.out.println("created index: "+index);
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
//        String explanationToString = this.explanation != null ? " ,explanation='" + explanation + '\'' : " ,explanation=" + explanation;
        return "DataInfo{" +
                "index=" + index +
                ", value=" + value +
                ", explanation=\"" + explanation +"\""+
                ", totalSameNum=" + totalSameNum +
                '}';
    }
}
