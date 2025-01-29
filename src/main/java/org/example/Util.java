package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    /**
     * Generates a random integer within a specific range (minimum and maximum).
     * 
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return A random integer between the minimum and maximum values.
     * @throws IllegalArgumentException If the minimum value is greater than the maximum value.
     */
    public static int generateRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("The minimum value cannot be greater than the maximum value.");
        }

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Generates a random double within a specific range (minimum and maximum) with two decimal places.
     * 
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return A random double between the minimum and maximum values with two decimal places.
     * @throws IllegalArgumentException If the minimum value is greater than the maximum value.
     */
    public static double generateRandomDouble(double min, double max) {
        if (min > max) {
            throw new IllegalArgumentException("The minimum value cannot be greater than the maximum value.");
        }

        double randomValue = ThreadLocalRandom.current().nextDouble(min, max);
        return Math.round(randomValue * 100.0) / 100.0;  // Round to 2 decimal places
    }
}
