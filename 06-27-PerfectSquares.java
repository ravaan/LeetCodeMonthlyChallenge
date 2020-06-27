class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int maxI = (int) Math.sqrt(n) + 1;

        int[] sa = new int[maxI];

        for (int i = 1; i < maxI; i++)
            sa[i] = i * i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < maxI; j++) {
                if (i < sa[j]) break;
                ;
                dp[i] = Math.min(dp[i], dp[i - sa[j]] + 1);
            }
        }
        return dp[n];
    }
}