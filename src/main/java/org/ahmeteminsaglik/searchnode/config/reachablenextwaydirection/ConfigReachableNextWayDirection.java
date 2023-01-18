package org.ahmeteminsaglik.searchnode.config.reachablenextwaydirection;

import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.ahmeteminsaglik.searchnode.dataaccess.concretes.nextwaydireciton.NextWayDirectionList;

public class ConfigReachableNextWayDirection {
    private ConfigReachableNextWayDirection() {}

    public static ReachableNextWayDirection getReachableNextWayDirectionObject() {
        return new NextWayDirectionList();
    }

}
