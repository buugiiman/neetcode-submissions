class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        int n = heights.length;

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
