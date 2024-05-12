package org.aes.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation;

import org.aes.searchnode.core.utilities.Result;

import java.util.List;

public interface PcServiceCreate {
    Result add(char c, char nextToThisChar);

    Result add(List<Character> cList, char nextToThisChar);
}
