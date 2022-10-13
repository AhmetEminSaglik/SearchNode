package org.aes.searchnode.exception;

import org.aes.searchnode.dataaccess.concretes.PriorityFieldOrder;
import org.aes.searchnode.dataaccess.concretes.PriorityFieldValue;
import org.aes.searchnode.exception.solutions.SolutionMessage;

public class DifferentClassInFieldOrderAndFieldValueProcessObjectException extends  Exception {
    public DifferentClassInFieldOrderAndFieldValueProcessObjectException(Class priorityFieldOrder, Class priorityFieldValue ) {
        super("\nClass variable in "+ PriorityFieldOrder.class.getSimpleName()+ " and "+PriorityFieldValue.class.getSimpleName()+
                " are different.\n"+PriorityFieldOrder.class.getSimpleName()+"/"+PriorityFieldValue.class.getSimpleName()+ " : " +priorityFieldOrder.getSimpleName()+"/"
                +priorityFieldValue.getSimpleName()
                + SolutionMessage.getSolutionDifferentClassInFieldOrderAndFieldValueProcessObjectException());
    }
}
