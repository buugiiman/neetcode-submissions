class Solution {
    public int maxArea(int[] heights) {
        
        int l = 0;
        int h = heights.length-1;

        int res = 0;

        while (l < h) {
            int distance = h-l;
            int area = Math.min(heights[l], heights[h]) * distance;
            res = Math.max(area, res);

            if (heights[l] < heights[h]) {
                l++;
            } else {
                h--;
            }
        }

        return res;
    }
}
