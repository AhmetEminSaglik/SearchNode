package org.aes.searchnode.entities.concretes;

public class DataInfo<T> {
    private T value;
    private String explanation;
    private int numberOfhowManyTimesAddedThisValue = 0;

    public DataInfo(T t, String explanation) {
        this.value = t;
        this.explanation=explanation;
        increaseNumberOfHowManyTimesAddedThisValue();
    }

    public void increaseNumberOfHowManyTimesAddedThisValue() {
        numberOfhowManyTimesAddedThisValue++;
    }

    @Override
    public String toString() {
        return "DataInfo{" +
                "value='" + value +'\''+
                " ,explanation='" + explanation+'\''+
                " ,numberOfhowManyTimesAddedThisValue=" + numberOfhowManyTimesAddedThisValue +
                '}';
    }

    public T getValue() {
        return value;
    }

    public int getNumberOfhowManyTimesAddedThisValue() {
        return numberOfhowManyTimesAddedThisValue;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
