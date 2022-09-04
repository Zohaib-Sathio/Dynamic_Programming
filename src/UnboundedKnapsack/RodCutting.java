package UnboundedKnapsack;

public class RodCutting {

    /*
    Rod cutting problem is same as Topdown approach of unbounded knapsack,
    only wording is changed.
     */

    public static int rodCutting(int[] value, int[] weight, int capacity, int n){
        int[][] table = new int[n + 1][capacity + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                if(i == 0 || j == 0){
                    table[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if(weight[i - 1] <= j){
                    // if we are including the number then we do not subtract that number
                    table[i][j] = Math.max(value[i - 1] + table[i][j - weight[i - 1]], table[i - 1][j]);
                }
                else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }
        return table[n][capacity];
    }

    public static void main(String[] args) {
        int[] length = {3,5, 6};
        int[] price = {3, 4, 4};
        int capacity = 8;

        System.out.println(rodCutting(price, length, capacity, price.length));
    }
}
