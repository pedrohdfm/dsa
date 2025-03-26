public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Node get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        return aux;
    }

    public int addAtHead(int val) {
        Node newNode = new Node(val);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
        this.size += 1;
        return val;
    }

    public int addAtTail(int val) {
        Node newNode = new Node(val);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode.setPrev(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size += 1;
        return val;
    }

    public int addAtIndex(int index, int val) {
        if (index < 0 || index > this.size + 1) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(val);

        if (index == 0) {
            return addAtHead(val);
        }
        else if (index >=
                this.size) {
            return addAtTail(val);
        }

        else {
            Node aux = this.head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();
            }
            newNode.setNext(aux.getNext());
            newNode.setPrev(aux);
            aux.getNext().setPrev(newNode);
            aux.setNext(newNode);

            this.size += 1;
        }
        return val;
    }

    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node aux = this.head;

        if(this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }
        this.size -= 1;
        return aux;
    }

    public Node removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node aux = this.tail;
        if(this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }
        this.size -= 1;
        return aux;
    }

    public Node removeAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == this.size - 1) {
            return removeLast();
        }
        Node aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        Node newNext = aux.getNext();
        Node newPrev = aux.getPrev();
        newNext.setPrev(newPrev);
        newPrev.setNext(newNext);
        this.size -= 1;
        return aux;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node aux = this.head;
        while (aux != null) {
            sb.append(aux.toString());
            if (aux.getNext() != null) {
                sb.append(" - ");
            }
            aux = aux.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

}