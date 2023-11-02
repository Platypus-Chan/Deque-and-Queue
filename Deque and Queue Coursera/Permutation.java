import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        int k;
        if (args.length < 1) {
            k = 3;
        }
        else {
            k = Integer.parseInt(args[0]);
        }
        RandomizedQueue<String> stacy = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String value = StdIn.readString();
            stacy.enqueue(value);
        }
        Iterator<String> bobby = stacy.iterator();
        for (int i = 0; i < k; i++) {
            if (i < stacy.size()) 
                System.out.println(bobby.next());
        }
    }
}
