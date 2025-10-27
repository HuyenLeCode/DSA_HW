package edu.princeton.cs.algs4;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner sc = new Scanner( System.in ) ;
        int n = sc.nextInt() ;
        int [] a = new int [n] ;

        for ( int i = 0 ; i < n ; i++) {
            a[i] = sc.nextInt() ;
        }

        for ( int i = 0 ; i < n - 1 ; i++) {
            int pos = i ;
            for ( int j = i + 1 ; j < n ; j++) {
                if( a[j] < a[pos] ) {
                    pos = j ;
                }
            }
            // swap
            int tmp = a[i] ;
            a[i] = a[pos] ;
            a[pos] = tmp ;
        }

        for ( int x : a ) {
            System.out.print( x + " ");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start) ;
    }
}

/*
Độ phức tạp: O(n^2)
 */
