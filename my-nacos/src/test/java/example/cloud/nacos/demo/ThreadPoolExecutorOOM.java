package example.cloud.nacos.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorOOM {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(30);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        int cnt = 0;
        while(true){
            executor.execute(()->{
                while(true);
            });
            System.out.println(cnt++);
        }
    }
}
