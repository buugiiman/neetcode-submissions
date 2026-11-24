class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // PriorityQueue<int[]> pq =
        //     new PriorityQueue<>((a, b) -> {
        //         return Integer.compare(b[1], a[1]);
        //     });

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1])
                
            );


        int res[] = new int[nums.length-k+1];

        int left = 0;
        int right = 0;

        int copyL = left;

        while (copyL < k) {
            pq.offer(new int[]{copyL, nums[copyL]});
            copyL++;
        }

        res[left++] = pq.peek()[1];
        right = k;

        while (right < nums.length) {
            while(!pq.isEmpty() && pq.peek()[0] < left) {
                pq.poll();
            }

            pq.offer(new int[]{right, nums[right]});
            res[left] = pq.peek()[1];

            left++;
            right++;
        }

        return res;
    }
}
