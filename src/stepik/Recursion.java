package stepik;

public class Recursion {

    // Compute power 2^n recursively.
    //
    // The computation must use _tail recursion_!
    // Note: This requires the implementation of a tail recursive
    //       auxiliary method that is called by pow2()!)
    public static int pow2(int n) {
        if(n==0){return 1;}
        return pow2(n-1)*2;
    }
    // Compute the sum of factors (divisors) of n
    // The factors include 1 but exclude n, e.g., sumFactors(6) ==
    // 1+2+3 == 6 .
    //
    //
    //
    public static int sumFactors(int n) {
        return sumFactorsHelper(n, 1, 0);
    }
    private static int sumFactorsHelper(int n, int i, int counter){
        if(i >= n){return counter;}
        if(n%i == 0){counter+=i;}
        return sumFactorsHelper(n, i+1, counter);
    }

    // Test your implementation.
    //
    public static void main(String[] args) {
       System.out.println(pow2(5));
       System.out.println(sumFactors(6));
    }
}