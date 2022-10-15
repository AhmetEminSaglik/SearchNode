package org.aes.searchnode.core.utilities;

public class SuccessResult extends Result {

    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String msg) {
        super(true, msg);
    }

}
