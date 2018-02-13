package k_order;

import utils.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKOrder {
    static int N = 10000000;
    static int K = 10000;

    public static void main(String[] args) {
        System.out.println("Generating numbers...");
        List<Integer> numsList = Utils.generateNumsList(1000, N);
        System.out.println("Done.");

        System.out.println("=========================");
        long startTime = System.currentTimeMillis();
        method1(numsList);
        long endTime = System.currentTimeMillis();
        double time1 = (endTime - startTime) / 1000.0;
        System.out.println("Method 1 : " + time1);

        Collections.shuffle(numsList);
        startTime = System.currentTimeMillis();
        method2(numsList);
        endTime = System.currentTimeMillis();
        double time2 = (endTime - startTime) / 1000.0;
        System.out.println("Method 2 : " + time2);

        System.out.println("=========================");
        System.out.println("Rate : " + (time1 / time2));
    }

    private static void method1(List<Integer> numsList) {
        Collections.sort(numsList);
        System.out.println("Method 1 k-order : " + numsList.get(K));
    }

    private static void method2(List<Integer> numsList) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(numsList);

        Integer result = priorityQueue.poll();
        for (int i = 0; i < K - 1; i++) {
            result = priorityQueue.poll();
        }

        System.out.println("Method 2 k-order : " + result);
    }
}
