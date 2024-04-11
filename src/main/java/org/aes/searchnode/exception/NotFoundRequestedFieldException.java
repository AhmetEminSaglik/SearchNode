package org.aes.searchnode.exception;

import org.aes.searchnode.exception.solutions.SolutionMessage;

public class NotFoundRequestedFieldException extends Exception {
    public NotFoundRequestedFieldException(Class clazz, int declaredFieldListSize) {
        super("Field Name is not found in declared field of " + clazz.getSimpleName() + " Object."
                + SolutionMessage.getSolutionInvalidFieldRequestException(clazz, declaredFieldListSize));
    }
}
