import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Collections;

public class B5_FindTheRunningMedian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(N/2 + 1, Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(N/2 + 1);

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();

            if (maxPQ.isEmpty() || num < maxPQ.peek()) {
                maxPQ.add(num);
            } else {
                minPQ.add(num);
            }

            // giữ cho kích thước 2 PQ chênh lệch không quá 1
            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.poll());
            } else if (minPQ.size() > maxPQ.size()) {
                maxPQ.add(minPQ.poll());
            }

            // trung vị là đỉnh của max PQ nếu tổng số phần tử là lẻ
            // là trung bình của 2 đỉnh nếu tổng số phần tử chẵn
            if (maxPQ.size() == minPQ.size()) {
                System.out.printf("%.1f\n", (maxPQ.peek() + minPQ.peek()) / 2.0);
            } else {
                System.out.printf("%.1f\n", (double) maxPQ.peek());
            }
        }
        scanner.close();
    }
}
