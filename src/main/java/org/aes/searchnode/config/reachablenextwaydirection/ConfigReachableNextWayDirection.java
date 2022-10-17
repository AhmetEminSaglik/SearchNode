package org.aes.searchnode.config.reachablenextwaydirection;

import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.NextWayDirectionHashmap;

public class ConfigReachableNextWayDirection {

    public static ReachableNextWayDirection getReachableNextWayDirectionObject() {
        return new NextWayDirectionHashmap();
    }

}
