package org.aes.searchnode.entities.concretes;

//import org.aes.searchnode.dataaccess.abstracts.IPriorityFields;

public class Employee /*implements IPriorityFields*/ {
    private String departman;
    private int tc;
    private Language[] language;

    public Employee(String departman, int tc, Language[] language) {
        this.departman = departman;
        this.tc = tc;
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
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

   /* @Override
    public List<Field> getPriorityFields() {
        List<Field> fieldList = new ArrayList<>();
        try {
            fieldList.add(getClass().getDeclaredField("Tc"));
            fieldList.add(getClass().getDeclaredField("language"));
            return fieldList;
        } catch (Exception e) {

            throw new NotFoundAnyDeclaredFieldException(getClass());
        }
//        return IPriorityFields.super.getPriorityFields();
    }*/

    @Override
    public String toString() {
        return "Employee{" +
                "departman='" + departman + '\'' +
                ", tc=" + tc +
                '}';
    }
}
