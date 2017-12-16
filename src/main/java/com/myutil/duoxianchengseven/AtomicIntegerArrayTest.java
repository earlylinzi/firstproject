package com.myutil.duoxianchengseven;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 数组value通过构造方法传递进去 然后AtomicIntegerArray
 * 会将当前数组复制一份 所以  当AtomicIntegerArray对内部的数组元素进行修改的时候，不会影响传入的数组
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[]{1,2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0,3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
