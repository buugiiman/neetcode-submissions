class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> {
                return Integer.compare(b[1], a[1]);
            });

        int res[] = new int[nums.length-k+1];

        int left = 0;
        int right = 0;

        int copyL = left;

        while (copyL < k) {
            pq.offer(new int[]{copyL, nums[copyL]});
            copyL++;
        }

        res[left++] = pq.peek()[1];
        right = k-1;

        while (right < nums.length-1) {
            while(!pq.isEmpty() && pq.peek()[0] < left) {
                pq.poll();
            }

            pq.offer(new int[]{right+1, nums[right+1]});
            res[left] = pq.peek()[1];

            left++;
            right++;
        }

        return res;
    }
}
