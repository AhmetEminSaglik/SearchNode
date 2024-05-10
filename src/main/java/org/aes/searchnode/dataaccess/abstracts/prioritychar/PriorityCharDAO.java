package org.aes.searchnode.dataaccess.abstracts.prioritychar;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.entities.PriorityChar;

import java.util.List;

public interface PriorityCharDAO {
    DataResult<PriorityChar> get(char c);
    DataResult<List<PriorityChar>> getAll();
    Result add(char c, char nextToThisChar);

    Result add(List<Character> cList, char nextToThisChar);

    Result remove(char c);

    Result removeAll();

    DataResult<PriorityChar> update(char c);
    DataResult<PriorityChar> getNextPriorityCharOfGiven(char c);
}
