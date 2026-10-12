class Solution {
    public boolean isMatch(String text, String pattern) {
        int n1 = text.length();
        int n2 = pattern.length();
        boolean[] prev = new boolean[n2 + 1];
        boolean[] curr = new boolean[n2 + 1];
        prev[0] = true;

        for (int j = 1; j <= n2; j++) {
            if (pattern.charAt(j - 1) == '*') {
                prev[j] = prev[j - 1];
            }
        }

        if (n2 == 0 && n1 > 0) {
            return false;
        }

        for (int i = 1; i <= n1; i++) {
            boolean flag = true;
            for (int j = 1; j <= n2; j++) {
                if (pattern.charAt(j - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            curr[0] = flag;

            for (int j = 1; j <= n2; j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    curr[j] = prev[j] || curr[j - 1];
                } else {
                    curr[j] = false;
                }
            }

            // Swap curr and prev for next iteration
            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n2];
    }
}