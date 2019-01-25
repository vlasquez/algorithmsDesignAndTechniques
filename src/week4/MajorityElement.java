package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MajorityElement {
  public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    System.out.println(majorityElement(a));
  }

  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
      try {
        br = new BufferedReader(new InputStreamReader(stream));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
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


  public static int majorityElement(int[]a) {
    int n = a.length;
    HashMap<Integer,Integer> count = new HashMap<>();
    for(int i = 0 ; i<n;++i ){
      if(!count.containsKey(a[i])){
        count.put(a[i],1);
      }
      else{
        count.put(a[i],count.get(a[i])+1);
      }
    }
    for(Map.Entry<Integer, Integer> entry : count.entrySet()){
      if(entry.getValue()>n/2){
        return 1;
      }
    }
    return 0;
  }

}
