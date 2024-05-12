package org.aes.searchnode.dataaccess.abstracts.prioritychar;

import org.aes.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation.PcServiceCreate;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation.PcServiceDelete;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation.PcServiceRead;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation.PcServiceUpdate;

public interface PriorityCharDAO extends PcServiceCreate, PcServiceRead, PcServiceUpdate, PcServiceDelete {


}
