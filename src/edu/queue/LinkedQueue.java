package edu.queue;

import edu.list.LinearList;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class LinkedQueue implements Queue {

    private LinearList queue;

    LinkedQueue() {
        queue = new LinearList();
    }

    LinkedQueue(Collection l) {
        queue = new LinearList(l);
    }

    LinkedQueue(Object value) {
        queue = new LinearList(value);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    private int indexOf(Object o) {
        return queue.indexOf(o);
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean add(Object o) {
        return queue.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return (queue.remove(o));
    }

    @Override
    public Object remove() {
        return (queue.remove(0));
    }

    @Override
    public boolean addAll(Collection c) {
        return (queue.addAll(c));
    }

    @Override
    public boolean offer(Object o) {
        return add(o);
    }

    @Override
    public Object peek() {
        Object result;
        try {
            result = queue.getFirst();
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object poll() {
        try {
            Object result = queue.getFirst();
            this.remove();
            return result;
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public String toString() {
        return queue.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LinkedQueue)) {
            return (false);
        }
        LinkedQueue oAsQueue = (LinkedQueue) o;
        return (queue.equals((oAsQueue.queue)));
    }


    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }


    @Override
    public Object element() {
        return null;
    }


    @Override
    public Iterator iterator() {
        return null;
    }


    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Object[] toArray() {
        return (queue.toArray());
    }
}
