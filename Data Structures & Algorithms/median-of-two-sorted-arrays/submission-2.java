class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m1 = -1;
        int m2 = -1;

        int i = 0;
        int j = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;

        for(int count = 0; count <= (len1 + len2) / 2; count++) {
            m2 = m1;
            //check if both arrays have remaining elements
            if (i < len1 && j < len2) {
                m1 = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
            }

            //check if only nums1 has remaining elements
            else if (i < len1) {
                m1 = nums1[i++];
            }

            //if only nums2 has remaining elements
            else {
                m1 = nums2[j++];
            }
        }

        if ((len1 + len2) % 2 == 1) {
            return m1;
        } else {
            return (m1 + m2) / 2.0;
        }
    }
}
