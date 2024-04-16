package org.aes.searchnode.business.abstracts.searchnode;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.entities.concretes.DataInfo;
import org.aes.searchnode.entities.concretes.NodeDataService;

import java.util.List;

public interface SearchNodeService<T> {
    DataResult<NodeDataService<T>> search(String text);

    DataResult<NodeDataService<T>> searchExplanationOf(String text);

    Result add(T t);

    Result add(T t, String explanation);

    Result addAll(List<T> list);

    DataResult<List<DataInfo<T>>> getAll();

    DataResult<List<DataInfo<T>>> getAllReverse();

    DataResult<List<DataInfo<T>>> getAllStartWith(String text);

    int getTotalItemNumber();

    Result resetPriorityChar(char c);

    Result resetAllPriorityChars();

    Result updatePriorityChar(List<Character> cList, char nextToThisChar);

    Result updatePriorityChar(char c, char nextToThisChar);
//    void updatePriorityChar();

}
