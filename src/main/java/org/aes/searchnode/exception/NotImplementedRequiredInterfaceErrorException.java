package org.aes.searchnode.exception;

import org.aes.searchnode.exception.solutions.SolutionMessage;

public class NotImplementedRequiredInterfaceErrorException extends Exception {
    public NotImplementedRequiredInterfaceErrorException(Class clazz) {
        super("Have not implemented <IPriorityFields> interface to : " + clazz.getSimpleName() + " Object."
                + SolutionMessage.getSolutionNotImplementedRequiredInterfaceError(clazz));
//        printStackTrace();
    }
}
