package org.aes.searchnode.exception;

import org.aes.searchnode.dataaccess.concretes.PriorityFieldOrder;
import org.aes.searchnode.dataaccess.concretes.PriorityFieldValue;
import org.aes.searchnode.exception.solutions.SolutionMessage;

public class ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException extends  Exception {
    public ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException(Class priorityFieldOrder, Class priorityFieldValue ) {
        super("\nClass variables in "+ PriorityFieldOrder.class.getSimpleName()+ " and in "+PriorityFieldValue.class.getSimpleName()+
                " are different.\n"+PriorityFieldOrder.class.getSimpleName()+"/"+PriorityFieldValue.class.getSimpleName()+ " : " +priorityFieldOrder.getSimpleName()+"/"
                +priorityFieldValue.getSimpleName()
                + SolutionMessage.getSolutionClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException());
    }
}
