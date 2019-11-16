package com.steventimothy.cs6150;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BrownianMotionTest {

    @Test
    public void run() {
        BrownianMotion brownianMotion = new BrownianMotion();

        brownianMotion.run();

        assertThat(true)
                .isTrue();
    }
}
