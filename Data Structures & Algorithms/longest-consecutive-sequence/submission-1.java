class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!set.contains(x-1)) {
                int temp = 1;
                while (set.contains(x+1)) {
                    temp++;
                    x++;
                
                }

                res = Math.max(res, temp);
            }
        }

        return res;
    }
}
