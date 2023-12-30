package org.aes.searchnode.entities.concretes;

public enum EnumRemoveResult {
    DATA_REMOVED(1, "Data is Removed"),
    SEARCH_NODE_MUST_BE_REMOVED(1, "Data is Removed");
    final int id;
    final String result;

    EnumRemoveResult(int id, String result) {
        this.id = id;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public String getResult() {
        return result;
    }
}
