package com.arahansa.boxes;

import com.arahansa.strategy.BombStrategy;

/**
 * N*N 게임의 경우 한 칸에 대한 정보를 가지고 있는
 * Box 에 대한 정보
 *
 */
public class Box {
    /**
     * NULL 대신에 돌려줄 값.
     */
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
        if(this == OUTOFBOX){
            return "OUTOFBOX";
        }
        return "Box{" +
                "number=" + number +
                ", nSize=" + nSize +
                ", count=" + count +
                '}';
    }
}
