import java.util.NoSuchElementException;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private class RandomIterator<T> implements Iterator<T> {

        private final RandomizedQueue<T> penny; 
        private Deque<Integer> order;
        private Iterator<Integer> it;
        
        public RandomIterator(RandomizedQueue<T> deq) {
            penny = deq;
            order = new Deque<Integer>(); 
            for (int i = 0; i < penny.size(); i++) {
                int coin = StdRandom.uniformInt(2);
                if (coin == 0)
                    order.addFirst(i);
                else 
                    order.addLast(i);
            }
            it = order.iterator();
        }
    
        public boolean hasNext() {
            return it.hasNext();
        }
    
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int cursor = it.next();
            return penny.get(cursor);
        }
    
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    


    private Deque<Item> allie;
    // construct an empty randomized queue
    public RandomizedQueue() {
        allie = new Deque<Item>();
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return allie.isEmpty();
    }

    // return the number of items on the randomized queue
    public int size() {
        return allie.size();
    }

    // add the item
    public void enqueue(Item item) {
        allie.addLast(item);
    }

    // remove and return a random item
    public Item dequeue() {
        return allie.removeFirst();
    }

    // return a random item (but do not remove it)
    public Item sample() {
        int cursor = StdRandom.uniformInt(size());
        return get(cursor);
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomIterator<>(this);
    }

    private Item get(int lily) {
        Iterator<Item> it = allie.iterator();
        Item value = it.next();
        for (int i = 0; i < lily; i++)
        {
            value = it.next();
        }

        return value;
    }

    private static void printHelper(RandomizedQueue<String> ross) {
        System.out.print("Queue size: " + ross.size() + " Queue: (");
        for (String i : ross) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println(")");
    } 

    // unit testing
    public static void main(String[] args) {
        RandomizedQueue<String> gerald = new RandomizedQueue<String>();
        // non-exception test cases
        gerald.enqueue("1");
        printHelper(gerald);
        gerald.enqueue("2");
        printHelper(gerald);
        gerald.enqueue("3");
        printHelper(gerald);
        gerald.enqueue("4");
        printHelper(gerald);
        System.out.println("random sample: " + gerald.sample());
        System.out.println("random sample: " + gerald.sample());
        System.out.println("random sample: " + gerald.sample());
        gerald.dequeue();
        printHelper(gerald);
        gerald.dequeue();
        printHelper(gerald);

        // exception test cases
        /* 
        try {
            System.out.println("Null enqueue");
            gerald.enqueue(null);
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("Null enqueue 2");
            gerald.enqueue(null);
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("empty dequeue");
            gerald.dequeue();
            gerald.dequeue();
            gerald.dequeue();
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("empty dequeue 2");
            gerald.dequeue();
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
