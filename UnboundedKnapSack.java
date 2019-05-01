public class UnboundedKnapSack {

    private static int unboundedKnapsack(int W,
                                         int[] val, int[] wt) {

        int n = val.length;

        int max_value[] = new int[W + 1];

        for(int i = 0; i <= W; i++){
            for(int j = 0; j < n; j++){
                if(wt[j] <= i){
                    max_value[i] = Math.max(max_value[i], max_value[i - wt[j]] +
                            val[j]);
                }
            }
        }
        return max_value[W];
    }

    public static void main(String[] args) {
        int W = 100;
        int val[] = {1, 30};
        int wt[] = {1, 50};

        System.out.println(unboundedKnapsack(W,  val, wt));
    }
}
