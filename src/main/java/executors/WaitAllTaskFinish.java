package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lukasz on 2017-02-27.
 */
public class WaitAllTaskFinish {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            // Add tasks to the thread executor
            service.submit(()->{
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        } finally {
            if (service != null) service.shutdown();
        }
        if (service != null) {
            service.awaitTermination(1, TimeUnit.MINUTES);
            // Check whether all tasks are finished
            if (service.isTerminated())
                System.out.println("All tasks finished");
            else
                System.out.println("At least one task is still running");
        }
    }

}
