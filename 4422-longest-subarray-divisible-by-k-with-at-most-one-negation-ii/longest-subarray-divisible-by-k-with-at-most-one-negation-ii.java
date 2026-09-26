class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n=nums.length;
        int f[] = new int[k], l[] = new int[k];  
        Arrays.fill(l, -1); 
        Arrays.fill(f, n + 1); 
        int ans = 0; 
        List<Integer>[] pos = new ArrayList[k]; 
        for(int d = 0; d < k; d++) pos[d] = new ArrayList<>(); 
        int p[] = new int[n + 1]; 
        for(int i = 0; i < n; i++) {
            p[i + 1] = (((p[i] + nums[i]) % k) + k) %k; 
            int d = (((2 * nums[i]) % k) + k) % k; 
            pos[d].add(i); 
        }

        for(int i = 0 ; i <= n; i++) {
            f[p[i]] = Math.min(f[p[i]], i); 
            l[p[i]] = i; 
        }
        for (int rem = 0; rem < k; rem++) {
            if (f[rem] != n + 1) {
                ans = Math.max(ans, l[rem] - f[rem]);
            }
        }
        for(int d = 0; d < k; d++) {
            List<Integer> idx = pos[d]; 
            if(idx.size() == 0) continue; 

            for(int x = 0; x < k; x++) { 
                if(f[x] == n + 1) continue; 
                int left = f[x]; 
                int right = l[(x + d) % k]; 
                if(right <= left) continue; 
                int id = Collections.binarySearch(idx, left); 
                if(id < 0) {
                    id = -id -1; 
                }
                if(id < idx.size() && idx.get(id)< right) {
                    ans = Math.max(ans, right -left);
                }
            }
        }
        return ans;
    }
}