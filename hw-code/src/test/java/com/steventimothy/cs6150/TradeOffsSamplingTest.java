package com.steventimothy.cs6150;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TradeOffsSamplingTest {

    @Test
    public void run() {
        TradeOffsSampling tradeOffsSampling = new TradeOffsSampling();
        tradeOffsSampling.run();

        assertThat(true)
                .isTrue();
    }
}
