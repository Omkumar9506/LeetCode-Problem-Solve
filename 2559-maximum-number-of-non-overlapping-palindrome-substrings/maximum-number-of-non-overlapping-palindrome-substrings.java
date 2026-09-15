class Solution {
    public int maxPalindromes(String s, int k) {
        // 1. Dynamic Programming

        // int n = s.length();
        // boolean[][] isPalindrome = new boolean[n][n];

        // for (int len = 1; len <= n; ++len) {
        //     for (int left = 0; left + len <= n; ++left) {
        //         int right = left + len - 1;
        //         isPalindrome[left][right] =
        //             s.charAt(left) == s.charAt(right) &&
        //             (len <= 2 || isPalindrome[left + 1][right - 1]);
        //     }
        // }

        // int[] dp = new int[n + 1];
        // for (int i = 1; i <= n; ++i) {
        //     dp[i] = dp[i - 1];
        //     for (int j = 0; j + k <= i; ++j) {
        //         if (isPalindrome[j][i - 1]) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //     }
        // }

        // return dp[n];

        // 2. Greedy 

        int n = s.length();
        int ans = 0,
            start = 0;

        for (int r = k - 1; r < n; ++r) {
            int l = r - k + 1;
            if (l >= start && check(s, l, r)) {
                ++ans;
                start = r + 1;
                continue;
            }

            l = r - k;
            if (l >= start && check(s, l, r)) {
                ++ans;
                start = r + 1;
            }
        }

        return ans;
    }

    private boolean check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}