package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static long getRandomLargeNumber(long min, long max) {
        long number = ThreadLocalRandom.current().nextLong(min, max);
        return number;
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }

}
