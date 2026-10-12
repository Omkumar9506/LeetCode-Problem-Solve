import java.util.*;

class Solution {
    static class Node {
        int[] ch = new int[10];
        int idx = -1;
        Node() {
            Arrays.fill(ch, -1);
        }
    }

    private int[] pos;
    private List<Node> t;
    private long total = 0;

    public int minInversions(String[] words, int[] target) {
        int n = words.length;
        pos = new int[n];
        for (int i = 0; i < n; ++i) {
            pos[target[i]] = i;
        }

        t = new ArrayList<>();
        t.add(new Node());

        for (int i = 0; i < n; ++i) {
            int cur = 0;
            for (char c : words[i].toCharArray()) {
                int d = c - 'a';
                if (t.get(cur).ch[d] == -1) {
                    int id = t.size();
                    t.add(new Node());
                    t.get(cur).ch[d] = id;
                }
                cur = t.get(cur).ch[d];
            }
            t.get(cur).idx = i;
        }

        dfs(0);
        return (int) total;
    }

    private List<Integer> dfs(int u) {
        List<List<Integer>> cs = new ArrayList<>();
        Node currNode = t.get(u);

        for (int c = 0; c < 10; ++c) {
            if (currNode.ch[c] != -1) {
                cs.add(dfs(currNode.ch[c]));
            }
        }

        int k = cs.size();

        if (currNode.idx != -1) {
            int p = pos[currNode.idx];
            for (List<Integer> v : cs) {
                total += lowerBound(v, p);
            }
        }

        long[][] cost = new long[k][k];
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < k; ++j) {
                if (i == j) continue;
                int ptr = 0;
                long c = 0;
                List<Integer> csI = cs.get(i);
                List<Integer> csJ = cs.get(j);
                for (int x : csI) {
                    while (ptr < csJ.size() && csJ.get(ptr) < x) {
                        ptr++;
                    }
                    c += ptr;
                }
                cost[i][j] = c;
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[] dp = new long[1 << k];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int mask = 0; mask < (1 << k); ++mask) {
            if (dp[mask] == INF) continue;
            for (int j = 0; j < k; ++j) {
                if (((mask >> j) & 1) == 1) continue;
                long add = 0;
                for (int m = 0; m < k; ++m) {
                    if (((mask >> m) & 1) == 1) add += cost[m][j];
                }
                int nm = mask | (1 << j);
                dp[nm] = Math.min(dp[nm], dp[mask] + add);
            }
        }

        total += dp[(1 << k) - 1];

        List<Integer> res = new ArrayList<>();
        if (currNode.idx != -1) res.add(pos[currNode.idx]);
        for (List<Integer> v : cs) {
            res.addAll(v);
        }
        Collections.sort(res);
        return res;
    }

    private int lowerBound(List<Integer> list, int value) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (list.get(mid) < value) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}