package edu.princeton.cs.algs4;
import java.util.Scanner;
import java.util.Stack;


public class BalancedBrackets {
    public static boolean check ( String s ) {
        if ( s.length() % 2 != 0 ) return false ;
        Stack <Character> st = new Stack<>() ;

        for ( char x : s.toCharArray() ) {
            if ( x == '(' || x == '[' || x == '{') {
                st.push(x) ;
            } else {
                if ( st.isEmpty()) return false ;
                if ( x == ')' && st.peek() == '(' ) st.pop() ;
                else if ( x == ']' && st.peek() == '[') st.pop() ;
                else if ( x == '}' && st.peek() == '{') st.pop() ;
                else return false ; // khong giong 3 TH o tren
            }
        }
        if ( st.isEmpty()) return true ;
        return false ;
    }

    public static void main(String[] args) {
        System.out.println("Hello") ;
        Scanner sc = new Scanner(System.in) ;
        int t = sc.nextInt() ;
        sc.nextLine() ;
        while ( t-- > 0 ) {
            String s = sc.nextLine().trim() ;
            if ( check(s)) System.out.println("YES") ;
            else System.out.println("NO") ;
        }
    }
}
