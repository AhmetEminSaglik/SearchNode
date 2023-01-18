package org.ahmeteminsaglik.searchnode.exception.solutions;

import org.ahmeteminsaglik.searchnode.dataaccess.concretes.priorityfield.PriorityFieldOrder;
import org.ahmeteminsaglik.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;

public class SolutionMessage {
    private SolutionMessage() {
    }

    private static final String prefixText = "\n";
    private static final String solutionAdvice = "SOLUTION ADVICE : ";

    /* public static String getSolutionNotImplementedRequiredInterfaceError(Class clazz) {
         String msg = prefixText + solutionAdvice + "Please implement << IPriorityFields >> interface to your " + clazz.getSimpleName() + " Object.";
         return msg;
     }*/
    public static String getSolutionNotFoundAnyDeclaredField(Class<?> clazz) {
        return prefixText + solutionAdvice + "Please add some variable fields to your " + clazz.getSimpleName() + " Object.";
    }
    public static String getSolutionInvalidFieldRequestException(Class<?> clazz, int declaredFieldListSize) {
        return prefixText + solutionAdvice + "Please enter index value lower than : " + declaredFieldListSize + " or enter field name as declared in your " + clazz.getSimpleName() + " Object.";
    }
    public static String getSolutionInvalidFieldOrFieldNameException(Class<?> clazz) {
        return prefixText + solutionAdvice + "Please enter a valid field or field name includes in " + clazz.getSimpleName() + " Object";
    }
    public static String getSolutionClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException() {
        return prefixText + solutionAdvice + PriorityFieldOrder.class.getSimpleName() + " and " + PriorityFieldValue.class.getSimpleName() +
                " must be proceed on same Object";
    }
}
