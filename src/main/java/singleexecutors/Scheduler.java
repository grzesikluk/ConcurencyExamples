import java.util.concurrent.*;

/**
 * Created by Lukasz on 2017-02-27.
 */
public class Scheduler {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Hello Zoo");
//        Callable<String> task2 = () -> "Monkey";
        Runnable task2 = () -> System.out.println("Monkey");
        Future<?> result1 = service.scheduleAtFixedRate(task1, 10, 2, TimeUnit.SECONDS);
        Future<?> result2 = service.scheduleAtFixedRate(task2, 20, 3,  TimeUnit.SECONDS);
    }

}
