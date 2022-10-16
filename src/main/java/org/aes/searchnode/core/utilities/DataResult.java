package org.aes.searchnode.core.utilities;

public class DataResult<T> extends Result {
    private T data;

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
        return "DataResult{" +
                "data=" + data + super.toString() +
                '}';
    }
}
