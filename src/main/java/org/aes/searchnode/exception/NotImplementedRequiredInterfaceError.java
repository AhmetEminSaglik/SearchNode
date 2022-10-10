package org.aes.searchnode.exception;

import org.aes.searchnode.exception.solutions.SolutionMessage;

public class NotImplementedRequiredInterfaceError extends Error {
    public NotImplementedRequiredInterfaceError(Class clazz) {
        super("Have not implemented <IPriorityFields> interface to : " + clazz.getSimpleName() + " Object"+clazz+
                SolutionMessage.getSolutionNotImplementedRequiredInterfaceError(clazz));
    }
}
