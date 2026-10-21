class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (valueDiff < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)valueDiff + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long)nums[i]);
            if (i >= indexDiff) d.remove(getID(nums[i - indexDiff], w));
        }
        return false;
    }

    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }
}