package org.ahmeteminsaglik.searchnode.exception;

import org.ahmeteminsaglik.searchnode.exception.solutions.SolutionMessage;

public class NotFoundAnyDeclaredFieldException extends Exception {
    public NotFoundAnyDeclaredFieldException(Class clazz) {
        super("Have not found any declared field in " + clazz.getSimpleName() + " Object."
                + SolutionMessage.getSolutionNotFoundAnyDeclaredField(clazz));
    }
}
