package recursion;

/**
 * Created by 1 on 1/31/2017.
 */
public class MergeSorting {

    public static int[] sort(int[] a, int[] b) {
        int size = a.length > b.length ? a.length : b.length;
        int min = a.length > b.length ? b.length : a.length;
        int[] res = new int[size];
        int posA = 0, posB = 0, pos = 0;
        while (min != pos) {
            if(a[posA] > b[posB]) {
                res[pos] = b[posB];
                posB++;
            } else {
                res[pos] = a[posA];
                posA++;
            }
            pos++;
        }
        if(posA > posB) {
            copyTail(res, a, posB, posA);
        } else {
            copyTail(res, b, posA, posB);
        }
        return res;
    }

    private static void copyTail(int[] result, int[] target, int begin, int end) {
        for (int i = begin; i < end; i++) {
            result[i] = target[i];
        }
    }
}
