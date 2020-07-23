package com.arahansa.strategy;

import com.arahansa.boxes.Box;

import java.util.function.Function;

/**
 * 추후 변경될 이름같다.
 */
public enum BombStrategy {
    UP(box -> {
        // validation
        if (box == Box.OUTOFBOX) return box;
        int targetNum = box.getNumber() - box.getnSize();
        if (targetNum < 1) {
            return Box.OUTOFBOX;
        }
        // map
        return new Box(targetNum, box.getnSize());
    }),
    DOWN(box -> {
        // validation
        if (box == Box.OUTOFBOX) return box;
        int targetNum = box.getNumber() + box.getnSize();
        if (targetNum > box.getnSize() * box.getnSize()) {
            return Box.OUTOFBOX;
        }
        // map
        return new Box(targetNum, box.getnSize());
    }),
    LEFT(box -> {
        // validation
        if (box == Box.OUTOFBOX) return box;
        if (box.getNumber() % box.getnSize() == 1) {
            return Box.OUTOFBOX;
        }
        // map
        return new Box(box.getNumber() - 1, box.getnSize());
    }),
    RIGHT(box -> {
        // validation
        if (box == Box.OUTOFBOX) return box;
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

    public Box calculrate(Box box) {
        return this.strategy.apply(box);
    }
}
