package org.ahmeteminsaglik.searchnode.core.utilities;

public class ErrorDataResult<T> extends DataResult<T> {
    public ErrorDataResult(T data, String msg) {
        super(data, false, msg);
    }

    public ErrorDataResult(String message) {
        super(null, false, message);
    }
}
