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
public class MaxPairwiseNumber {
  public static void main(String [] args)
  {
    /*FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = scanner.nextInt();
    }*/
    int[] numbers2 = new int[]{100000,90000};
    //System.out.println(getNaiveMaxPairwiseProduct(numbers));
    //System.out.println(getMaxPairwiseProductFast(numbers2));

    stressTestMaxPairwiseProduct(10,10000);
  }

  static int getNaiveMaxPairwiseProduct(int[] numbers){
    int product = 0;
    int n = numbers.length;

    for (int i = 0; i<n; ++i ){
      for(int j = i +1; j<n; ++j){
          product = Math.max(product,numbers[i]*numbers[j]);
      }
    }
    return product;
  }
  static long getMaxPairwiseProductFast(int[] numbers){
    int indx1 = 0;
    int indx2;

    int n = numbers.length;
    for(int i = 1; i < n; ++i){
      if(numbers[i]>numbers[indx1]){
        indx1 = i;
      }
    }
    if(indx1 == 0){
      indx2 = 1;
    }
    else{
      indx2 = 0;
    }
    for(int j =0; j<n; ++j) {
      if(numbers[j]!=numbers[indx1] && numbers[j]>numbers[indx2]){
        indx2 = j;
      }
    }
    return (long) numbers[indx1] * numbers[indx2];
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

  static void stressTestMaxPairwiseProduct(int n, int m){
    long result1, result2;
    int rnd1;
    Random r = new Random();
    while (true){
      rnd1 = r.nextInt(n - 2) + 2;
      int[] numbers = new int[rnd1];

      for (int i = 0; i < rnd1; ++i ){
        numbers[i] = r.nextInt(m);
      }

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
