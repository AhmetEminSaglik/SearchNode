package org.ahmeteminsaglik.searchnode.business.abstracts.prioritychar;


import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation.PcServiceCreate;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation.PcServiceDelete;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation.PcServiceRead;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.interfacesegmantation.PcServiceUpdate;

public interface PriorityCharService extends PcServiceCreate, PcServiceRead, PcServiceUpdate, PcServiceDelete {
}
