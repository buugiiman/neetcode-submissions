class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxSpeed = -1;

        for (int p : piles) {
            if (p > maxSpeed) {
                maxSpeed = p;
            }
        }

        int l = 1;
        int hi = maxSpeed;

        while (l < hi) {
            int mid = l + (hi-l) / 2;
            long hours = 0;

            for (int p : piles) {
                hours += p / mid;
                if (p % mid > 0) {
                    hours++;
                }
            }

            if (hours <= h) {
                hi = mid;
            } else {
                l = mid+1;
            }
        }

        return l;
    }
}
