package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Lukasz on 2017-02-27.
 */
public class ShutdownExecutor {

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            // Add tasks to thread executor
            service.submit(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } finally {
            if (service != null) service.shutdown();
        }
    }


}
