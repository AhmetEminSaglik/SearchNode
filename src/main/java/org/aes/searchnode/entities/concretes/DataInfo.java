package org.aes.searchnode.entities.concretes;

public class DataInfo<T> {
    private T value;
    private int numberOfhowManyTimesAddedThisValue = 0;

    public DataInfo(T t) {
        this.value = t;
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

    public T getValue() {
        return value;
    }

    public int getNumberOfhowManyTimesAddedThisValue() {
        return numberOfhowManyTimesAddedThisValue;
    }
}
