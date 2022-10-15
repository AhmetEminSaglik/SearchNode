package org.aes.searchnode.core.utilities;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data, String msg) {
        super(data, true, msg);
    }

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(String msg) {
        super(null, true, msg);
    }

    public SuccessDataResult() {
        super(null, true);
    }

}
