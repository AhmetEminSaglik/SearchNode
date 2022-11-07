package org.aes.searchnode.entities.concretes;

public class DataInfo {
    private Object value;
    private int numberOfhowManyTimesAddedThisValue = 0;

    public DataInfo(Object value) {
        this.value = value;
        increaseNumberOfHowManyTimesAddedThisValue();
    }

    public void increaseNumberOfHowManyTimesAddedThisValue() {
        numberOfhowManyTimesAddedThisValue++;
    }

    @Override
    public String toString() {
        return "DataInfo{" +
                "value=" + value +
                ", numberOfhowManyTimesAddedThisValue=" + numberOfhowManyTimesAddedThisValue +
                '}';
    }

    public Object getValue() {
        return value;
    }

    public int getNumberOfhowManyTimesAddedThisValue() {
        return numberOfhowManyTimesAddedThisValue;
    }
}
