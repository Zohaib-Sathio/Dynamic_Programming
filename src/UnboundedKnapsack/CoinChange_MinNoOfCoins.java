package UnboundedKnapsack;

public class CoinChange_MinNoOfCoins {
    public static int minNoOfCoins(int[] coins, int sum){
        int n = coins.length;
        int[][] table = new int[n + 1][ sum + 1];
        for (int i = 0; i < n + 1 ; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(j == 0){
                    table[i][j] = 0;
                }
                if(i == 0){
                    table[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }
        for(int row = 1; row < sum; row++){
            if((row & coins[0]) == 0){
                table[1][row] = row / coins[0];
            }
            else{
                table[1][row] = Integer.MAX_VALUE - 1;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(coins[i - 1] <= j){
                    table[i][j] = Math.min(1 + table[i][j - coins[i - 1]], table[i - 1][j]);
                }
                else {
                    table[i][j] = table[i-1][j];
                }
            }
        }
        return table[n][sum];
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int sum = 153;
        System.out.println(minNoOfCoins(coins, sum));
    }
}
