package org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.subservices.data;

import org.ahmeteminsaglik.searchnode.core.utilities.Result;

import java.util.List;

public interface SNSDataUpdate<T> {

    Result update(T t, String oldExp, String newExp);

    Result update(T t, String oldExp, List<String> expList);

    Result update(T t, List<String> expList);

    Result resetPriorityChar(char c);

    Result resetAllPriorityChars();

    Result updatePriorityChar(List<Character> cList, char nextToThisChar);

    Result updatePriorityChar(char c, char nextToThisChar);

}
