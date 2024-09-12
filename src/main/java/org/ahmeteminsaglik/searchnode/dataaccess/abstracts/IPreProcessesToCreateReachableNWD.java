package org.ahmeteminsaglik.searchnode.dataaccess.abstracts;

import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;
import org.ahmeteminsaglik.searchnode.core.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.entities.PriorityChar;

public interface IPreProcessesToCreateReachableNWD<T> {
    DataResult<SearchNode<T>> createNextWayPriorityChar(PriorityChar pc) throws Exception;
}
