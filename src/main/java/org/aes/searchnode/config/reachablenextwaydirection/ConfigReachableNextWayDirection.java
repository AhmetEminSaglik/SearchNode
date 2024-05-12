package org.aes.searchnode.config.reachablenextwaydirection;

import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.NextWayDirectionList;

public class ConfigReachableNextWayDirection<T> {
    public ReachableNextWayDirection<T> getReachableNextWayDirectionObject() {
        return new NextWayDirectionList<T>();
    }

}
