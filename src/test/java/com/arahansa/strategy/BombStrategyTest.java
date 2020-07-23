package com.arahansa.strategy;

import com.arahansa.boxes.Box;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BombStrategyTest {

    private Box box = new Box(13, 10);

    @DisplayName("정상적인 위로 이동 경우 ")
    @Test
    void UP_bombStrategy() {
        Box calculrated = BombStrategy.UP.calculrate(box);
        assertThat(calculrated.getNumber()).isEqualTo(3);
    }

    @Test
    void UP_bombStrategyOverFlow() {
        Box calculrated = BombStrategy.UP.calculrate(new Box(3, 10));
        assertThat(calculrated).isEqualTo(Box.OUTOFBOX);
    }

    @Test
    void DOWN_bombStrategy() {
        Box calculrated = BombStrategy.DOWN.calculrate(box);
        assertThat(calculrated.getNumber()).isEqualTo(23);
    }

    @Test
    void DOWN_OVERFLOW() {
        Box calculrated = BombStrategy.DOWN.calculrate(new Box(98, 10));
        assertThat(calculrated).isEqualTo(Box.OUTOFBOX);
    }

    @Test
    void LEFT_bombStrategy() {
        Box calculrated = BombStrategy.LEFT.calculrate(box);
        assertThat(calculrated.getNumber()).isEqualTo(12);
    }

    @Test
    void LEFT_overflow() {
        Box calculrated = BombStrategy.LEFT.calculrate(new Box(11, 10));
        assertThat(calculrated).isEqualTo(Box.OUTOFBOX);
    }

    @Test
    void RIGHT_bombStrategy() {
        Box calculrated = BombStrategy.RIGHT.calculrate(box);
        assertThat(calculrated.getNumber()).isEqualTo(14);
    }

    @Test
    void RIGHT_overflow() {
        Box calculrated = BombStrategy.RIGHT.calculrate(new Box(20, 10));
        assertThat(calculrated).isEqualTo(Box.OUTOFBOX);
    }

    @Test
    void UP_LEFT_overflow(){
        Box calculrate = BombStrategy.UPLEFT.calculrate(new Box(3, 10));
        System.out.println(calculrate);
    }

}