package org.aes.searchnode.entities.concretes;

import org.aes.searchnode.business.abstracts.prioritychar.NotifyPriorityCharIsUpdated;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.config.prioritychar.ConfigPriorityChar;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;

public class NextWayDirectionRequiredData<T> implements NotifyPriorityCharIsUpdated {
    PriorityCharPoolDAO priorityCharPoolDAO = ConfigPriorityChar.getPriorityCharPoolDAO();
    PriorityChar priorityChar;
    SearchNode<T> searchNode;

    public NextWayDirectionRequiredData(PriorityChar priorityChar, SearchNode<T> searchNode) {
        this.priorityChar = priorityChar;
        this.searchNode = searchNode;
        priorityCharPoolDAO.addToListToBeNotifedWhenPriorityCharIsUpdated(this);
    }

    public PriorityChar getPriorityChar() {
        return priorityChar;/*new PriorityChar(priorityChar.getChar(), priorityChar.getValue());*/
    }

    public void setPriorityChar(PriorityChar priorityChar) {
        this.priorityChar = priorityChar;
    }

    public SearchNode<T> getSearchNode() { /*TODO data will be returned in safety */
        return searchNode;
    }

    public void setSearchNode(SearchNode<T> searchNode) {
        this.searchNode = searchNode;
    }

    @Override
    public String toString() {
        return "NextWayDirectionRequiredData{" +
                "priorityChar=" + priorityChar +
                ", searchNode=" + searchNode +
                '}';
    }

    @Override
    public void updatePriorityChar() {
            this.priorityChar = priorityCharPoolDAO.getPriorityChar(priorityChar.getChar());
    }
}


