package org.aes.searchnode.entities.concretes;

import org.aes.searchnode.dataaccess.abstracts.IPriorityFields;
import org.aes.searchnode.exception.NotFoundAnyDeclaredField;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Employee implements IPriorityFields {
    private String departman;
    private int Tc;
    private Language[] language;

    public Employee(String departman, int tc, Language[] language) {
        this.departman = departman;
        Tc = tc;
        this.language = language;
    }

    /*public Employee(String departman, int tc) {
        this.departman = departman;
        Tc = tc;
    }*/

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public int getTc() {
        return Tc;
    }

    public void setTc(int tc) {
        Tc = tc;
    }

    @Override
    public List<Field> getPriorityFields() {
        List<Field> fieldList = new ArrayList<>();
        try {
            fieldList.add(getClass().getDeclaredField("Tc"));
            fieldList.add(getClass().getDeclaredField("language"));
            return fieldList;
        } catch (Exception e) {

            throw new NotFoundAnyDeclaredField(getClass());
        }
//        return IPriorityFields.super.getPriorityFields();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "departman='" + departman + '\'' +
                ", Tc=" + Tc +
                '}';
    }
}
