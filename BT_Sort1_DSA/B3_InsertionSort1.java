import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n,  List<Integer> arr) {
        // chen x vao dung vi tri -> chua dung thi x2 vi tri
        int x = arr.get(n-1) ;

        for ( int i = n - 2 ; i >= 0 ; i--) {
            if( x <= arr.get(i)) {
                // nhan doi arr.get(i)
                arr.set(i + 1 , arr.get(i)) ; // a[i+1] = a[i]


                for ( int y : arr) {
                    System.out.print(y + " ") ;
                }
                System.out.println("") ;

                if(i == 0) {   // den cuoi van khong roi vao else
                    arr.set(0, x) ;
                    break ;
                }
            }
            else
            {
                arr.set(i + 1 , x) ;
                break ;
            }
        }
        for ( int y : arr) {
            System.out.print(y + " ") ;
        }
    }

}

public class B3_InsertionSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
