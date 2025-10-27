public class PriorityQueue {
    private static final int K = 1000;
    private int[] a = new int[K];
    private int size = 0;

    public void insert(int x) {
        if (size >= K) {
            System.out.println("Queue is full!");
            return;
        }
        a[size] = x;
        size++;
    }

    public int deleteMin() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }

        int result = a[minIndex];
        a[minIndex] = a[size - 1];
        size--;

        return result;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert(5);
        pq.insert(2);
        pq.insert(9);
        pq.insert(1);

        System.out.println(pq.deleteMin()); // 1
        System.out.println(pq.deleteMin()); // 2
        System.out.println(pq.deleteMin()); // 5
    }
}
