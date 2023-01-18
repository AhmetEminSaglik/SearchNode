package org.ahmeteminsaglik.searchnode.business.concretes;

public class PrimitiveWrapper {
    public boolean isPrimitive(Object object) {
        if (object instanceof Number ||
                object instanceof Boolean ||
                object instanceof Character ||
                object instanceof String) {
            return true;
        }
        return false;


    }
//    public  boolean isPrimitive(Class clazz){
//        System.out.println(clazz.get instanceof  Number);
//        if (clazz.isPrimitive()) {
//            System.out.println("??????? obje primitive gelen obje : "+object+" / class : "+object.getClass());
//            return true;
//        }
//    }
}
