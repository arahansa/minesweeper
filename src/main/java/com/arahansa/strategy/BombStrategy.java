package com.arahansa.strategy;

import com.arahansa.boxes.Box;

import java.util.function.Function;

public enum BombStrategy {
    UP(box -> {
        // validation
        int targetNum = box.getNumber() - box.getnSize();
        if (targetNum < 1) {
            return Box.OUTOFBOX;
        }
        // map
        return new Box(targetNum, box.getnSize());
    }),
    DOWN(box -> {
        // validation
        int targetNum = box.getNumber() + box.getnSize();
        if (targetNum > box.getnSize() * box.getnSize()) {
            return Box.OUTOFBOX;
        }
        // map
        return new Box(targetNum, box.getnSize());
    }),
    LEFT(box -> {
        // validation
        if (box.getNumber() % box.getnSize() == 1) {
            return Box.OUTOFBOX;
        }
        // map
        return new Box(box.getNumber() - 1, box.getnSize());
    }),
    RIGHT(box -> {
        // validation
        if (box.getNumber() % box.getnSize() == 0) {
            return Box.OUTOFBOX;
        }
        // map
        return new Box(box.getNumber() + 1, box.getnSize());
    }),
    UPLEFT(UP.strategy.andThen(LEFT.strategy)),
    UPRIGHT(UP.strategy.andThen(RIGHT.strategy)),
    DOWNLEFT(DOWN.strategy.andThen(LEFT.strategy)),
    DOWNRIGHT(DOWN.strategy.andThen(RIGHT.strategy)),
    ;
    private Function<Box, Box> strategy;

    BombStrategy(Function<Box, Box> bombStrategy) {
        strategy = bombStrategy;
    }

    public Box calculrate(Box b) {
        return this.strategy.apply(b);
    }
}
