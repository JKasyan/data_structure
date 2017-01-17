package arrays;

import java.lang.reflect.Array;

/**
 * Created by kasyan on 1/10/17.
 */
public class HighArray<T> {

    private T[] elements;

    public HighArray(Class<? extends T> clazz) {
        elements = (T[])Array.newInstance(clazz, 10);
    }
}
