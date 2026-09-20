class Solution {
    public int[] largestPower(int[] nums) {
        int[] power = new int[15];

        // Each group is represented by a List<Integer>
        List<List<Integer>> groups = new ArrayList<>();

        List<Integer> initial = new ArrayList<>();
        for (int x : nums) {
            initial.add(x);
        }

        groups.add(initial);

        // Process bits from 14 down to 0
        for (int bit = 14; bit >= 0; bit--) {

            int index = 14 - bit;

            for (int g = 0; g < groups.size(); g++) {

                List<Integer> group = groups.get(g);

                int ones = 0;
                int zeros = 0;

                for (int x : group) {
                    if (((x >> bit) & 1) == 1) {
                        ones++;
                    } else {
                        zeros++;
                    }
                }

                // Entire group has this bit set
                if (zeros == 0) {
                    power[index] += group.size();
                    continue;
                }

                // Entire group does not have this bit set
                if (ones == 0) {
                    break;
                }

                // Mixed group -> split it
                List<Integer> oneGroup = new ArrayList<>();
                List<Integer> zeroGroup = new ArrayList<>();

                for (int x : group) {
                    if (((x >> bit) & 1) == 1) {
                        oneGroup.add(x);
                    } else {
                        zeroGroup.add(x);
                    }
                }

                power[index] += ones;

                // Replace current group with two ordered groups
                groups.set(g, oneGroup);
                groups.add(g + 1, zeroGroup);

                break;
            }
        }

        return power;
    }
}