package org.aes.searchnode.testing;

import java.util.concurrent.TimeUnit;

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
        System.out.println("Elapsed Time : " + elapsedTime);
    }
}
