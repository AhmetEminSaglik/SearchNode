package org.aes.searchnode.exception;

import org.aes.searchnode.exception.solutions.SolutionMessage;

public class NotFoundAnyDeclaredField extends Error {

    public NotFoundAnyDeclaredField(Class clazz) {
        super("Have not found any declared field on  : " + clazz.getSimpleName() + " Object" + SolutionMessage.getSolutionNotFoundAnyDeclaredField(clazz));
    }
}
