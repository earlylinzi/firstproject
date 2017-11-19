package com.myutil.duoxianchengfive;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这是Condition接口的应用示例
 */
public class ConditionUseCase {
    // 新建一个可重入锁
    Lock lock = new ReentrantLock();

    // 获取和这个Lock实例 相对应得Condition实例
    Condition condition = lock.newCondition();

    //
    public void conditionWait () throws InterruptedException {
        lock.lock();
        try {
            condition.await();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSingal(){
        lock.lock();
        try {
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
