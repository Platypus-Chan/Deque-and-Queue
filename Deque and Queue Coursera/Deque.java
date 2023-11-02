import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class CustomIterator<Item> implements Iterator<Item> {

        private Node<Item> cursor;
        
        public CustomIterator(Node<Item> head) {
            cursor = head;
        }
    
        public boolean hasNext() {
            return cursor != null;
        }
    
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item v = cursor.getValue();
            cursor = cursor.getNext();
            return v;
        }
    
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node<Item> {
        private Node<Item> next;
        private Node<Item> previous;
        private Item value;
        
        public Node(Item v) {
            value = v;
            next = null;
            previous = null;
        }

        public Node<Item> getNext() {
            return next;
        }

        public void setNext(Node<Item> a) {
            next = a;
        } 

        public Node<Item> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<Item> a) {
            previous = a;
        } 

        public Item getValue() {
            return value;
        }
    }
    
    private Node<Item> head;
    private Node<Item> tail;
    private int size;
    // create an empty deque
    public Deque() {
        head = null;
        tail = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }
    
    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item a) {
        if (a == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> n = new Node<Item>(a);
        n.setNext(head);
        if (head != null) {
            head.setPrevious(n);
        }
        head = n;
        if (tail == null) {
            tail = n;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item b) {
        if (b == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> n = new Node<Item>(b);
        if (tail != null) {
            tail.setNext(n);
            n.setPrevious(tail);
        }
        tail = n;
        if (head == null) {
            head = n;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<Item> a = head;
        head = a.getNext();
        if (head != null) {
            head.setPrevious(null);
        }
        size--;
        if (tail == a) {
            tail = null;
        }
        return a.getValue();
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<Item> a = tail;
        tail = a.getPrevious();
        if (tail != null) {
            tail.setNext(null);
        }
        size--;
        if (head == a) {
            head = null;
        }
        return a.getValue();
    }

    // return an iterator over item in order from front to back
    public Iterator<Item> iterator() {
        return new CustomIterator<>(head);
    }

    private static void printHelper(Deque<String> ross) {
        System.out.print("Queue size: " + ross.size() + " Queue: (");
        for (String i : ross) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println(")");
    } 

    // unit testing
    public static void main(String[] args) {
        Deque<String> gerald = new Deque<String>();
        // non-exception test cases
        gerald.addFirst("1");
        printHelper(gerald);
        gerald.addLast("2");
        printHelper(gerald);
        gerald.addFirst("3");
        printHelper(gerald);
        gerald.addLast("4");
        printHelper(gerald);
        gerald.removeFirst();
        printHelper(gerald);
        gerald.removeLast();
        printHelper(gerald);

        // exception test cases
        /*
        try {
            System.out.println("Null input add firs");
            gerald.addFirst(null);
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("Null input add last");
            gerald.addLast(null);
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("empty remove first");
            gerald.removeFirst();
            gerald.removeFirst();
            gerald.removeFirst();
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("empty remove last");
            gerald.removeLast();
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("empty iterator");
            gerald.iterator().next();
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("remove iterator");
            gerald.iterator().remove();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        */
    }
}