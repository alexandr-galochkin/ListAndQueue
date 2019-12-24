package edu.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LinearListTest {

    @Test
    public void getFirst() {
        LinearList testList1 = new LinearList('a');
        LinearList testList2 = new LinearList(Arrays.asList(1, 2, 3));
        Assert.assertEquals(testList1.getFirst(), 'a');
        Assert.assertEquals(testList2.getFirst(), 1);
    }

    @Test
    public void getFirstNull() {
        LinearList testList3 = new LinearList((Object) null);
        Assert.assertNotEquals(testList3.getFirst(), 'a');
        Assert.assertNull(testList3.getFirst());
    }

    @Test
    public void getLast() {
        LinearList testList1 = new LinearList('a');
        LinearList testList2 = new LinearList(Arrays.asList(1, 2, 3));
        Assert.assertEquals(testList1.getLast(), 'a');
        Assert.assertEquals(testList2.getLast(), 3);
    }

    @Test
    public void getLastNull() {
        LinearList testList3 = new LinearList((Object) null);
        Assert.assertNotEquals(testList3.getLast(), 'a');
        Assert.assertNull(testList3.getLast());
    }

    @Test
    public void get() {
        LinearList testList3 = new LinearList((Object) null);
        Assert.assertNotEquals(testList3.get(0), "a");
        Assert.assertNull(testList3.get(0));
    }

    @Test
    public void getNull() {
        LinearList testList3 = new LinearList((Object) null);
        Assert.assertNotEquals(testList3.get(0), "a");
        Assert.assertNull(testList3.get(0));
    }

    @Test
    public void size() {
        LinearList testList1 = new LinearList('a');
        LinearList testList2 = new LinearList(Arrays.asList(1, 2, 3));
        Assert.assertEquals(testList1.size(), 1);
        Assert.assertEquals(testList2.size(), 3);
    }

    @Test
    public void sizeEmpty() {
        LinearList testList1 = new LinearList('a');
        LinearList testList3 = new LinearList();
        Assert.assertEquals(testList3.size(), 0);
        testList1.remove(0);
        Assert.assertEquals(testList1.size(), 0);
    }

    @Test
    public void isEmptyTrue() {
        LinearList testList1 = new LinearList('a');
        LinearList testList2 = new LinearList();
        Assert.assertTrue(testList2.isEmpty());
        testList1.remove(0);
        Assert.assertTrue(testList1.isEmpty());
    }

    public void isEmptyFalse() {
        LinearList testList1 = new LinearList('a');
        LinearList testList3 = new LinearList((Object) null);
        Assert.assertFalse(testList1.isEmpty());
        Assert.assertFalse(testList3.isEmpty());
    }

    @Test
    public void contains() {
        LinearList testList1 = new LinearList('a');
        LinearList testList2 = new LinearList();
        LinearList testList3 = new LinearList((Object) null);
        LinearList testList4 = new LinearList(Arrays.asList(1, 2, 3));
        Assert.assertFalse(testList1.contains('b'));
        Assert.assertTrue(testList1.contains('a'));
        Assert.assertTrue(testList4.contains(2));
        Assert.assertFalse(testList2.contains(null));
        Assert.assertTrue(testList3.contains(null));
    }

    @Test
    public void add() {
        LinearList testList1 = new LinearList('a');
        LinearList testList2 = new LinearList();
        LinearList listExpected = new LinearList(Arrays.asList('a', "b"));
        LinearList listNotExpected = new LinearList((Object) null);
        testList1.add(1, "b");
        Assert.assertEquals(testList1, listExpected);
        Assert.assertNotEquals(testList2, listNotExpected);
        testList2.add(0, 'a');
        testList2.add(1, "b");
        Assert.assertEquals(testList1, listExpected);
    }

    @Test
    public void removeByIndex() {
        LinearList testList1 = new LinearList('a');
        LinearList testList2 = new LinearList(Arrays.asList(1, 2, 3));
        LinearList testList3 = new LinearList(Arrays.asList(1, 2, 3));
        LinearList testList4 = new LinearList(Arrays.asList(1, 2, 3));
        LinearList testListExpect1 = new LinearList();
        LinearList testListExpect2 = new LinearList(Arrays.asList(1, 3));
        LinearList testListExpect3 = new LinearList(Arrays.asList(1, 2));
        LinearList testListExpect4 = new LinearList(Arrays.asList(2, 3));
        testList1.remove(0);
        testList2.remove(1);
        testList3.remove(2);
        testList4.remove(0);
        Assert.assertEquals(testListExpect1, testList1);
        Assert.assertEquals(testListExpect2, testList2);
        Assert.assertEquals(testListExpect3, testList3);
        Assert.assertEquals(testListExpect4, testList4);
        testList2.remove(10);
        Assert.assertEquals(testList2, testList2);
    }


    @Test
    public void removeByObject() {
        LinearList testList1 = new LinearList('a');
        LinearList testList2 = new LinearList(Arrays.asList(1, 2, 3));
        LinearList testList3 = new LinearList(Arrays.asList(1, 2, 3));
        LinearList testList4 = new LinearList(Arrays.asList(1, 2, 3));
        LinearList testListExpect1 = new LinearList();
        LinearList testListExpect2 = new LinearList(Arrays.asList(1, 3));
        LinearList testListExpect3 = new LinearList(Arrays.asList(1, 2));
        LinearList testListExpect4 = new LinearList(Arrays.asList(2, 3));
        testList1.remove((Character) 'a');
        testList2.remove((Integer) 2);
        testList3.remove((Integer) 3);
        testList4.remove((Integer) 1);
        Assert.assertEquals(testListExpect1, testList1);
        Assert.assertEquals(testListExpect2, testList2);
        Assert.assertEquals(testListExpect3, testList3);
        Assert.assertEquals(testListExpect4, testList4);
        testList2.remove("TEST");
        Assert.assertEquals(testList2, testList2);
    }

    @Test
    public void indexOf() {
        LinearList testList1 = new LinearList('a');
        LinearList testList2 = new LinearList(Arrays.asList(1, 2, 3));
        Assert.assertEquals(0, testList1.indexOf('a'));
        Assert.assertEquals(1, testList2.indexOf(2));
        Assert.assertEquals(2, testList2.indexOf(3));
        Assert.assertEquals(-1, testList2.indexOf("R"));
    }

}