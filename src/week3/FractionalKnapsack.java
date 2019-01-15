package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FractionalKnapsack {

  public static void main(String[] args) {
    int knapsack = 10;
    HashMap<Integer, List<Integer>> items = new HashMap<>();
    items.put(0, Arrays.asList(20,20));
    items.put(1, Arrays.asList(10,5));
    items.put(2, Arrays.asList(20,4));
    System.out.println(knapsackFast(items,knapsack
    ));
  }

  public static List<Integer> knapsackFast(HashMap<Integer,List<Integer>> items, int knapsack){
    List<Integer> amount = new ArrayList<>();
    int total = 0;

    for (int aux = 0; aux<items.size();++aux){
      if(knapsack == 0){
        return amount;
      }
      int best = bestItem(items);
      int min = Math.min(items.get(best).get(1),knapsack);

      total = total + min*(items.get(best).get(0)/items.get(best).get(1));
      items.get(best).set(1,items.get(best).get(1) - min);
      amount.set(best,amount.get(best)-min);
      knapsack = knapsack - min;
    }
    return amount;
  }
  public static int bestItem(HashMap<Integer, List<Integer>> items){
    int maxValuePerWeight = 0, bestItem = 0;

    for(int i  = 0 ; i < items.size();++i){
      if(items.get(i).get(1)>0){
        int valweight = items.get(i).get(0)/items.get(i).get(1);
        if(valweight >maxValuePerWeight){
          maxValuePerWeight = valweight;
          bestItem = i;
        }
      }
    }
    return bestItem;
  }
}
