package org.ahmeteminsaglik.searchnode.business.abstracts.prioritychar;

import org.ahmeteminsaglik.searchnode.config.prioritychar.ConfigPriorityChar;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;

public interface PriorityCharService extends AccessPriorityCharService, UpdatePriorityCharService {

    /* TODO  PriorityCharService
      updated chars is storaged in PriorityCharPoolDAOImp
    * here may need to be change later. For example if there are a few ordered chars pools
    * the customer want to test them.
    *
    * Or for each Searchnode only may use 1 ordered data and could not change it.
    * Well this strict is not good.  Probably I will a PriorityCharPoolDAOImp object to set and get to SearchNode
    * And let customer to update this char pool. So it will be more useable.
    * Also I created this as a final So added to interface but this need to be updated
    * I will remove this class from interface. Probably will move to SearchNode.
    *
    * */


    /*I may add this to PriorityCharManager or SearchNode*/
    PriorityCharDAO priorityCharDAO = ConfigPriorityChar.getPriorityCharDAO();

//    DataResult<PriorityChar> getPriorityChar(char c);
//    Result sort(ComparatorValue<PriorityChar> comparator);
//    Result deletePriorityChar(char c);
//    DataResult<PriorityChar>  updatePriorityChar(char c);
}
