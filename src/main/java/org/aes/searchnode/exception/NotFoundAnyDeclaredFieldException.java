package org.aes.searchnode.exception;

import org.aes.searchnode.exception.solutions.SolutionMessage;

public class NotFoundAnyDeclaredFieldException extends Exception {
    public NotFoundAnyDeclaredFieldException(Class clazz) {
        super("Have not found any declared field in " + clazz.getSimpleName() + " Object."
                + SolutionMessage.getSolutionNotFoundAnyDeclaredField(clazz));
//        printStackTrace();
    }
}
