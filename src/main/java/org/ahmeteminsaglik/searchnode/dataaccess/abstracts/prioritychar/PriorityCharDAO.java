package org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar;

import org.ahmeteminsaglik.searchnode.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.utilities.Result;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;

import java.util.List;

public interface PriorityCharDAO {
    DataResult<PriorityChar>  get(char c);
    Result add(char c,char nextToThisChar);
    Result add(List<Character> cList, char nextToThisChar);
    Result delete(char c);
    DataResult<PriorityChar>  update(char c);
    DataResult<PriorityChar>  reset(char c);



}
