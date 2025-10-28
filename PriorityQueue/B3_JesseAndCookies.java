import java.util.PriorityQueue;
import java.util.Scanner;

public class B3_JesseAndCookies {
    public static int cookies(int K, PriorityQueue<Integer> pq) {
        int operations = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            int m1 = pq.poll();
            int m2 = pq.poll();
            pq.add(m1 + 2 * m2);
            operations++;
        }
        if (!pq.isEmpty() && pq.peek() < K) {
            return -1;
        }
        return operations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(N);
        for (int i = 0; i < N; i++) {
            pqueue.add(scanner.nextInt());
        }
        System.out.println(cookies(K, pqueue));
        scanner.close();
    }
}
