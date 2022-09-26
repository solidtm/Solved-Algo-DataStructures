package com.solid.algolearning.javacode.algorithms.greedy;
import java.text.DecimalFormat;
import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        DecimalFormat decimal = new DecimalFormat("#.##"); // this class rounds off the double upto 2 decimal places

        double[] weights = {2, 1, 6, 0.5, 0.25, 7};
        double[] values = {50, 70, 100, 50, 30, 99};
        int capacity = 10;

        double maxValue = getMaxValue(weights, values, capacity);
        System.out.println("Maximum value we can obtain = " + decimal.format(maxValue));
    }

    static class ItemValue{ // item value class
        Double cost;
        double w, v, i;

        public ItemValue(double weight, double value, int index){ // constructor
            w = weight;
            v = value;
            i = index;
            cost = v / w;
        }
    }

    private static double getMaxValue(double[] w, double[] v, double c) {
        int totalItems = v.length;
        ItemValue[] iVal = new ItemValue[totalItems];

        for (int i = 0; i < totalItems; i++) {   //put each item with their value and calculate their cost
            iVal[i] = new ItemValue(w[i], v[i], i);
        }

        //sorting items by value;
        Arrays.sort(iVal, (sampleObj1, sampleObj2) -> sampleObj2.cost.compareTo(sampleObj1.cost));

        double totalValue = 0;
        for (ItemValue i: iVal) { // iterator to traverse items list
            double currWeight = i.w;
            double currValue = i.v;

            if (c - currWeight >= 0){  // this item can be picked as whole
                c -= currWeight;
                totalValue += currValue;

                // uncomment the following line to see the step by step working of this function
                 System.out.println("c, v, t = " + c + ", " + currValue + ", " + totalValue);
            } else { // item can't be picked as whole
                double fraction = (c / currWeight); // only a fraction of it can be obtained!
                c -=  (currWeight * fraction);
                totalValue += (currValue * fraction);

                // uncomment the following line to see the step by step working of this function
                 System.out.println("c, v, t = " + c + ", " + currValue + ", " + totalValue + "\n");
                break;
            }
        }
        return totalValue;
    }
}
