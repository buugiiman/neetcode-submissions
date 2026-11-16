class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int l1 = -1;
        int l2 = -1;

        int i = 0;
        int j = 0;

        for (int k = 0; k <= (m+n) / 2; k++) {
            l2 = l1;
            if (i != m && j != n) {
                l1 = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
            }

            else if (i < m) {
                l1 = nums1[i];
                i++;
            }

            else {
                l1 = nums2[j];
                j++;
            }
        }

        if ((m+n) % 2 == 1) {
            return (double) l1;
        }

        return ((double) l1 + l2) / 2;
    }
}
