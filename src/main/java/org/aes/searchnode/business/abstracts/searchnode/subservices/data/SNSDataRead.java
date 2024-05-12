package org.aes.searchnode.business.abstracts.searchnode.subservices.data;

import org.aes.searchnode.entities.DataInfo;
import org.aes.searchnode.entities.NodeDataService;

import java.util.List;

public interface SNSDataRead<T> {
    NodeDataService<T> search(String text);

    NodeDataService<T> getExplanationOf(String text);

    int getTotalItemNumber();

    List<DataInfo<T>> getAll();

    List<DataInfo<T>> getAllReverse();

    List<DataInfo<T>> getAllStartWith(String text);


}
