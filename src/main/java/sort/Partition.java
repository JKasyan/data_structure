package sort;

import java.util.Arrays;

/**
 * Created by kasyan on 2/5/17.
 */
public class Partition {

    public static void myPartition(Integer[] array, long number) {
        System.out.println(Arrays.toString(array));
        int a = 0;
        int b = array.length - 1;
        while (a != b) {
            if (array[a] > number && number > array[b]) {
                swap(array, a, b);
            } else if(array[a] < number && array[b] > number){
                a++;
            } else {
                b--;
            }
        }
        System.out.println("a = " + a);
        System.out.println(Arrays.toString(array));
    }

    private static void swap(Integer[] array, int a, int b) {
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void partition(Integer[] array, long pivot) {
        int leftPartition = 1;
        int rightPartition = array.length;
        while (true) {
            while (leftPartition < array.length - 1 && array[++leftPartition] < pivot);
            while (rightPartition > -1 && array[--rightPartition] > pivot);
            if(leftPartition >= rightPartition) {
                break;
            } else {
                swap(array, leftPartition, rightPartition);
            }
        }
        System.out.println(leftPartition);
        System.out.println(Arrays.toString(array));
    }
}
