package com.steventimothy.cs6150;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TradeOffsSampling {

    private static final int RUNS = 100;
    private static final int POPULATION = 1000000;
    private static final List<Integer> POOL = new ArrayList<>();
    private static SecureRandom secureRandom = new SecureRandom();
    private static final int EXPERIMENT_1 = 20;
    private static final int EXPERIMENT_2 = 100;
    private static final int EXPERIMENT_3 = 400;

    public void run() {
        runExperiment(EXPERIMENT_1);
        runExperiment(EXPERIMENT_2);
        runExperiment(EXPERIMENT_3);
    }

    private void initialize() {
        POOL.clear();

        for (int i = 0; i < POPULATION * .52; i++) {
            POOL.add(1);
        }
        for (int i = 0; i < POPULATION * .48; i++) {
            POOL.add(-1);
        }

        Collections.shuffle(POOL);
    }

    private void runExperiment(int experiment) {
        int numMajorities = 0;

        for (int i = 0; i < RUNS; i++) {
            initialize();
            int countPositive = 0;
            int countNegative = 0;

            for (int j = 0; j < experiment; j++) {
                int sample = pickSample(j);

                if (sample > 0) {
                    countPositive++;
                }
                else {
                    countNegative++;
                }
            }

            if (countPositive > countNegative) {
                numMajorities++;
            }
        }
        System.out.println((double) numMajorities / RUNS);
    }

    private int pickSample(int sizeModifier) {
        int random = Math.abs(secureRandom.nextInt()) % (POPULATION - sizeModifier);

        int sample = POOL.get(random);
        POOL.remove(random);

        return sample;
    }
}
