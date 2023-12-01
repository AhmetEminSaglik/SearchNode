package org.aes.searchnode.entities.concretes;

import java.util.ArrayList;
import java.util.List;

public class PriorityChar {
    char c;
    double value;

    public PriorityChar(char c, double value) {
        this.c = c;
        this.value = value;
    }

    public char getChar() {
        return c;
    }

    public void setChar(char c) {
        this.c = c;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PriorityChar{" +
                "char=" + c +
                ", value=" + value +
                '}';
    }
}
