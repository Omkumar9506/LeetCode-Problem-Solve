class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();

        // List to store result
        List<Integer> result = new ArrayList<>();

        // Loop through each element
        for (int i = 0; i < nums.length; i++) {
            // Remove indices out of current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller values from the back of deque
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Add to result once the first window is formed
            if (i >= k - 1) {
                result.add(nums[dq.peekFirst()]);
            }
        }

       // Convert List<Integer> to int[]
        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        // returning answer
        return ans;
    }
}