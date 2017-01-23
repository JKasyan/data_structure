package linked.collections;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 1 on 1/23/2017.
 */
public class LinkListTest {
    @Test
    public void insertFirst() throws Exception {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.insertFirst(1);
        linkList.insertFirst(2);
        linkList.insertFirst(3);
    }

    @Test
    public void toStringTest() {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.insertFirst(1);
        linkList.insertFirst(2);
        linkList.insertFirst(3);
        String linkListToString = linkList.toString();
        assertEquals("LinkList[3, 2, 1]", linkListToString);
    }

    @Test
    public void toStringEmptyTest() {
        LinkList<Integer> linkList = new LinkList<>();
        String linkListToString = linkList.toString();
        assertEquals("LinkList[]", linkListToString);
    }

    @Test
    public void deleteFirstTest() {
        LinkList<String> linkList = new LinkList<>();
        linkList.insertFirst("One");
        linkList.insertFirst("Second");
        assertEquals("Second", linkList.deleteFirst());
        assertEquals("One", linkList.deleteFirst());
    }

    @Test
    public void isEmptyTest() {
        LinkList<String> linkList = new LinkList<>();
        assertTrue(linkList.isEmpty());
    }

    @Test
    public void findTest() {
        LinkList<Character> linkList = new LinkList<>();
        linkList.insertFirst('a');
        linkList.insertFirst('b');
        linkList.insertFirst('c');
        assertTrue(linkList.find('c'));
    }

    @Test
    public void deleteTest() {
        LinkList<Long> linkList = new LinkList<>();
        for(long i = 0;i < 10;i++) {
            linkList.insertFirst(i);
        }
        assertTrue(linkList.delete(5L));
        assertFalse(linkList.find(5L));
        assertEquals("LinkList[9, 8, 7, 6, 4, 3, 2, 1, 0]", linkList.toString());
    }

    @Test
    public void deleteLastAndFirstElements() {
        LinkList<Long> linkList = new LinkList<>();
        for(long i = 0;i < 10;i++) {
            linkList.insertFirst(i);
        }
        System.out.println(linkList);
        assertTrue(linkList.delete(0L));
        assertTrue(linkList.delete(9L));
        assertFalse(linkList.find(0L));
        assertFalse(linkList.find(9L));
        assertEquals("LinkList[8, 7, 6, 5, 4, 3, 2, 1]", linkList.toString());
    }
}