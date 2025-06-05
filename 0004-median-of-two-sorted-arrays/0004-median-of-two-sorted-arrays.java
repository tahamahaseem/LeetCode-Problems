class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //get totalLength of merged array for calculations
        int totalLength = nums1.length + nums2.length;

        /*determines whether the median will need to be calculated by adding
        the two middle values and finding average or just by taking the single
        middle value in array based on the totalLength */
        boolean medianIsInteger = (totalLength) % 2 != 0;

        int[] mergedArray = new int[totalLength];

        //pointer for final array (i), and the left and right arrays given to merge
        int i = 0;
        int leftPointer = 0;
        int rightPointer = 0;

        //merges and sorts the final array using the left and right arrays using merge sort merge algorithm
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

        //since given arrays are already sorted, just concat the rest of the left array since right array is already all in
        while (leftPointer < nums1.length) {
            mergedArray[i] = nums1[leftPointer];
            leftPointer++;
            i++;
        }
        //since given arrays are already sorted, just concat the rest of the right array since left array is already all in
        while (rightPointer < nums2.length) {
            mergedArray[i] = nums2[rightPointer];
            rightPointer++;
            i++;
        }

        //find the first or only median index
        int medianIndex = (int) Math.ceil((double) mergedArray.length / 2) - 1;

        //based on array size calculate median two different ways
        if (medianIsInteger) {
            return mergedArray[medianIndex];
        } else {
            return (double) (mergedArray[medianIndex] + mergedArray[medianIndex + 1]) / 2;
        }
    }
}