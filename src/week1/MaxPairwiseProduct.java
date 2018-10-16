package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * @autor Andrés Velasquez
 * @since 7/10/18
 **/
public class MaxPairwiseProduct {
  public static void main(String [] args)
  {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = scanner.nextInt();
    }

    //System.out.println(getNaiveMaxPairwiseProduct(numbers));
    System.out.println(getMaxPairwiseProductFast(numbers));

    //stressTestMaxPairwiseProduct(10,100000);
  }

  static long getNaiveMaxPairwiseProduct(int[] numbers){
    long product = 0;
    int n = numbers.length;

    for (int i = 0; i<n; ++i ){
      for(int j = i +1; j<n; ++j){
        long tmp =(long) numbers[i]*numbers[j];
        product = Math.max(product,tmp);
      }
    }
    return product;
  }
  static long getMaxPairwiseProductFast(int[] numbers){
    int indx1 = 0;
    int n = numbers.length;
    for(int i = 1; i < n; ++i){
      if(numbers[i]>numbers[indx1]){
        indx1 = i;
      }
    }

    int tmp = numbers[n-1];
    numbers[n-1]=numbers[indx1];
    numbers[indx1]=tmp;
    indx1 = 0;

    for(int j =1; j<n -1; ++j) {
      if(numbers[j]>numbers[indx1]){
        indx1 = j;
      }
    }
    tmp = numbers[n-2];
    numbers[n-2]=numbers[indx1];
    numbers[indx1]=tmp;

    return (long)numbers[n -2] * numbers[n-1];
  }
  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
      try {
        br = new BufferedReader(new
            InputStreamReader(stream));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
    int nextInt() {
      return Integer.parseInt(next());
    }
  }

  /** Stress test for an algorithm
   *
   * @param n length of the mock array
   * @param m interval of random values (from 0 to m)
   */
  static void stressTestMaxPairwiseProduct(int n, int m){
    long result1, result2;
    int rnd1;
    Random r = new Random();

    /** 1. Create an infinite loop **/
    while (true){
      /** 2. Random test generator **/
      rnd1 = r.nextInt(n - 2) + 2;
      int[] numbers = new int[rnd1];

      for (int i = 0; i < rnd1; ++i ){
        numbers[i] = r.nextInt(m);
        System.out.print(numbers[i]+ " ");
      }
      //int[]numbers = new int[]{93222,87143,99876,91345};
      /** 3. An alternative, trivial and slow, but correct implementation of an algorithm **/
      result1 = getNaiveMaxPairwiseProduct(numbers);
      result2 = getMaxPairwiseProductFast(numbers);
      if(result1 == result2){
        System.out.println("OK");
      }
      else{
        System.out.println("Fuck you, you make a mistake:"+ result1 + "-"+result2);
        return;
      }
    }
  }

}
