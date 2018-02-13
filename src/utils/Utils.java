package utils;

import java.util.ArrayList;
import java.util.List;
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

    public static List<Integer> generateNumsList(int max, int n) {
        List<Integer> numsList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numsList.add(random.nextInt(max));
        }
        return numsList;
    }
}
