package org.ahmeteminsaglik.searchnode.core.utilities;

public class Result {
    private final boolean success;
    private String msg;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                '}';
    }
}
