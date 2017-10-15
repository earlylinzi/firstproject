package multiThread;

import java.util.concurrent.TimeUnit;

public class SleepUtil {
    public static final void second(long second)  {

        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
