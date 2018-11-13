package week2;

public class FibonacciNumberModule {

  public static void main (String[]args){
    int n =2015, m=3;
    System.out.println(fibonacciNumberModule(n,m));
  }
  public static int fibonacciNumberModule(int n , int m){
    n = (n%8)%m;
    if (n <= 1) {
      return n;
    }
    int[] nFibonacci = new int[n + 1];
    nFibonacci[0] = 0;
    nFibonacci[1] = 1;

    for (int i = 2; i <= n; ++i) {
      nFibonacci[i] = nFibonacci[i - 1] + nFibonacci[i - 2];
    }

    return nFibonacci[n]%m;
  }
}
