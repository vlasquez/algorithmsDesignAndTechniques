package week3;

public class OnlineAdPlacement {

  public static void main (String[] args){
    int[] a = new int[]{1,3,-5};
    int[]b = new int[]{-2,4,1};
    System.out.println(maxDotProduct(a,b));
  }
  public static long maxDotProduct(int[]a, int[] b){
    long res = 0;
    a= sortArray(a);
    b=sortArray(b);

    for(int i = a.length-1; i>=0; --i){
      res += a[i]*b[i];

    }
    return res;
  }
  public static int[] sortArray(int[]a){
    boolean swaped;
    int temp;
    for (int i =0;i<a.length-1;++i){
      swaped = false;
      for(int j = 0; j<a.length - i - 1; ++j ){
        if(a[j]>a[j+1]){
          temp = a[j];
          a[j]=a[j+1];
          a[j+1] = temp;
          swaped = true;
        }
      }
      if(!swaped){
        break;
      }
    }
    return a;
  }
}
