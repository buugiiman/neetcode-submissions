class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxSpeed = -1;

        for(int pile : piles) {
            if (maxSpeed < pile) {
                maxSpeed = pile;
            }
        }

        int low = 1;
        int high = maxSpeed;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long hours = 0;

            for (int pile : piles) {
                hours += pile / mid;
                if (pile % mid > 0) {
                    hours++;
                }
            }

            if (hours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
