package org.aes.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.PriorityChar;

import java.util.List;

public interface PcServiceRead {
    DataResult<PriorityChar> get(char c);
    DataResult<List<PriorityChar>> getAll();
    DataResult<PriorityChar> getNextPriorityChar(char c);

}
