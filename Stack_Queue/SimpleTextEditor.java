import java.io.*;
import java.util.*;

class Pair {
    int num;
    String cur;

    public Pair(int n, String c) {
        num = n;
        cur = c;
    }
}

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        StringBuilder s = new StringBuilder("");
        Stack<Pair> st = new Stack<>();

        while (q-- > 0) {
            int tt = sc.nextInt();

            if (tt == 1) {
                String tmp = sc.next();
                s.append(tmp);
                st.push(new Pair(1, tmp));
            } else if (tt == 2) {
                int k = sc.nextInt();
                String tmp = s.substring(s.length() - k);
                s.delete(s.length() - k, s.length());
                if (!st.isEmpty()) {
                    st.push(new Pair(2, tmp));
                }

            } else if (tt == 3) {
                int k = sc.nextInt();
                System.out.println(s.charAt(k - 1));
            } else {
                Pair top = st.pop();
                if (top.num == 1) {
                    // xoa tmp.length() phan tu cuoi cung
                    s.delete(s.length() - top.cur.length(), s.length());
                } else {
                    s.append(top.cur);
                }
            }
        }
    }
}
