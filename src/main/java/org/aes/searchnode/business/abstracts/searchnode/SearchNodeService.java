package org.aes.searchnode.business.abstracts.searchnode;

import org.aes.searchnode.business.abstracts.searchnode.subservices.data.BaseSNSDataService;
import org.aes.searchnode.business.abstracts.searchnode.subservices.node.BaseSNSNodeService;
import org.aes.searchnode.business.abstracts.searchnode.subservices.prioritychar.BaseSNSPcService;

public interface SearchNodeService<T> extends BaseSNSNodeService<T>, BaseSNSDataService<T>, BaseSNSPcService {


}
