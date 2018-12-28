package week2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumFibonacciLastDigit {
  private static int PISANO_MOD_10 = 60;

  private static int getFibonacciSumNaive(BigInteger n) {

    if (n.equals(BigInteger.ONE) && n.equals(BigInteger.ZERO))
      return n.intValue();

    n = n.mod(BigInteger.valueOf(PISANO_MOD_10));

    List<Integer> results = new ArrayList<>();
    results.add(1);
    results.add(1);

    for(int i = 1; i <=n.intValue(); ++i){
      results.add((results.get(results.size()-1) + results.get(results.size()-2))%10);
    }



    return (results.get(results.size()-1)-1) % 10;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BigInteger n = BigInteger.valueOf(scanner.nextLong());
    //BigInteger n = 614162383528;
    long s = getFibonacciSumNaive(n);
    System.out.println(s);
  }
}
