package com.arahansa.boxes;

import com.arahansa.strategy.BombStrategy;

/**
 * Box 에 대한 정보
 */
public class Box {
    public static Box OUTOFBOX = new Box(0, 0);
    private int number;
    private int nSize;
    private int count;

    public Box(int number, int nSize) {
        this.number = number;
        this.nSize = nSize;
    }

    public void addCount(){
        count++;
    }

    public int getNumber() {
        return number;
    }

    public int getnSize() {
        return nSize;
    }

    /**
     * 그냥 고민..
     * @param strategy
     * @return
     */
    public boolean moveable(BombStrategy strategy){
        return false;
    }

    @Override
    public String toString() {
        return "Box{" +
                "number=" + number +
                ", nSize=" + nSize +
                ", count=" + count +
                '}';
    }
}
