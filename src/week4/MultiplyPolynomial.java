package week4;

public class MultiplyPolynomial {
  public static void main(String[] args) {
    int[] a =new int []{3,2,5};
    int[] b =new int []{5,1,2};
    multiplyPolyNaive(a,b);
    }
  public static int[] multiplyPolyNaive(int[]a, int[]b){
    int n = a.length;
    int[] product = new int[(2*n)-1];
    for(int i = 0; i<=n-1;++i){
      for(int j = 0; j<=n-1;++j){
        product[i+j] = product[i+j]+(a[i] * b[j]);
      }
    }
    return product;
  }
}
