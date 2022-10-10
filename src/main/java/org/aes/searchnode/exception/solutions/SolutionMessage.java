package org.aes.searchnode.exception.solutions;

public class SolutionMessage {
    public static String getSolutionNotImplementedRequiredInterfaceError(Class clazz) {
        String msg = "\nSolution Advice : Please implement << IPriorityFields >> interface to your " + clazz.getSimpleName() + " Object";
        return msg;
    }

    public static String getSolutionNotFoundAnyDeclaredField(Class clazz) {
        String msg = "\nSolution Advice : Please add some variable fields to your " + clazz.getSimpleName() + " Object";
        return msg;
    }
}
