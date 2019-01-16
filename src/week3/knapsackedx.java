package week3;
import java.util.Scanner;
public class knapsackedx {
  public static double getOptimalValue(int capacity, int[]values,int[] weights){
    double totalValue = 0;

    int minItem,bestItem;
    for(int i =0 ; i<=values.length-1;++i){
      if(capacity==0){
        return totalValue;
      }
      bestItem = bestItem(values.length,values,weights);
      minItem = Math.min(weights[bestItem],capacity);
      totalValue = totalValue + minItem*((double)values[bestItem]/(double)weights[bestItem]);
      weights[bestItem]=weights[bestItem]-minItem;
      capacity = capacity-minItem;
    }

    return totalValue;
  }
  public static int bestItem(int items,int[]values,int[]weights){
    double maxValuePerWeight = 0;
    int bestItem = 0;
    for(int i  = 0 ; i <=items-1;++i){
      if(weights[i]>0){
        double valweight = (double)values[i]/(double)weights[i];
        if(valweight >maxValuePerWeight){
          maxValuePerWeight = valweight;
          bestItem = i;
        }
      }
    }
    return bestItem;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int capacity = scanner.nextInt();
    int[] values = new int[n];
    int[] weights = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = scanner.nextInt();
      weights[i] = scanner.nextInt();
    }
    System.out.println(getOptimalValue(capacity, values, weights));
  }
}

