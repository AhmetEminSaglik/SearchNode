package org.ahmeteminsaglik.searchnode.business.abstracts.searchnode;

import org.ahmeteminsaglik.searchnode.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.utilities.Result;
import org.ahmeteminsaglik.searchnode.entities.concretes.DataInfo;

import java.util.List;

public interface SearchNodeService<T> {
    DataResult<DataInfo<T>> search(String text);

    Result add(T t);

    Result addAll(List<T> list);

    DataResult<List<T>> getAll();

    DataResult<List<T>> getAllReverse();

    DataResult<List<T>> getAllStartWith(String text);

    long getTotalItemNumber();

}
