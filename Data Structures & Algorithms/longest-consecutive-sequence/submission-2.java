class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int n : nums) {
            set.add(n);
        }

        for (int n : nums) {
            if (!set.contains(n-1)) {
                int tempCount = 0;
                int x = n;
                while (set.contains(x+1)) {
                    tempCount++;
                    x++;
                }

                count = Math.max(count, ++tempCount);
            }
        }

        return count;
    }
}
