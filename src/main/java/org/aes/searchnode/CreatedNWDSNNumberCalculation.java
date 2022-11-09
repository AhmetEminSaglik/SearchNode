package org.aes.searchnode;

public class CreatedNWDSNNumberCalculation {
    private static int nodeNumber = 0;

    public static void increaseNodeNumber() {
        nodeNumber++;
    }

    public static void decreaseNodeNumber() {
        nodeNumber--;
    }

    public static int getNodeNumber() {
        return nodeNumber;
    }
}
