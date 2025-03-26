public class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}