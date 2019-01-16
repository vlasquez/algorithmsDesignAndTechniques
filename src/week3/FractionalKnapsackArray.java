package week3;

public class FractionalKnapsackArray {

  public static void main(String[] args) {
    int n = 3;
    int capacity = 50;
    int[] values = new int[]{3,60,100,120};
    int[] weights = new int[]{50,20,50,30};
    System.out.println(getOptimalValue(capacity,values,weights));
  }

  public static double getOptimalValue(int capacity, int[]values,int[] weights){
    double totalValue = 0;
    capacity = weights[0];
    int items = values[0];
    int minItem,bestItem;
    for(int i =1 ; i<=items;++i){
      if(capacity==0){
        return totalValue;
      }
      bestItem = bestItem(items,values,weights);
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

    for(int i  = 1 ; i <= items;++i){
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
}
