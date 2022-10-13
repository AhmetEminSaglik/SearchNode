package org.aes.searchnode.exception.solutions;

public class SolutionMessage {
    private static final String prefixText = "\n";
    private static final String solutionAdvice = "SOLUTION ADVICE : ";

    public static String getSolutionNotImplementedRequiredInterfaceError(Class clazz) {
        String msg = prefixText + solutionAdvice + "Please implement << IPriorityFields >> interface to your " + clazz.getSimpleName() + " Object.";
        return msg;
    }

    public static String getSolutionNotFoundAnyDeclaredField(Class clazz) {
        String msg = prefixText + solutionAdvice + "Please add some variable fields to your " + clazz.getSimpleName() + " Object.";
        return msg;
    }

    public static String getSolutionInvalidFieldRequestException(Class clazz, int declaredFieldListSize) {
        String msg = prefixText + solutionAdvice + "Please enter index value lower than : " + declaredFieldListSize + " or enter field name as declared in your " + clazz.getSimpleName() + " Object.";
        return msg;
    }
}
