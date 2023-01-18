package org.ahmeteminsaglik.searchnode.testing;

import org.ahmeteminsaglik.searchnode.utilities.ReadableStringFormat;

public class TimeCalculation {
    private long startTime, endTime, elapsedTime;

    public void start() {
        startTime = System.currentTimeMillis();
//        System.out.println("start time ; "+startTime);
    }

    public void stop() {
        endTime = System.currentTimeMillis();
//        System.out.println("endTime time ; "+endTime);
        elapsedTime = endTime - startTime;
//        System.out.println("elapsedTime : "+elapsedTime);
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void printElapsedTime() {
//        System.out.println("Elapsed Time : " + ReadableStringFormat.getReadableValueIntToString((int) (elapsedTime / 1000))+" seconds");
        System.out.println("Elapsed Time : " + ReadableStringFormat.getReadableValueIntToString((int) (elapsedTime))+" miliSeconds");
    }
}
