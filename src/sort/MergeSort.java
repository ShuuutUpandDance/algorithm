package sort;

import utils.Utils;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = Utils.generateNums(10, 7);
//        int[] nums = {3,2,1};
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println("\n=========================");

        mergeSort(nums, 0, nums.length);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low + 1 < high) { // 递归终止条件
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid, high);
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] arr = new int[high - low];

        int i = low, j = mid;
        for (int k = 0; k < arr.length; k++) {
            if (i == mid) arr[k] = nums[j++];
            else if (j == high) arr[k] = nums[i++];
            else if (nums[j] < nums[i]) arr[k] = nums[j++];
            else arr[k] = nums[i++];
        }

        //将辅助数组中的数据复制给原数组
        for (int k = low, m = 0; k < high; k++, m++) {
            nums[k] = arr[m];
        }
    }
}
