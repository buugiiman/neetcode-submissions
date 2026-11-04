class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }

        int n = heights.length;

        while (!st.isEmpty()) {
            int height = heights[st.pop()];
            int width = st.isEmpty() ? n : n - st.peek() - 1;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
