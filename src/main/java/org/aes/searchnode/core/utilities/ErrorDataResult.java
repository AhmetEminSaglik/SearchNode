package org.aes.searchnode.core.utilities;

public class ErrorDataResult<T> extends DataResult<T> {
    public ErrorDataResult(T data, boolean success, String msg) {
        super(data, success, msg);
    }

    public ErrorDataResult(T data, boolean success) {
        super(data, success);
    }
}
