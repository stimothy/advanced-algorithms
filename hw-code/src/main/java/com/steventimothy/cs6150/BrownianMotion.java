package com.steventimothy.cs6150;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrownianMotion {

    private static final int RUNS = 50;
    private static final int ORIGIN = 0;
    private static final double EXPERIMENT_1 = (4 * Math.pow(10, 4));
    private static final double EXPERIMENT_2 = (9 * Math.pow(10, 4));
    private static final double EXPERIMENT_3 = (16 * Math.pow(10, 4));
    private static SecureRandom secureRandom = new SecureRandom();
    private static final List<Integer> POOL = new ArrayList<>(Arrays.asList(1, -1));

    public void run() {
        runExperiment((long) EXPERIMENT_1);
        runExperiment((long) EXPERIMENT_2);
        runExperiment((long) EXPERIMENT_3);
    }

    private void runExperiment(long experiment) {
        List<Integer> crosses = new ArrayList<>();
        for (int i = 0; i < RUNS; i++) {
            int pos = ORIGIN;
            int crossCount = 0;
            pos += computeMovement();
            boolean isPositive = pos > 0;

            for (long j = 0; j < experiment - 1; j++) {
                pos += computeMovement();

                if (pos > 0 && !isPositive) {
                    crossCount++;
                    isPositive = true;
                } else if (pos < 0 && isPositive) {
                    crossCount++;
                    isPositive = false;
                }
            }

            crosses.add(crossCount);
        }

        int crossSum = 0;

        for (Integer x : crosses) {
            crossSum += x;
        }

        double avgCrossCount = (double) crossSum / ((!crosses.isEmpty()) ? crosses.size() : 1);
        System.out.println(avgCrossCount);
    }

    private int computeMovement() {
        int random = Math.abs(secureRandom.nextInt()) % 2;

        return POOL.get(random);
    }
}
