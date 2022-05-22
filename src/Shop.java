import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop {
    private static Random random = new Random();
    private int[] receiptsArray;
    private static LongAdder adder = new LongAdder();
    private String name;


    public Shop(int[] receiptsArray) {
        this.receiptsArray = receiptsArray;
    }

    public static int[] generateReceiptsArray(int dimension, int maxValue) {
        int[] receipts = new int[dimension];

        for (int i = 0; i < dimension; i++) {
            receipts[i] = Math.abs(random.nextInt(maxValue));
        }
        return receipts;
    }

    public static LongAdder getAdder() {
        return adder;
    }

    public void calculateCash() {
        int sum = Arrays.stream(receiptsArray).sum();
        System.out.printf("%s: %d\n",Thread.currentThread().getName(),  sum);
        adder.add(sum);
     }
}
