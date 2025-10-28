import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestMinPQ {
    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<>();
        while (!StdIn.isEmpty()) {
            pq.insert(StdIn.readInt());
        }
        while (!pq.isEmpty()) {
            StdOut.println(pq.delMin());
        }
    }
}