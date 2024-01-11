package org.aes.searchnode.testing.concretes;

import org.aes.searchnode.core.utilities.ReadableStringFormat;

import java.util.concurrent.TimeUnit;

public class TimeCalculation {
    private long startTime, endTime, elapsedTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void printElapsedTime() {
        System.out.println("Elapsed Time : " + ReadableStringFormat.getReadableValueIntToString((int) (elapsedTime))+" miliSeconds");
    }
}
