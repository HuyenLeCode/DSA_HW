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

class Result {
    static int [][] visited = new int [15][15] ;
    static int [] dx = { -1, -1, -1, 0 , 0 , 1 , 1, 1} ;
    static int [] dy = { -1, 0 , 1 , -1, 1, -1, 0 , 1 } ;
    static int cnt = 0 ;
    public static void dfs( int i , int j , List<List<Integer>> matrix, int n, int m) {
        cnt++;
        visited[i][j] = 1;
        for( int k = 0 ; k < 8 ; k++) {
            int i1 = i + dx[k];
            int j1 = j + dy[k];

            if( i1 >= 0 && i1 < n && j1 >= 0 && j1 < m && matrix.get(i1).get(j1) == 1 && visited[i1][j1] == 0 ) {
                dfs(i1,j1, matrix, n,m);
            }
        }
    }

    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        int n = matrix.size();
        int m = matrix.get(0).size();
        int ans = 0 ;
        for( int i = 0 ; i < n ; i++) {
            for ( int j = 0 ; j < m ; j++) {
                if(matrix.get(i).get(j) == 1 && visited[i][j] == 0) {
                    cnt = 0 ; // reset
                    dfs(i, j, matrix, n,m) ;
                    ans = Math.max(ans, cnt);
                }
            }
        }

        return  ans;
    }

}

public class B1_ConnectedCellsinaGrid {
    public static void main(String[] args) throws IOException {
        // Phần code có sẵn của Hackerrank
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}