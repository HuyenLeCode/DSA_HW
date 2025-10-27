import java.io.*;
import java.util.*;

public class B6_QuicksortInPlace {

    public static void partition( int []a, int l, int r) {
        if( l >= r) return ;
        int pivot = a[r] ;
        int i = l ;

        for( int j = l ; j <= r - 1 ; j++) {
            if(a[j] <= pivot) {
                // swap a[i], a[j]
                int tmp = a[i] ;
                a[i] = a[j] ;
                a[j] = tmp ;

                i++;
            }
        }
        // swap pivot voi a[i] , a[r]
        int tmp = a[i] ;
        a[i] = a[r] ;
        a[r] = tmp ;

        for( int x : a ) {
            System.out.print(x + " ") ;
        }
        System.out.println("");
        partition( a, l , i - 1) ;
        partition(a, i + 1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();

        int []a = new int[n] ;
        for ( int i = 0 ; i < n ; i++) {
            a[i] = sc.nextInt();
        }

        partition(a,0,n-1);
    }
}
