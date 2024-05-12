package org.aes.searchnode.business.abstracts.searchnode.subservices.data;

import org.aes.searchnode.core.utilities.Result;

import java.util.List;

public interface SNSDataCreate<T> {

    Result add(T t);

    Result add(T t, String explanation);

    Result add(T t, List<String> expList);

    Result addAll(List<T> list);
}
