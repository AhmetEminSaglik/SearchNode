package org.ahmeteminsaglik.searchnode.exception;

import org.ahmeteminsaglik.searchnode.dataaccess.concretes.priorityfield.PriorityFieldOrder;
import org.ahmeteminsaglik.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;
import org.ahmeteminsaglik.searchnode.exception.solutions.SolutionMessage;

public class ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException extends Exception {
    public ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException(Class<?> priorityFieldOrder, Class<?> priorityFieldValue) {
        super("\nClass variables in " + PriorityFieldOrder.class.getSimpleName() + " and in " + PriorityFieldValue.class.getSimpleName() +
                " are different.\n" + PriorityFieldOrder.class.getSimpleName() + "/" + PriorityFieldValue.class.getSimpleName() + " : " + priorityFieldOrder.getSimpleName() + "/"
                + priorityFieldValue.getSimpleName()
                + SolutionMessage.getSolutionClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException());
    }
}
