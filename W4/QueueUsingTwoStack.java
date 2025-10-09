import java.util.*;

public class QueueUsingTwoStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();  

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) { // enqueue
                int x = sc.nextInt();
                s1.push(x);
            }
            else if (type == 2) { // dequeue
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                if (!s2.isEmpty()) s2.pop();
            }
            else if (type == 3) { // print front
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                if (!s2.isEmpty()) {
                    System.out.println(s2.peek());
                }
            }
        }

        sc.close();
    }
}