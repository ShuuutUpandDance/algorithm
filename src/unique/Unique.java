package unique;

import java.util.Arrays;
import java.util.Random;

public class Unique {
    public static void main(String[] args) {
        int[] nums = generateNums(10, 20);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        Arrays.sort(nums); //先使用内置方法排序

        System.out.println("========================");

//        uniqueLeft(nums);
        uniqueRight(nums);
    }

    /**
     * 右边界控制法
     * @param nums
     */
    private static void uniqueRight(int[] nums) {
        if (nums.length == 0)
            return;

        int left = 0, right = 0;
        for (; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                System.out.println(nums[left] + ": " + (right - left));
                left = right;
            }
        }
        // 此时右边界抵达终点，循环退出，但是最后一个数的计数尚未输出，所以要单独输出一次
        System.out.println(nums[left] + ": " + (right - left));
    }

    /**
     * 左边界控制法
     * @param nums
     */
    private static void uniqueLeft(int[] nums) {
        if (nums.length == 0)
            return;

        int left = 0, right = 0;

        for (; left < nums.length; left = right) {
            for (; right < nums.length; right++) {
                if (nums[left] != nums[right])
                    break;
            }
            System.out.println(nums[left] + ": " + (right - left));
        }
    }

    /**
     * 生成随机整数列
     * @param max [0,max)的整数列
     * @param n   长度为n
     * @return
     */
    private static int[] generateNums(int max, int n) {
        int[] nums = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(max);
        }
        return nums;
    }
}
