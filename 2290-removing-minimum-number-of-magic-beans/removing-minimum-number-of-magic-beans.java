class Solution {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + beans[i];
        }
        long minRemoved = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long removedLeft = prefix[i];
            long removedRight =(prefix[n] - prefix[i + 1]) - (long) beans[i] * (n - 1 - i);
            minRemoved = Math.min(minRemoved, removedLeft + removedRight);
        }
        return minRemoved;
    }
}