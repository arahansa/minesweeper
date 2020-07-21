package com.arahansa.numbers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomNumberGeneratorTest {

    @Test
    void randomGenerate() {
        RandomNumberGenerator generator = new SimpleRandomNumberGenerator(100);
        for (int i = 0; i < 1000; i++) {
            Set<Integer> generatedSet = generator.generate(6);
            List<Integer> list = new ArrayList<>(generatedSet);
            System.out.println(generatedSet);
            assertThat(generatedSet.size()).isEqualTo(6);
            assertThat(list.get(0)).isGreaterThanOrEqualTo(1);
            assertThat(list.get(list.size() - 1)).isLessThanOrEqualTo(100);
        }
    }

    @Test
    void constructGeneator_withGreaterMin() {
        assertThatThrownBy(() -> new SimpleRandomNumberGenerator(101, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("min is bigger than max");
    }

    @Test
    void constructGeneator_withMAX_UNDERFLOW() {
        assertThatThrownBy(() -> new SimpleRandomNumberGenerator(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("min is bigger than max");
    }

    @Test
    void constructGeneator_withMAXLIMIT_OVERFLOW() {
        assertThatThrownBy(() -> new SimpleRandomNumberGenerator(101100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("max is must be under 1000");
    }

    @Test
    void constructGeneator_withMIN_UNDERFLOW() {
        assertThatThrownBy(() -> new SimpleRandomNumberGenerator(0, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("min is must be bigger than 1");
    }

    @Test
    void generate_withIllegalSize() {
        SimpleRandomNumberGenerator generator = new SimpleRandomNumberGenerator(3);
        assertThatThrownBy(() -> generator.generate(4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("min-max range is smaller than input size.");

        Set<Integer> generatedSet = generator.generate(3);
        List<Integer> list = new ArrayList<>(generatedSet);
        System.out.println(generatedSet);
        assertThat(generatedSet.size()).isEqualTo(3);
        assertThat(list.get(0)).isGreaterThanOrEqualTo(1);
        assertThat(list.get(list.size() - 1)).isLessThanOrEqualTo(3);
    }


}