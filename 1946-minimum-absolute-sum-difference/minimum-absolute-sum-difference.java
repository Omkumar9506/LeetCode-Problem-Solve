class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1_000_000_007;
        int n = nums1.length;

        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long sum = 0;
        int maxReduction = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;

            int target = nums2[i];

            int idx = Arrays.binarySearch(sorted, target);

            if (idx < 0) {
                idx = -idx - 1;
            }

            
            if (idx < n) {
                int newDiff = Math.abs(sorted[idx] - target);
                maxReduction = Math.max(maxReduction, diff - newDiff);
            }

            
            if (idx > 0) {
                int newDiff = Math.abs(sorted[idx - 1] - target);
                maxReduction = Math.max(maxReduction, diff - newDiff);
            }
        }
        return (int) ((sum - maxReduction + MOD) % MOD);
    }
}