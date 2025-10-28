import java.io.*;
import java.util.*;

public class PQ_JavaStringRevese {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s) ;
        sb.reverse()  ;
        if ( s.equals(sb.toString())) System.out.println("Yes") ;
        else System.out.println("No") ;
    }
}



