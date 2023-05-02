package fanyu.test;

import java.util.concurrent.*;

public class ThreadsTest {

    public static void main(String[] args) {
//        threadPoolExecutorTest();

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);


    }


    public static void threadPoolExecutorTest() {
        ExecutorService exePool = new ThreadPoolExecutor(2, 4, 0L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy()); //标准线程池

        for (int num = 0; num < 100; num++) {
            int finalNum = num;
            exePool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "     " + finalNum);
            });
        }
    }

}