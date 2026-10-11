class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<int[]> maxHeap = 
            new PriorityQueue<>((a, b) -> {
                return Integer.compare(b[1], a[1]);
            });
        
        
        int l = 0;
        int r = k-1;

        int[] result = new int[nums.length-k+1];

        int tempL = l;

        while (tempL <= r) {
            maxHeap.add(new int[]{tempL, nums[tempL]});

            tempL++;
        }

        result[l++] = maxHeap.peek()[1];

        while(r < nums.length-1) {
            while (!maxHeap.isEmpty() && maxHeap.peek()[0] < l) {
                maxHeap.poll();
            }

            maxHeap.add(new int[]{r+1, nums[r+1]});

            result[l] = maxHeap.peek()[1];

            l++;
            r++;

        }

        return result;
    }
}
