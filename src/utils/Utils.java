package utils;

import java.util.Random;

public class Utils {
    public static int[] generateNums(int max, int n) {
        int[] nums = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(max);
        }
        return nums;
    }
}
