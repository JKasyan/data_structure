package sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by kasyan on 2/5/17.
 */
public class PartitionTest {

    private static final String ARRAY_NUMBERS = "149 192 47 152 159 195 61 66 17 167 118 64 27 80 30 105";
    private static final String ARRAY_NUMBERS_EXPECTED = "30 80 47 27 64 17 61 66 195 167 118 159 152 192 149 105";

    @Test
    public void partition() throws Exception {
        Integer[] numbers = stringOfNumbersToArray(ARRAY_NUMBERS);
        Partition.myPartition(numbers, 99);
        Integer[] numbersExpected = stringOfNumbersToArray(ARRAY_NUMBERS_EXPECTED);
        assertArrayEquals(numbersExpected, numbers);
    }

    private Integer[] stringOfNumbersToArray(String numbers) {
        return Arrays.stream(numbers.split(" "))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }

    @Test
    public void partitionTest() {
        Integer[] numbers = stringOfNumbersToArray(ARRAY_NUMBERS);
        Partition.partition(numbers, 99);
        Integer[] numbersExpected = stringOfNumbersToArray(ARRAY_NUMBERS_EXPECTED);
        assertArrayEquals(numbersExpected, numbers);
        
    }

}