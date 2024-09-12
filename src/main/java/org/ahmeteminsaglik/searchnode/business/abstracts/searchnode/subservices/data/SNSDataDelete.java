package org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.subservices.data;

import org.ahmeteminsaglik.searchnode.core.utilities.Result;

import java.util.List;

public interface SNSDataDelete<T> {

    Result remove(T t);

    Result removeAll(List<T> list);

}
