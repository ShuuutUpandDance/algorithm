package sort;

import java.util.*;

public class MultiMerge {
    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        Integer[] a1 = {1, 2, 4};
        Integer[] a2 = {};
        Integer[] a3 = {2, 3, 5};
        Integer[] a4 = {3, 4, 6, 8};
        A.add(Arrays.asList(a1));
        A.add(Arrays.asList(a2));
        A.add(Arrays.asList(a3));
        A.add(Arrays.asList(a4));

        List<Integer> B = new ArrayList<>();

        //若每次都从所有路中找到最小的元素插入，复杂度为O(k)
        //目标：优化到O(logk)
        merge(A, B);

        System.out.println(B);
    }

    private static <T> void merge(List<List<T>> V, List<T> S) {
        int L = 0;
        for (List<T> aV : V) {
            L += aV.size();
        }

        MyComparator myComparator = new MyComparator();
        PriorityQueue PQ = new PriorityQueue(myComparator);

        for (List<T> tList : V) {
            for (T t : tList) {
                PQ.add((Integer) t);
            }
        }

        while (!PQ.isEmpty()) {
            Object top = PQ.poll();
            S.add((T) top);
        }
    }

    static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
}
