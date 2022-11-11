package org.aes.searchnode.exception;

import org.aes.searchnode.exception.solutions.SolutionMessage;

public class InvalidFieldOrFieldNameException extends  Exception{
    public InvalidFieldOrFieldNameException(Class<?> clazz, String fieldName) {
        super("Invalid field or field name for "+clazz.getSimpleName()+" Object. Entered Input Value is : "+fieldName+"  "
                + SolutionMessage.getSolutionInvalidFieldOrFieldNameException(clazz));
    }
}
