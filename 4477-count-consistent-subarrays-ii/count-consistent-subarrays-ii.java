class Solution {
    public long countConsistent(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        Arrays.fill(l, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && (nums[st.peek()] & nums[i]) == nums[i] && nums[i] < nums[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                l[i] = st.peek();
            }
            st.push(i);
        }
        long res = 0;
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && (nums[st.peek()] & nums[i]) == nums[i]) {
                st.pop();
            }
            int r = st.isEmpty() ? n : st.peek();
            res += (long) (i - l[i]) * (r - i);
            st.push(i);
        }
        return res;
    }
}