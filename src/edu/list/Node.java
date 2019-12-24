package edu.list;

class Node {
    private Node nextNode;
    private Node prevNode;
    private Object value;

    Node(){
        nextNode = null;
        prevNode = null;
        value = null;
    }

    Node(Object value) {
        prevNode = null;
        nextNode = null;
        this.value = value;
    }

    Node(Node prev, Node next, Object value) {
        prevNode = prev;
        nextNode = next;
        this.value = value;
    }

    Object getValue(){
        return value;
    }

    Node getNextNode(){
        return nextNode;
    }

    Node getPrevNode(){
        return prevNode;
    }

    void changeNextNode( Node newNode){
        nextNode = newNode;
    }

    void changePrevNode(Node newNode){
        prevNode = newNode;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) {
            return (false);
        }
        Node oAsNode = (Node) o;

        return this.value.equals(oAsNode.value);
    }

    @Override
    public String toString(){
        if (value == null){
            return "null";
        }
        return value.toString();
    }

}
