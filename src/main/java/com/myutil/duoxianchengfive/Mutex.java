package com.myutil.duoxianchengfive;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 独占锁的示例
 */
public class Mutex implements Lock{
    // 静态内部类自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer{
        // 是否处于占用状态
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }

        // 当状态为零的时候获取锁
        public boolean tryAcquire(int acquire){
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 当状态为零的时候释放锁
        protected boolean tryRealease(){
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setState(0);
            return true;
        }

        // 返回一个condition   每个condition都包含了一个condition队列
        Condition newCondition(){
            return new ConditionObject();
        }


    }


    Sync sync = new Sync();

// ===============以下这些都是需要实现方法
    public void lock() {
        sync.acquire(1);
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }
}
