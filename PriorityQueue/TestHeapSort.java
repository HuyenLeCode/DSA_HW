import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestHeapSort {
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Heap.sort(a);
        for (String s : a) {
            StdOut.println(s);
        }
    }
}