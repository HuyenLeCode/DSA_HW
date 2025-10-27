import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class B7_FindtheMedian {
    public static int partition( int []a, int n, int l, int r) {
        int pivot = a[r] ;
        int i = l ;

        for ( int j = l ; j <= r - 1 ; j++) {
            if ( a[j] <= pivot) {
                int tmp = a[i];
                a[i] = a[j] ;
                a[j] = tmp ;

                i++;
            }
        }

        // swap a[r], a[i]
        if( i == n/2) return a[r] ;
        int tmp = a[r];
        a[r] = a[i] ;
        a[i] = tmp ;

        if( i > n/2) return partition(a, n, l, i-1) ;   // median o mang ben trai < pivot
        return partition(a, n, i+1 , r) ;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;

        int []a = new int[n] ;
        for ( int i = 0 ; i < n ; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print( partition(a,n,0,n-1) );
    }
}

/*
Độ phức tạp trung bình: O(n)
Xấu nhất: O(n^2)
 */
