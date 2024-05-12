package org.aes.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.PriorityChar;

import java.util.List;

public interface PcServiceRead {
    PriorityChar getPc(char c);
    List<PriorityChar> getAllPc();
    PriorityChar getNextPc(char c);
}
