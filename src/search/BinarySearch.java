package search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {10, 20, 22, 33, 44, 66, 77, 99};

        System.out.println(binarySearch(1, nums, 0, nums.length - 1));
    }

    private static int binarySearch(int key, int[] arr, int low, int high) {

        if (low <= high) { // 终止条件
            int mid = low + (high - low) / 2;  // 尽量避免溢出
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) return binarySearch(key, arr, low, mid - 1);
            else if (arr[mid] < key) return binarySearch(key, arr, mid + 1, high);
        }

        return -1;
    }
}
