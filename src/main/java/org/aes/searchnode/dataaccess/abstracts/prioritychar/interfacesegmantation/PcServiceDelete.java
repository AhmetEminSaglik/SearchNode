package org.aes.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation;

import org.aes.searchnode.core.utilities.Result;

public interface PcServiceDelete {
    Result remove(char c);

    Result removeAll();
}
