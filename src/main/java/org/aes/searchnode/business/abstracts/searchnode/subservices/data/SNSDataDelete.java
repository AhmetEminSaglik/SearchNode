package org.aes.searchnode.business.abstracts.searchnode.subservices.data;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;

import java.util.List;

public interface SNSDataDelete<T> {

    Result remove(T t);

    DataResult<List<T>> removeAll(List<T> list);

}
