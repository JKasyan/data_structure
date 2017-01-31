package recursion;

/**
 * Created by 1 on 1/31/2017.
 */
public class MergeSorting {

    public static int[] sort(int[]a, int[]b) {
        int[] res = new int[a.length + b.length];
        int posA = 0, posB = 0, posResult = 0;
        while (posA < a.length && posB < b.length) {
            if(a[posA] > b[posB]) {
                res[posResult++] = b[posB++];
            } else {
                res[posResult++] = a[posA++];
            }
        }
        while (posA < a.length) {
            res[posResult++] = a[posA++];
        }
        while (posB < b.length) {
            res[posResult++] = b[posB++];
        }
        return res;
    }

}
