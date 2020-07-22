package com.arahansa.strategy;

import com.arahansa.boxes.Box;

import java.util.ArrayList;
import java.util.List;

public class BombStrategyManager {

    private List<BombStrategy> strategies = new ArrayList<>();

    public void addStrategy(BombStrategy strategy) {
        this.strategies.add(strategy);
    }

    public List<Box> calculrate(Box box) {
        List<Box> result = new ArrayList<>();
        for (BombStrategy s : strategies) {
            Box cal = s.calculrate(box);
            if (s.calculrate(box) != Box.OUTOFBOX) {
                result.add(cal);
            }
        }
        return result;
    }
}
