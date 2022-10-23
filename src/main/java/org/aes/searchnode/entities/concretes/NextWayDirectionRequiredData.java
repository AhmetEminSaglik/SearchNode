package org.aes.searchnode.entities.concretes;

import org.aes.searchnode.SearchNode;

public class NextWayDirectionRequiredData {
    PriorityChar priorityChar;
    SearchNode searchNode;

    public NextWayDirectionRequiredData(PriorityChar priorityChar, SearchNode searchNode) {
        this.priorityChar = priorityChar;
        this.searchNode = searchNode;
    }

    public PriorityChar getPriorityChar() {
        return new PriorityChar(priorityChar.getChar(), priorityChar.getValue());
    }

    public void setPriorityChar(PriorityChar priorityChar) {
        this.priorityChar = priorityChar;
    }

    public SearchNode getSearchNode() { /*TODO data will be returned in safety */
        return searchNode;
    }

    public void setSearchNode(SearchNode searchNode) {
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
