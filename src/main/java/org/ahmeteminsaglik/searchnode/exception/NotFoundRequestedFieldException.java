package org.ahmeteminsaglik.searchnode.exception;

import org.ahmeteminsaglik.searchnode.exception.solutions.SolutionMessage;

public class NotFoundRequestedFieldException extends Exception {
    public NotFoundRequestedFieldException(Class clazz, int declaredFieldListSize) {
        super("Field Name is not found in declared field of " + clazz.getSimpleName() + " Object."
                + SolutionMessage.getSolutionInvalidFieldRequestException(clazz, declaredFieldListSize));
//     printStackTrace();
    }
}
