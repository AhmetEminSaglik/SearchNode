package org.aes.searchnode.config.reachablenextwaydirection;

import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.NextWayDirectionList;

public class ConfigReachableNextWayDirection {
    private ConfigReachableNextWayDirection() {}

    public static ReachableNextWayDirection getReachableNextWayDirectionObject() {
        return new NextWayDirectionList();
    }

}
