package sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by kasyan on 2/5/17.
 */
public class PartitionTest {

    @Test
    public void partition() throws Exception {
        String arrayNumbersStringData = "149 192 47 152 159 195 61 66 17 167 118 64 27 80 30 105";
        Integer[] numbers = stringOfNumbersToArray(arrayNumbersStringData);
        Partition.myPartition(numbers, 99);
        String arrayNumbersStringExpected = "30 80 47 27 64 17 61 66 195 167 118 159 152 192 149 105";
        Integer[] numbersExpected = stringOfNumbersToArray(arrayNumbersStringExpected);
        assertArrayEquals(numbersExpected, numbers);
    }

    private Integer[] stringOfNumbersToArray(String numbers) {
        return Arrays.stream(numbers.split(" "))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }

}