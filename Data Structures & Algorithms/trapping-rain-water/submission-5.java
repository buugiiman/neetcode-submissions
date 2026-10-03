class Solution {
    public int trap(int[] height) {
        
       int l = 0;
       int r = height.length-1;

       int lmax = height[l];
       int rmax = height[r];

       int res = 0;

       while (l < r) {
        lmax = Math.max(lmax, height[l]);
        rmax = Math.max(rmax, height[r]);

        if (height[l] <= height[r]) {
            res += lmax - height[l];
            l++;
        } else {
            res += rmax - height[r];
            r--;
        }
       }

       return res;
    }
}
