package com.arahansa.numbers;

import java.util.Set;
import java.util.TreeSet;

/**
 * min 부터 max 까지의 랜덤 정수숫자 x개를 생성해주는 클래스
 * 생성자로 min?, max 를 받는다.
 *
 * 생성자 제약조건
 * 1. max 의 최대 크기는 내부의 MAX_LIMIT 보다 커선 안된다.
 * 2. 입력받는 max는 min <= max 여야 한다.
 * 3. min을 입력받을 때의 값은 1 이상 이어야 한다.
 * 4. 기본 MIN 값은 1 이다.
 */
public class SimpleRandomNumberGenerator implements RandomNumberGenerator {
    private static final int MAX_LIMIT = 1000;
    private static final int MIN_INIT = 1;

    int min = MIN_INIT;
    int max;

    public SimpleRandomNumberGenerator(int min, int max) {
        if (min > max) throw new IllegalArgumentException("min is bigger than max");
        if (max > MAX_LIMIT) throw new IllegalArgumentException("max is must be under " + MAX_LIMIT);
        if (min < MIN_INIT) throw new IllegalArgumentException("min is must be bigger than " + MIN_INIT);

        this.min = min;
        this.max = max;
    }

    public SimpleRandomNumberGenerator(int max) {
        this(MIN_INIT, max);
    }

    /**
     * generate(X)를 하면 min, max 사이의 (min,max 포함) 중복되지 않는 숫자 X 개를 돌려준다.
     *  제약조건
     *  min,max 사이의 숫자보다  size 가 더 큰 경우는..?
     * @param size
     * @return
     */
    public Set<Integer> generate(int size) {
        if ((max - min + 1) < size) throw new IllegalArgumentException("min-max range is smaller than input size.");
        Set<Integer> result = new TreeSet<>();
        while (result.size() < size) {
            result.add((min + (int) (Math.random() * ((max - min) + 1))));
        }
        return result;
    }
}
