import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static void insertionSort2(int n, List<Integer> arr) {
        for( int i = 1 ; i < n ; i++) {
            int key = arr.get(i) ;
            int j = i - 1 ;             // bat dau duyet tu j = i - 1 cho den 0

            while ( j >= 0 && key <= arr.get(j)) {
                arr.set(j+1 , arr.get(j)) ;              // a[j+1] = a[j] -> day mang sang phai
                j--;
            }

            arr.set(j+1, key) ;

            for( int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println("") ;
        }
    }

}

public class B5_InsertionSort2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
