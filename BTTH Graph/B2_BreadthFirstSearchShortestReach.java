import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class B2_BreadthFirstSearchShortestReach {
    static ArrayList<Integer> [] adj = new ArrayList[1005];
    static int []h = new int [1005];
    static int []vis = new int [1005];

    public static void bfs(int u) {
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        vis[u] = 1;
        h[u] = 0 ;

        while(!q.isEmpty()) {
            int t = q.poll();

            for(int v : adj[t]) {
                if(vis[v] == 0 ) {
                    q.add(v);
                    vis[v] = 1;
                    h[v] = h[t] + 1 ;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        while ( q-- > 0 ) {
            int n = sc.nextInt(); // so dinh 1 -> n
            int m = sc.nextInt(); // so canh
            // reset
            for(int i = 0 ; i < 1005 ; i++) {
                adj[i] = new ArrayList<>();
            }
            for(int i = 0 ; i < 1005 ; i++) h[i] = 0;
            for(int i = 0 ; i < 1005 ; i++) vis[i] = 0 ;


            for(int j = 0 ; j < m ; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                adj[x].add(y);
                adj[y].add(x);
            }
            int s = sc.nextInt();

            bfs(s);
            for(int i = 1 ; i <= n ; i++) {
                if(i == s) continue;
                if( h[i] != 0 ) {
                    System.out.print(6*h[i] + " ");
                } else System.out.print(-1 + " ");
            }
            System.out.println("");
        }
    }
}