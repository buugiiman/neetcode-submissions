class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        int[] ans = new int[nums.length-k+1];
        int left = 0;
        int right = k;

        while(left < k) {
            maxHeap.offer(new int[]{left, nums[left]});
            left++;
        }

        left = 0;
        ans[left++] = maxHeap.peek()[1];

        while (right < nums.length) {
            while (!maxHeap.isEmpty() && maxHeap.peek()[0] < left) {
                maxHeap.poll();
            }

            maxHeap.offer(new int[]{right, nums[right]});
            ans[left] = maxHeap.peek()[1];

            right++;
            left++;
        }

        return ans;

    }
}
