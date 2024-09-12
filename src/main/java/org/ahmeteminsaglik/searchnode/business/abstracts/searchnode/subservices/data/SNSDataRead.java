package org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.subservices.data;

import org.ahmeteminsaglik.searchnode.entities.DataInfo;
import org.ahmeteminsaglik.searchnode.entities.NodeDataService;

import java.util.List;

public interface SNSDataRead<T> {
    NodeDataService<T> search(String text);

    NodeDataService<T> getExplanationOf(String text);

    int getTotalItemNumber();

    List<DataInfo<T>> getAll();

    List<DataInfo<T>> getAllReverse();

    List<DataInfo<T>> getAllStartWith(String text);


}
