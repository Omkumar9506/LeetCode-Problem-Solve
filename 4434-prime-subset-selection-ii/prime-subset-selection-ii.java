class Solution {
    public List<Integer> maxPrimeSubset(int n, int s) {
        //sieve
        List<Integer> primes = new ArrayList<>();

        boolean[] map = new boolean[n + 1];
        Arrays.fill(map, true);
        map[0] = false;
        map[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (map[i] == true) {
                for (int j = i * i; j <= n; j = j + i) {
                    map[j] = false;
                }
            }
        }

        for(int i=2;i<=n;i++)
        {
            if(map[i])
            {
                primes.add(i);
            }
        }
        List<Integer>[] dp = new ArrayList[s + 1];
        dp[0] = new ArrayList<>();
        for (int i = primes.size() - 1; i >= 0; i--) {
            int p = primes.get(i);

            for (int j = s; j >= p; j--) {
                if (dp[j - p] != null) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(p);
                    curr.addAll(dp[j - p]);
                    if (dp[j] == null || curr.size() <= dp[j].size()) {
                        dp[j] = curr;
                    }
                }
            }
        }

        for(int j=s;j>=0;j--)
        {
            if(dp[j]!=null)
            {
                return dp[j];
            }
        }
        
        return new ArrayList<>();
    }
}