package week2;

/**
 * @autor Andrés Velasquez
 * @since 10/15/18
 **/
public class LCMNumber {
  public static void main(String[] args) {
    int a = 14159572;
    int b = 63967072;
    System.out.println(LCMNumber(a, b));
  }

  static long LCMNumber(int a, int b) {
    long r = ((long)a * (long)b);
    return (r / getMaxMCDNumberFast(a, b));
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
