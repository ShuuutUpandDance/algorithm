package sort;

import utils.Utils;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = Utils.generateNums(10, 20);
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println("\n=========================");

        insertSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int j = i - 1;
            while (target < nums[j]) {
                nums[j + 1] = nums[j];
                if ((j--) == 0) {
                    break;
                }
            }
            nums[j + 1] = target;
        }
    }
}
