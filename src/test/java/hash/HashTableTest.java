package hash;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 2/25/17.
 */
public class HashTableTest {
    @Test
    public void insertTest() throws Exception {
        HashTable table = new HashTable();
        table.insert(5L);
        table.insert(15L);
        table.insert(35L);
        //
        Field arrayField = table.getClass().getDeclaredField("array");
        arrayField.setAccessible(true);
        Object[] objects = (Object[])arrayField.get(table);
        System.out.println(objects.length);
        //
        Field fieldValue = objects[5].getClass().getDeclaredField("value");
        assertEquals(5L, fieldValue.get(objects[5]));
        assertEquals(15L, fieldValue.get(objects[6]));
        assertEquals(35L, fieldValue.get(objects[7]));
        //
        Method[] methods = HashTable.class.getMethods();
        for(Method m:methods) {
            if(m.isAnnotationPresent(InvokeMethod.class)) {
                m.invoke(table);
            }
        }
    }

    @Test
    public void deleteTest() throws Exception {
        HashTable table = new HashTable();
        table.insert(5L);
        table.insert(15L);
        table.insert(35L);

        boolean firstRes = table.delete(5L);
        boolean secondRes = table.delete(35L);
        boolean thirdRes = table.delete(100L);

        assertEquals(true, firstRes);
        assertEquals(true, secondRes);
        assertEquals(false, thirdRes);

        Field arrayField = HashTable.class.getDeclaredField("array");
        arrayField.setAccessible(true);
        Object[] array = (Object[])arrayField.get(table);
        Field fieldValue = array[5].getClass().getDeclaredField("value");
        assertEquals(-1L, fieldValue.get(array[5]));
        assertEquals(15L, fieldValue.get(array[6]));
        assertEquals(-1L, fieldValue.get(array[7]));
    }

}