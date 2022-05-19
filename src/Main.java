import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class Main {
    public static final long AWAIT_TIMEOUT = 5;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Set<Future> ready = new HashSet<>();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        ready.add(exec.submit(new Thread(null, () ->
                new Shop(Shop.generateReceiptsArray(100000000, 10000)).
                        setName("Магазин 1")
                        .calculateCash())));
        ready.add(exec.submit(new Thread(null, () ->
                new Shop(Shop.generateReceiptsArray(100000000, 35000))
                        .setName("Магазин 2")
                        .calculateCash())));
        ready.add(exec.submit(new Thread(null, () ->
                new Shop(Shop.generateReceiptsArray(10000000, 15000))
                        .setName("Магазин 3")
                        .calculateCash())));
        ready.add(exec.submit(new Thread(null, () ->
                new Shop(Shop.generateReceiptsArray(10000000, 1000))
                        .setName("Магазин 4")
                        .calculateCash())));


        ready.stream().map(future -> future.get()).forEach(System.out::println);
        System.out.println(Shop.getAdder().sum());
        exec.shutdown();

    }
}
