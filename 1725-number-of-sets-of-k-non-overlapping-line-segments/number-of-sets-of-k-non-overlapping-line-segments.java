class Solution {
    // Approach 1: Dynamic Programming
    // private static final int MOD = 1000000007;

    // Approach 2: Combinatorics
    private static final long MOD = 1000000007L;

    private long quickPow(long a, long e) {
        long result = 1;
        while (e > 0) {
            if ((e & 1) != 0) result = (result * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return result;
    }

    public int numberOfSets(int n, int k) {
        // Approach 1: Dynamic Programming

        // int[] dp = new int[n];
        // int[] prefixSums = new int[n + 1];
        // for (int j = 0; j < n; j++) {
        //     dp[j] = 1;
        //     prefixSums[j + 1] = (prefixSums[j] + dp[j]) % MOD;
        // }
        // for (int i = 1; i <= k; i++) {
        //     dp[0] = 0;
        //     for (int j = 1; j < n; j++) {
        //         dp[j] = (dp[j - 1] + prefixSums[j]) % MOD;
        //     }
        //     for (int j = 0; j < n; j++) {
        //         prefixSums[j + 1] = (prefixSums[j] + dp[j]) % MOD;
        //     }
        // }
        // return dp[n - 1];

        // Approach 2: Combinatorics
        int m = 2 * k;
        long numerator = 1, denominator = 1;
        for (int i = 1; i <= m; i++) {
            numerator = (numerator * (n + k - i)) % MOD;
            denominator = (denominator * i) % MOD;
        }
        return (int) ((numerator * quickPow(denominator, MOD - 2)) % MOD);
    }
}