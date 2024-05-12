package org.aes.searchnode.business.abstracts.searchnode.subservices.data;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.DataInfo;
import org.aes.searchnode.entities.NodeDataService;

import java.util.List;

public interface SNSDataRead<T> {
    DataResult<NodeDataService<T>> search(String text);

    DataResult<NodeDataService<T>> getExplanationOf(String text);

    int getTotalItemNumber();

    DataResult<List<DataInfo<T>>> getAll();

    DataResult<List<DataInfo<T>>> getAllReverse();

    DataResult<List<DataInfo<T>>> getAllStartWith(String text);


}