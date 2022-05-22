public class Main {
    public static final long SLEEP = 1000;
    public static final int DIMENSION = 500000;
    public static final int MAX_VALUE = 1000;

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threads = new ThreadGroup("threads");

        new Thread(threads, () -> new Shop(Shop.generateReceiptsArray(DIMENSION, MAX_VALUE)).calculateCash()).start();
        new Thread(threads, () -> new Shop(Shop.generateReceiptsArray(DIMENSION, MAX_VALUE)).calculateCash()).start();
        new Thread(threads, () -> new Shop(Shop.generateReceiptsArray(DIMENSION, MAX_VALUE)).calculateCash()).start();
        new Thread(threads, () -> new Shop(Shop.generateReceiptsArray(DIMENSION, MAX_VALUE)).calculateCash()).start();

        while (threads.activeCount() > 0) {
            Thread.sleep(SLEEP);
        }

        System.out.println(Shop.getAdder().sum());
    }
}
