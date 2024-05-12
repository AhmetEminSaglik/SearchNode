package org.aes.searchnode.business.abstracts.searchnode.subservices.prioritychar;

import org.aes.searchnode.core.utilities.DataResult;

public interface SNSPriorityCharRead {
    DataResult<Character> get(char c);

}
