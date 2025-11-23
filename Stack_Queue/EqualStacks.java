import java.util.* ;


public class EqualStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        Stack <Integer> st1 = new Stack<>();
        Stack <Integer> st2 = new Stack<>();
        Stack <Integer> st3 = new Stack<>();

        int s1 = 0, s2 =0, s3 = 0;
        int [] a1 = new int [n1] ;
        int [] a2 = new int [n2] ;
        int [] a3 = new int [n3] ;

        for ( int i = 0 ; i < n1 ; i++) {
            a1[i] = sc.nextInt() ;
            s1 += a1[i] ;
        }

        for ( int i = 0 ; i < n2 ; i++) {
            a2[i] = sc.nextInt() ;
            s2 += a2[i] ;
        }

        for ( int i = 0 ; i < n3 ; i++) {
            a3[i] = sc.nextInt() ;
            s3 += a3[i] ;
        }

        for ( int i = n1 - 1 ; i >= 0 ; i--) {
            st1.push(a1[i]) ;
        }

        for ( int i = n2 - 1 ; i >= 0 ; i--) {
            st2.push(a2[i]) ;
        }

        for ( int i = n3 - 1 ; i >= 0 ; i--) {
            st3.push(a3[i]) ;
        }
        int min_val = Math.min(s1, Math.min(s2,s3));
        for ( int i = 0 ; i <= 100000; i++) {
            if ( min_val > 0&& s1 > 0 && s2 > 0 && s3 > 0 ) {
                if ( s1 == s2 && s2 == s3 ) {
                    System.out.println(s1);
                    return ;
                }

                for ( int j = 0 ; j < 200 ; j++) {
                    if ( s1 > min_val ) {
                        if ( !st1.isEmpty()){
                            int k = st1.peek();
                            st1.pop() ;
                            s1 -= k ;
                        }
                    }
                }

                for ( int j = 0 ; j < 200 ; j++) {
                    if ( s2 > min_val ) {
                        if ( !st2.isEmpty()) {
                            int k = st2.peek();
                            st2.pop() ;
                            s2 -= k ;
                        }
                    }
                }

                for ( int j = 0 ; j < 200 ; j++) {
                    if ( s3 > min_val ) {
                        if ( !st3.isEmpty()) {
                            int k = st3.peek();
                            st3.pop() ;
                            s3 -= k ;
                        }
                    }
                }
                // update lai bien min_val
                min_val = Math.min(s1, Math.min(s2,s3));
            }
            else break ;
        }
        min_val = Math.min(s1, Math.min(s2,s3));
        System.out.println(min_val);
    }
}
