package org.aes.searchnode.business.abstracts.searchnode;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.entities.concretes.DataInfo;

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
