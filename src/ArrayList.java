import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList {

    public int[] list;
    public int size;
    public static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this.list = new int[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        this.list = new int[capacity];
    }

    private void resize(int newSize) {
        int[] auxarray = new int[newSize];
        for (int i=0; i < this.list.length; i++) {
            auxarray[i] = this.list[i];
        }
        this.list = auxarray;
    }

    private void checkCapacity(int newSize) {
        if (newSize > this.list.length) {
            resize(Math.max(newSize, this.list.length * 2));
        }
    }

    public boolean add(int element) {
        checkCapacity(this.size + 1);
        this.list[this.size++] = element;
        return true;
    }

    public void addByIndex(int index, int element) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        checkCapacity(this.size + 1);
        shiftRight(index);

        this.list[index] = element;
        size++;
    }

    public int removeByIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        int element = this.get(index);
        shiftLeft(index);
        this.size -= 1;

        return element;
    }
    private void shiftRight(int index) {
        for (int i = this.size; i > index; i--) {
            this.list[i] = this.list[i - 1];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.list[index];
    }

    public void removeElement(int element) {

        if (!contains(element)) {
            throw new NoSuchElementException();
        }
        removeByIndex(indexOf(element));
    }

    public int indexOf(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.list[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.list);
    }
}