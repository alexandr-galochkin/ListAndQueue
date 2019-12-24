package edu.list;

import java.util.*;

public class LinearList implements List {

    private int size;
    private Node first;
    private Node last;

    public LinearList() {
        first = null;
        last = null;
        size = 0;
    }

    public LinearList(Collection l) {
        this();
        size = 0;
        first = null;
        last = null;
        this.addAll(l);
    }

    public LinearList(Object value) {
        first = new Node(value);
        last = first;
        size = 1;
    }

    public Object getFirst() {
        Node f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.getValue();
    }

    public Object getLast() {
        Node l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.getValue();
    }

    @Override
    public Object get(int index) {
        if ((index < 0) || (index >= size)) {
            throw new NoSuchElementException();
        }
        Node result = first;
        for (int i = 0; i < index; i++) {
            result = result.getNextNode();
        }
        return result.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }


    @Override
    public boolean add(Object o) {
        add(size, o);
        return true;
    }

    @Override
    public void add(int index, Object o) {
        if ((index > size) || (index < 0)) {
            return;
        }
        if (size == 0) {
            size = 1;
            first = new Node(o);
            last = first;
            return;
        }
        Node newNode = new Node(o);
        if (index == 0) {
            newNode.changeNextNode(first);
            first.changePrevNode(newNode);
            first = newNode;
            size++;
            return;
        }
        Node oldNode = first;
        for (int i = 0; i < index - 1; i++) {
            oldNode = oldNode.getNextNode();
        }
        newNode.changeNextNode(oldNode.getNextNode());
        newNode.changePrevNode(oldNode);
        if (oldNode.getNextNode() != null) {
            oldNode.getNextNode().changePrevNode(newNode);
        }
        oldNode.changeNextNode(newNode);
        if (index == size) {
            last = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node x = first; x != null; x = x.getNextNode()) {
                if (x.getValue() == null) {
                    removeNode(x);
                }
            }
        } else {
            for (Node x = first; x != null; x = x.getNextNode()) {
                if (o.equals(x.getValue())) {
                    removeNode(x);
                }
            }
        }
        return true;
    }

    @Override
    public Object remove(int index) {
        if ((index < 0) || (index >= size)) {
            return null;
        }
        if (size == 1) {
            Object result = first.getValue();
            first = null;
            last = null;
            size = 0;
            return result;
        }
        if (index == 0) {
            Object result = first.getValue();
            first = first.getNextNode();
            first.changePrevNode(null);
            size--;
            return result;
        }
        if (index == size - 1) {
            Object result = last.getValue();
            last = last.getPrevNode();
            last.changeNextNode(null);
            size--;
            return result;
        }
        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.getNextNode();
        }
        Node head = x.getPrevNode();
        head.changeNextNode(x.getNextNode());
        x.getNextNode().changePrevNode(head);
        size--;
        return x.getValue();
    }

    private void removeNode(Node x) {
        if (x.getPrevNode() == null) {
            first = x.getNextNode();
            if (x.getNextNode() == null) {
                last = null;
            }
        } else if (x.getNextNode() == null) {
            last = x.getPrevNode();
            x.getPrevNode().changeNextNode(null);
        } else {
            x.getPrevNode().changeNextNode(x.getNextNode());
            x.getNextNode().changePrevNode(x.getPrevNode());
        }
        size--;
    }

    @Override
    public boolean addAll(Collection c) {
        return (addAll(size, c));
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if ((index > size) || (index < 0)) {
            return false;
        } else if (index == 0) {
            this.addAllToBeginning(c);
            return true;
        }
        Object[] arrOfCollection = c.toArray();
        if (arrOfCollection.length != 0) {
            Node head = first;
            for (int i = 0; i < index - 1; i++) {
                head = head.getNextNode();
            }
            Node tail = head.getNextNode();
            for (Object t : arrOfCollection) {
                Node newNode = new Node(t);
                head.changeNextNode(newNode);
                newNode.changePrevNode(head);
                head = newNode;
            }
            if (index == size) {
                last = head;
            }
            head.changeNextNode(tail);
            if (tail != null) {
                tail.changePrevNode(head);
            }
            size += arrOfCollection.length;
        }
        return true;
    }

    private void addAllToBeginning(Collection c) {
        Object[] arrOfCollection = c.toArray();
        if (arrOfCollection.length != 0) {
            Node tail = first;
            Node currentNode = first;
            boolean flag = true;
            for (Object t : arrOfCollection) {
                if (flag) {
                    first = new Node(t);
                    currentNode = first;
                    flag = false;
                } else {
                    Node newNode = new Node(t);
                    currentNode.changeNextNode(newNode);
                    newNode.changePrevNode(currentNode);
                    currentNode = newNode;
                }
            }
            currentNode.changeNextNode(tail);
            if (tail != null) {
                tail.changePrevNode(currentNode);
            } else {
                last = currentNode;
            }
            size += arrOfCollection.length;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }


    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node x = first; x != null; x = x.getNextNode()) {
                if (x.getValue() == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node x = first; x != null; x = x.getNextNode()) {
                if (o.equals(x.getValue())) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        if (o == null) {
            for (Node x = last; x != null; x = x.getPrevNode()) {
                if (x.getValue() == null) {
                    return index;
                }
                index--;
            }
        } else {
            for (Node x = last; x != null; x = x.getPrevNode()) {
                if (o.equals(x.getValue())) {
                    return index;
                }
                index--;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (Node x = first; x != null; x = x.getNextNode()) {
            result.append(x.toString());
            if (x.getNextNode() != null) {
                result.append("; ");
            }
        }
        result.append(']');
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LinearList)) {
            return (false);
        }
        LinearList oAsList = (LinearList) o;
        if (size != oAsList.size) {
            return false;
        }
        Node current = first;
        Node currentNodeInO = oAsList.first;
        for (int i = 0; i < size; i++) {
            if (!current.equals(currentNodeInO)) {
                return false;
            }
            current = current.getNextNode();
            currentNodeInO = currentNodeInO.getNextNode();
        }
        return true;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
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
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
