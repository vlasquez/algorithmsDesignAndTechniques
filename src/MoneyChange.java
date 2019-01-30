public class MoneyChange {
  public static int getChange(int m){
    int[] coins = new int[]{1,3,4};
    int[] minNumCoins = new int[m-1];
    minNumCoins[0] = 0;
    int num ;
    for(int j = 0 ;j <m;j++){
      minNumCoins[j] = 0;
      for(int i =0;i<coins.length;++i){
        if(m>=coins[i]){
          num = minNumCoins[m-coins[i]]+1;
          if(num<minNumCoins[m]){
            minNumCoins[m] = num;
          }
        }
      }
    }

    return minNumCoins[m];
  }
  public static void main(String args[]){
    int a = 2;
    System.out.println(getChange(a));
  }
}