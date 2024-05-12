package org.aes.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.PriorityChar;

import java.util.List;

public interface PcServiceRead {
    DataResult<PriorityChar> getPc(char c);
    DataResult<List<PriorityChar>> getAllPc();
    DataResult<PriorityChar> getNextPc(char c);
}
