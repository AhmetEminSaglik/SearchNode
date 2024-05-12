package org.aes.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.PriorityChar;

public interface PcServiceUpdate {
    DataResult<PriorityChar> update(char c);

}

