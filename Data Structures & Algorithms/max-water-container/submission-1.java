class Solution {
    public int maxArea(int[] heights) {
        
        int low = 0;
        int high = heights.length-1;

        int res = 0;

        while (low < high) {
            int currentArea = Math.min(heights[low], heights[high]) * (high - low);
            res = Math.max(currentArea, res);

            if (heights[low] > heights[high]) {
                high--;
            } else {
                low++;
            }

        }

        return res;
    }
}
