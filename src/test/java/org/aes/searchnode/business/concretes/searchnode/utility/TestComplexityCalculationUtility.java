package org.aes.searchnode.business.concretes.searchnode.utility;

import org.ahmeteminsaglik.MemoryUsage;
import org.ahmeteminsaglik.Stopwatch;

public class TestComplexityCalculationUtility {
    public  static  void start(Stopwatch stopwatch, MemoryUsage memoryUsage){
        memoryUsage.calculateMemoryBeforeProcess();
        stopwatch.startTime();
    }
    public  static  void stop(Stopwatch stopwatch, MemoryUsage memoryUsage){
        stopwatch.stopTime();
        memoryUsage.calculateMemoryAfterProcess();
    }
}
