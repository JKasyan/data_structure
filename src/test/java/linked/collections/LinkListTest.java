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
        String linkListToString = linkList.toString();
        assertEquals("LinkList[1, 2]", linkListToString);
    }

}