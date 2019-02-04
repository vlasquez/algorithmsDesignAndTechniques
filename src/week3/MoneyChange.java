package week3;

public class MoneyChange {


  public static void main(String[] args) {
    int change = 28;
    System.out.println(moneyChange(change));
  }

  private static int moneyChange(int m) {
    int mod = m;
    int coins = 0;

      if(mod>=6){
        coins += mod/6;
        mod = m%6;
      }
      if(mod>=5) {
        coins += mod / 5;
        mod = m % 5;
      }
      if(mod>=1){
        coins+=mod;
      }

    return coins;
  }
}
