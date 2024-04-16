package org.aes.searchnode.core.utilities;

public class DataResult<T> extends Result {
    private final T data;

    public DataResult(T data, boolean success, String msg) {
        super(success, msg);
        this.data = data;
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }


    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        String dataToString;
        if (data != null) {
            dataToString = data.toString();
        } else {
            dataToString = null;
        }
        return "DataResult{" +
                "data=" + dataToString + ", " + super.toString() +
                '}';
    }
}
