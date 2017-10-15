package multiThread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {


    public static void main(String[] args) {

//        获取Java的线程管理MXBean
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
//      不需要获取同步的monitor和synchronize信息仅仅获得的是线程和线程的堆栈信息
        ThreadInfo[] threadInfos = mxBean.dumpAllThreads(false, false);
//        便利打印
        for (ThreadInfo ti: threadInfos) {

            System.out.println("args = [" + ti.getThreadId() + "]"+ti.getThreadName());
        }



    }
}
