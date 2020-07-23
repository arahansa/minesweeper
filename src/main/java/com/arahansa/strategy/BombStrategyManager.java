package com.arahansa.strategy;

import com.arahansa.boxes.Box;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BombStrategyManager {

    private Set<BombStrategy> strategies = new HashSet<>();


    public BombStrategyManager(Set<BombStrategy> strategies) {
        this.strategies = strategies;
    }

    public void addStrategy(BombStrategy... strategies) {
        for(BombStrategy strategy : strategies){
            this.strategies.add(strategy);
        }
    }

    public List<Box> calculrate(final Box box) {
        return strategies.stream()
                .map(strategy -> strategy.calculrate(box))
                .filter(res -> res != Box.OUTOFBOX)
                .collect(Collectors.toList());
    }
}
