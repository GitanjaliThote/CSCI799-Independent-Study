public class CommonChild {

    public static int longCommonChildLength(String word1, String word2) {
        int [][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i=1;i<=word1.length();i++) {
            dp[i][0]=0;
        }
        // Column initialization
        for (int j=1;j<=word2.length();j++) {
            dp[0][j]=0;
        }

        for(int i = 1; i <= word1.length(); i++){
            for (int j = 1; j <= word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[word1.length()][word2.length()];


    }

    public static void main(String[] args) {

        String word1 = "HARRY";
        String word2 = "SALLY";

        System.out.println(longCommonChildLength(word1,word2));

    }

}
