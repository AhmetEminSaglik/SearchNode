package org.ahmeteminsaglik.searchnode.business.abstracts.searchnode;

import org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.subservices.data.BaseSNSDataService;
import org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.subservices.node.BaseSNSNodeService;
import org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.subservices.prioritychar.BaseSNSPcService;

public interface SearchNodeService<T> extends BaseSNSNodeService<T>, BaseSNSDataService<T>, BaseSNSPcService {


}
