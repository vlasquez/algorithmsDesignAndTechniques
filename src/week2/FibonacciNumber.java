package week2;

/**
 * @autor Andrés Velasquez
 * @since 10/15/18
 **/
public class FibonacciNumber {



  static int fibonacciNaiveSolution(int n) {
    if (n <= 1) {
      return n;
    }

    return fibonacciNaiveSolution(n - 1) + fibonacciNaiveSolution(n - 2);
  }

  static long fibonacciFastSolution(int n) {
    if (n <= 1) {
      return n;
    }
    long[] nFibonacci = new long[n + 1];
    nFibonacci[0] = 0;
    nFibonacci[1] = 1;

    for (int i = 2; i <= n; ++i) {
      nFibonacci[i] = nFibonacci[i - 1] + nFibonacci[i - 2];
    }

    return nFibonacci[n];
  }

  /**
   * Return the las digit from the nth fibonacci number
   *
   * @param n the nth fibonacci number
   * @return the last digit from the nth fibonacci
   */
  static int fibonacciLastDigitSolution(int n) {
    int[] nFibonacci = new int[n + 1];
    nFibonacci[0] = 0;
    nFibonacci[1] = 1;

    for (int i = 2; i <= n; ++i) {
      nFibonacci[i] = nFibonacci[i - 1] + nFibonacci[i - 2];
    }

    return nFibonacci[n] % 10;
  }

  /**
   * Return the las digit from the nth fibonacci number (FAST)
   *
   * @param n the nth fibonacci number
   * @return the last digit from the nth fibonacci
   */
  static int fibonacciLastDigitFastSolution(int n) {
    if (n <= 1) {
      return n;
    }
    int previous = 0, current = 1;

    for (int i = 2; i <= n; ++i) {
      int tmp = previous;
      previous = current;
      current = (tmp + previous) % 10;
    }

    return current;
  }
}
