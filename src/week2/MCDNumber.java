package week2;

/**
 * @autor Andrés Velasquez
 * @since 10/15/18
 **/
public class MCDNumber {
  public static void main(String[] args) {
    int a = 2366;
    int b = 273;
    System.out.println(getMaxMCDNumberNaive(a, b));
    System.out.println(getMaxMCDNumberFast(a, b));
  }

  static int getMaxMCDNumberNaive(int a, int b) {
    int d = 0;
    for (int i = 1; i <= a + b; ++i) {
      if (a % i == 0 && b % i == 0) {
        if (i > d) {
          d = i;
        }
      }
    }

    return d;
  }

  /**
   * Euclidian algorithm for compute the GCD using recursion
   *
   * @param a first integer
   * @param b second integer
   * @return the largest common divisor
   */
  static int getMaxMCDNumberFast(int a, int b) {
    if (b == 0) {
      return a;
    }

    int r = a % b;

    return getMaxMCDNumberFast(b, r);
  }
}
