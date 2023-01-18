package org.ahmeteminsaglik.searchnode.dataaccess.abstracts;

import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;
import org.ahmeteminsaglik.searchnode.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;

public interface IPreProcessesToCreateReachableNWD <T>{
    DataResult<SearchNode<T>> createNextWayChar(PriorityChar pc) throws Exception;
}
