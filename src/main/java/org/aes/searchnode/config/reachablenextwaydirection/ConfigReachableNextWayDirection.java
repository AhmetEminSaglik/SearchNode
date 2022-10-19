package org.aes.searchnode.config.reachablenextwaydirection;

import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.NextWayDirectionHashmap;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.NextWayDirectionList;

public class ConfigReachableNextWayDirection {

    public static ReachableNextWayDirection getReachableNextWayDirectionObject() {
        return new NextWayDirectionHashmap();
//        return new NextWayDirectionList();
    }

}
