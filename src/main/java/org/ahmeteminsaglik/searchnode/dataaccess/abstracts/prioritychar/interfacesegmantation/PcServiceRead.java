package org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation;

import org.ahmeteminsaglik.searchnode.entities.PriorityChar;

import java.util.List;

public interface PcServiceRead {
    PriorityChar getPc(char c);

    List<PriorityChar> getAllPc();

    PriorityChar getNextPc(char c);
}
