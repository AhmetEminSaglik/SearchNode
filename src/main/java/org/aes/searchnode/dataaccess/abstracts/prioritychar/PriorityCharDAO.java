package org.aes.searchnode.dataaccess.abstracts.prioritychar;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.List;

public interface PriorityCharDAO {
    DataResult<PriorityChar>  get(char c);
    Result add(char c,char nextToThisChar);
    Result add(List<Character> cList, char nextToThisChar);
    Result delete(char c);
    DataResult<PriorityChar>  update(char c);


}
