class Solution {
    public int secondHighest(String s) {
        int largest = -1;
        int secondLargest = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int val = (ch - '0');
                if (val > largest) {
                    secondLargest = largest;
                    largest = val;
                } else if (val > secondLargest && val < largest) {
                    secondLargest = val;
                }
            }
        }
        return secondLargest;
    }
}