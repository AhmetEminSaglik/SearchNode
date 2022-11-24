package org.aes.searchnode.entities.concretes;

import org.aes.searchnode.SearchNode;

public class NextWayDirectionRequiredData <T>{
    PriorityChar priorityChar;
    SearchNode<T> searchNode;

    public NextWayDirectionRequiredData(PriorityChar priorityChar, SearchNode<T> searchNode) {
        this.priorityChar = priorityChar;
        this.searchNode = searchNode;
    }

    public PriorityChar getPriorityChar() {
        return new PriorityChar(priorityChar.getChar(), priorityChar.getValue());
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
}
