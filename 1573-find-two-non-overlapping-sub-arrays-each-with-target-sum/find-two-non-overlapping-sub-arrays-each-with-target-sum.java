class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        // Approach 1: Prefix Sum + Dynamic Programming + Hash Table
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        int n = arr.length;
        int s = 0;
        int ans = n + 1;
        int minL = n;
        for (int i = 0; i < n; i++) {
            s += arr[i];
            if (pos.containsKey(s - target)) {
                int j = pos.get(s - target);
                int len = i - j;
                ans = Math.min(ans, len + (j == -1 ? n : arr[j]));
                minL = Math.min(minL, len);
            }
            arr[i] = minL;
            pos.put(s, i);
        }
        return ans == n + 1 ? -1 : ans;

        // Approach 2: Sliding Window + Dynamic Programming

        // nt n = arr.length,
        //     ans = n + 1,
        //     sum = 0;
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, n);
        // for (int l = 0, r = 0; r < n; r++) {
        //     sum += arr[r];
        //     while (sum > target) sum -= arr[l++];
        //     dp[r + 1] = dp[r];
        //     if (sum == target) {
        //         ans = Math.min(ans, r - l + 1 + dp[l]);
        //         dp[r + 1] = Math.min(dp[r], r - l + 1);
        //     }
        // }
        // return ans == n + 1 ? -1 : ans;
    }
}