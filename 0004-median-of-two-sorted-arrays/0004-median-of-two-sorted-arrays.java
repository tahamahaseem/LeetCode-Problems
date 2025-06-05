class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        boolean medianIsInteger = (totalLength) % 2 != 0;
        int[] mergedArray = new int[totalLength];
        int leftPointer = 0;
        int rightPointer = 0;
        int i = 0;

        while (leftPointer < nums1.length && rightPointer < nums2.length) {
            if (nums1[leftPointer] <= nums2[rightPointer]) {
                mergedArray[i] = nums1[leftPointer];
                leftPointer++;
            } else {
                mergedArray[i] = nums2[rightPointer];
                rightPointer++;
            }
            i++;
        }

        while (leftPointer < nums1.length) {
            mergedArray[i] = nums1[leftPointer];
            leftPointer++;
            i++;
        }

        while (rightPointer < nums2.length) {
            mergedArray[i] = nums2[rightPointer];
            rightPointer++;
            i++;
        }

        int medianIndex = (int) Math.ceil((double) mergedArray.length / 2) - 1;

        if (medianIsInteger) {
            return mergedArray[medianIndex];
        } else {
            return (double)(mergedArray[medianIndex] + mergedArray[medianIndex + 1]) / 2;
        }
    }
}