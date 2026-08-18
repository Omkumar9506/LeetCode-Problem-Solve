class Solution {
    public int maxScore(int[] cardPoints, int k) {
         // Get the total number of cards
        int n = cardPoints.length;

        // Calculate the sum of first k cards from the front
        int total = 0;
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        // Store the maximum score
        int maxPoints = total;

        // Slide the window: remove from front and add from back
        for (int i = 0; i < k; i++) {
            // Subtract card from front
            total -= cardPoints[k - 1 - i];

            // Add card from back
            total += cardPoints[n - 1 - i];

            // Update the max score
            maxPoints = Math.max(maxPoints, total);
        }

        // Return the best possible score
        return maxPoints;
    }
}