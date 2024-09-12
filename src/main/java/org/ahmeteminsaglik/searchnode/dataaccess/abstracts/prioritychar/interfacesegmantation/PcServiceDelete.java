package org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation;

import org.ahmeteminsaglik.searchnode.core.utilities.Result;

public interface PcServiceDelete {
    Result remove(char c);

    Result removeAll();
}
