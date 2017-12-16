package com.myutil.duoxianchengeight;

import java.util.Map;
import java.util.concurrent.*;

/**
 * CyclicBarrier的应用 ： 银行流水的多线程计算
 * （多线程计算数据最后合并计算结果的场景）
 */
public class BankWaterService implements Runnable{

    /**
     * 创建4个屏障 处理完成后执行当前类的run方法
     */
    private CyclicBarrier c = new CyclicBarrier(4,this);
    /**
     * 假设只有4个sheet  所以启动4个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);
    /**
     * 保存每个sheet计算出来的银流结果
     */
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    /**
     * 最终的计算方法
     */
    private void count(){
        for (int i = 0; i < 4; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String,Integer> sheet:sheetBankWaterCount.entrySet()){
            result += sheet.getValue();
        }
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
