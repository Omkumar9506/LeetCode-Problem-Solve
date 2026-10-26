class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o-> o[1]));

        int ans = 1;
        int end = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {

            if (pairs[i][0] > end) {
                ans++;
                end = pairs[i][1];
            } 
        }

        return ans;
    }
}