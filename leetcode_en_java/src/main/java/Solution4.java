public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isOdd = (nums1.length + nums2.length) % 2 != 0;
        int stop = (nums1.length + nums2.length) / 2;
        // System.out.println("stop = " + stop);
        int pos = 0;
        int curr = 0;
        int prev = 0;
        int pos1 = 0;
        int pos2 = 0;

        while (pos <= stop) {
            prev = curr;
            if (pos1 < nums1.length && pos2 < nums2.length) {
                if (nums1[pos1] <= nums2[pos2]) {
                    // normal compare lower number of nums1 and nums2 current element
                    curr = nums1[pos1];
                    pos1++;
                } else {
                    curr = nums2[pos2];
                    pos2++;
                }
            } else {
                if (pos1 >= nums1.length) {
                    // reach end of nums1
                    curr = nums2[pos2];
                    pos2++;
                } else if (pos2 >= nums2.length) {
                    // reach end of nums2
                    curr = nums1[pos1];
                    pos1++;
                }
            }

            pos ++;

            //System.out.println(String.format("pos = %s, pos1 = %s, pos2 = %s, curr = %s, prev = %s", pos, pos1, pos2, curr, prev));
        }

        return isOdd? curr: (double) (curr + prev) / 2;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {5, 6, 7, 8, 9, 10, 11, 12};

        System.out.println(solution4.findMedianSortedArrays(nums1, nums2));
    }

}
