package org.ahmeteminsaglik.searchnode.config.reachablenextwaydirection;

import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.ahmeteminsaglik.searchnode.dataaccess.concretes.nextwaydireciton.NextWayDirectionList;

public class ConfigReachableNextWayDirection<T> {
    public ReachableNextWayDirection<T> getReachableNextWayDirectionObject() {
        return new NextWayDirectionList<T>();
    }

}
