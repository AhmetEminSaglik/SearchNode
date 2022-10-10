package org.aes.searchnode;

public class NodeData<T> {
    long id;
    private T data;

    public NodeData() {
    }

    public NodeData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
