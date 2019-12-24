package edu.queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LinkedQueueTest {

    @Test
    public void remove() {
        LinkedQueue testList1 = new LinkedQueue('a');
        LinkedQueue testList2 = new LinkedQueue(Arrays.asList(1, 2, 3));
        LinkedQueue testListExpect1 = new LinkedQueue();
        LinkedQueue testListExpect2 = new LinkedQueue(Arrays.asList(1, 3));
        testList1.remove('a');
        testList2.remove(2);
        Assert.assertEquals(testListExpect1, testList1);
        Assert.assertEquals(testListExpect2, testList2);
        testList2.remove("QWE");
        Assert.assertEquals(testList2, testList2);
    }

    @Test
    public void removeInteger() {
        LinkedQueue testList2 = new LinkedQueue(Arrays.asList(1, 2, 3));
        LinkedQueue testList3 = new LinkedQueue(Arrays.asList(1, 2, 3));
        LinkedQueue testList4 = new LinkedQueue(Arrays.asList(1, 2, 3));
        LinkedQueue testListExpect2 = new LinkedQueue(Arrays.asList(1, 3));
        LinkedQueue testListExpect3 = new LinkedQueue(Arrays.asList(1, 2));
        LinkedQueue testListExpect4 = new LinkedQueue(Arrays.asList(2, 3));
        testList2.remove(2);
        testList3.remove(3);
        testList4.remove(1);
        Assert.assertEquals(testListExpect2, testList2);
        Assert.assertEquals(testListExpect3, testList3);
        Assert.assertEquals(testListExpect4, testList4);
    }

    @Test
    public void removeFirst() {
        LinkedQueue testList1 = new LinkedQueue('a');
        LinkedQueue testList2 = new LinkedQueue(Arrays.asList(1, 2, 3));
        LinkedQueue testListExpect1 = new LinkedQueue();
        LinkedQueue testListExpect2 = new LinkedQueue(Arrays.asList(2, 3));
        testList1.remove();
        testList2.remove();
        Assert.assertEquals(testListExpect1, testList1);
        Assert.assertEquals(testListExpect2, testList2);
    }

    @Test
    public void size() {
        LinkedQueue testList1 = new LinkedQueue('a');
        LinkedQueue testList2 = new LinkedQueue(Arrays.asList(1, 2, 3));
        LinkedQueue testList3 = new LinkedQueue();
        Assert.assertEquals(testList1.size(), 1);
        Assert.assertEquals(testList2.size(), 3);
        Assert.assertEquals(testList3.size(), 0);
        testList1.remove('a');
        Assert.assertEquals(testList1.size(), 0);
    }

    @Test
    public void isEmptyTrue() {
        LinkedQueue testList1 = new LinkedQueue('a');
        LinkedQueue testList2 = new LinkedQueue();
        Assert.assertTrue(testList2.isEmpty());
        testList1.remove('a');
        Assert.assertTrue(testList1.isEmpty());
    }

    @Test
    public void isEmptyFalse() {
        LinkedQueue testList1 = new LinkedQueue('a');
        LinkedQueue testList3 = new LinkedQueue((Object) null);
        Assert.assertFalse(testList1.isEmpty());
        Assert.assertFalse(testList3.isEmpty());
    }

    @Test
    public void contains() {
        LinkedQueue testList1 = new LinkedQueue('a');
        LinkedQueue testList4 = new LinkedQueue(Arrays.asList(1, 2, 3));
        Assert.assertFalse(testList1.contains('b'));
        Assert.assertTrue(testList1.contains('a'));
        Assert.assertTrue(testList4.contains(2));
    }

    @Test
    public void containsNull() {
        LinkedQueue testList2 = new LinkedQueue();
        LinkedQueue testList3 = new LinkedQueue((Object) null);
        Assert.assertFalse(testList2.contains(null));
        Assert.assertTrue(testList3.contains(null));
    }

    @Test
    public void add() {
        LinkedQueue testList1 = new LinkedQueue('a');
        LinkedQueue testList2 = new LinkedQueue();
        LinkedQueue listExpected = new LinkedQueue(Arrays.asList('a', "b"));
        LinkedQueue listNotExpected = new LinkedQueue((Object) null);
        testList1.add("b");
        Assert.assertEquals(testList1, listExpected);
        Assert.assertNotEquals(testList2, listNotExpected);
        testList2.add('a');
        testList2.add("b");
        Assert.assertEquals(testList1, listExpected);
    }

    @Test
    public void peekInteger() {
        LinkedQueue testList2 = new LinkedQueue(Arrays.asList(1, 2, 3));
        Assert.assertEquals(testList2.peek(), 1);
    }

    @Test
    public void peek() {
        LinkedQueue testList1 = new LinkedQueue('a');
        LinkedQueue testList3 = new LinkedQueue((Object) null);
        LinkedQueue testList4 = new LinkedQueue();
        Assert.assertEquals(testList1.peek(), 'a');
        Assert.assertNotEquals(testList3.peek(), 'a');
        Assert.assertNull(testList3.peek());
        Assert.assertNull(testList4.peek());
    }

    @Test
    public void pollInteger() {
        LinkedQueue testList2 = new LinkedQueue(Arrays.asList(1, 2, 3));
        Assert.assertEquals(testList2.poll(), 1);
    }

    @Test
    public void poll() {
        LinkedQueue testList1 = new LinkedQueue('a');
        LinkedQueue testList3 = new LinkedQueue((Object) null);
        LinkedQueue testList4 = new LinkedQueue();
        Assert.assertEquals(testList1.poll(), 'a');
        Assert.assertNotEquals(testList3.poll(), 'a');
        Assert.assertNull(testList3.poll());
        Assert.assertNull(testList4.poll());
    }
}