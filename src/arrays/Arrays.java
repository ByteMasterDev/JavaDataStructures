package arrays;

import java.util.NoSuchElementException;

public class Arrays {

    public static void main(String[] args) {
        // Test largestElement method
        try {
            int[] nums1 = {5, 2, 8, 3, 10};
            int[] nums2 = {-1, -5, -10, -3};
            int[] nums3 = {0};
            int[] nums4 = {};

            System.out.println("Testing largestElement method:");
            System.out.println("nums1: Largest element expected: 10, Actual: " + largestElement(nums1));
            System.out.println("nums2: Largest element expected: -1, Actual: " + largestElement(nums2));
            System.out.println("nums3: Largest element expected: 0, Actual: " + largestElement(nums3));

            // Uncomment to test for NoSuchElementException
            //System.out.println("nums4: Largest element expected: NoSuchElementException");
            //System.out.println("Actual: ");
            //largestElement(nums4);

            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        // Test secondLargestElement method
        try {
            int[] nums1 = {5, 2, 8, 3, 10};
            int[] nums2 = {-1, -5, -10, -3};
            int[] nums3 = {0};
            int[] nums4 = {5};

            System.out.println("Testing secondLargestElement method:");
            System.out.println("nums1: Second largest element expected: 8, Actual: " + secondLargestElement(nums1));
            System.out.println("nums2: Second largest element expected: -3, Actual: " + secondLargestElement(nums2));

            // Uncomment to test for NoSuchElementException
            //System.out.println("nums3: Second largest element expected: NoSuchElementException");
            //System.out.println("Actual: ");
            //secondLargestElement(nums3);

            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        // Test isSortedArray method
        try {
            int[] nums1 = {1, 2, 3, 4, 5};
            int[] nums2 = {5, 4, 3, 2, 1};
            int[] nums3 = {1, 3, 2, 4, 5};

            System.out.println("Testing isSortedArray method:");
            System.out.println("nums1: Sorted? Expected: true, Actual: " + isSortedArray(nums1));
            System.out.println("nums2: Sorted? Expected: false, Actual: " + isSortedArray(nums2));
            System.out.println("nums3: Sorted? Expected: false, Actual: " + isSortedArray(nums3));

            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        // Test reverseArray method
        try {
            int[] nums1 = {1, 2, 3, 4, 5};
            int[] nums2 = {5, 4, 3, 2, 1};
            int[] nums3 = {1};

            System.out.println("Testing reverseArray method:");
            System.out.print("nums1: Reversed array: ");
            printArray(reverseArray(nums1));
            System.out.print("nums2: Reversed array: ");
            printArray(reverseArray(nums2));
            System.out.print("nums3: Reversed array: ");
            printArray(reverseArray(nums3));

            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        // Test removeDuplicatesFromSortedArray method
        try {
            int[] nums1 = {1, 2, 2, 3, 4, 4, 4, 5};
            int[] nums2 = {1, 1, 1, 1};
            int[] nums3 = {1};

            System.out.println("Testing removeDuplicatesFromSortedArray method:");
            System.out.print("nums1: Array after removing duplicates: ");
            printArray(removeDuplicatesFromSortedArray(nums1));
            System.out.print("nums2: Array after removing duplicates: ");
            printArray(removeDuplicatesFromSortedArray(nums2));
            System.out.print("nums3: Array after removing duplicates: ");
            printArray(removeDuplicatesFromSortedArray(nums3));

            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        // Test moveZeroesToEnd method
        try {
            int[] nums1 = {0, 1, 0, 3, 12};
            int[] nums2 = {0, 0, 0, 0};
            int[] nums3 = {1, 2, 3};

            System.out.println("Testing moveZeroesToEnd method:");
            System.out.print("nums1: Array after moving zeroes to end: ");
            printArray(moveZeroesToEnd(nums1));
            System.out.print("nums2: Array after moving zeroes to end: ");
            printArray(moveZeroesToEnd(nums2));
            System.out.print("nums3: Array after moving zeroes to end: ");
            printArray(moveZeroesToEnd(nums3));

            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        // Test rotateArrayByOne method
        try {
            int[] nums1 = {1, 2, 3, 4, 5};
            int[] nums2 = {0};
            int[] nums3 = {1, 2, 3};

            System.out.println("Testing rotateArrayByOne method:");
            System.out.print("nums1: Array rotated by one: ");
            printArray(rotateArrayByOne(nums1));
            System.out.print("nums2: Array rotated by one: ");
            printArray(rotateArrayByOne(nums2));
            System.out.print("nums3: Array rotated by one: ");
            printArray(rotateArrayByOne(nums3));

            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        // Test leftRotateArraysByDPlaces method
        try {
            int[] nums1 = {1, 2, 3, 4, 5};
            int[] nums2 = {1, 2, 3, 4, 5};
            int[] nums3 = {1, 2, 3, 4, 5};

            System.out.println("Testing leftRotateArraysByDPlaces method:");
            System.out.print("nums1: Array rotated left by 2 places: ");
            printArray(leftRotateArraysByDPlaces(nums1, 2));
            System.out.print("nums2: Array rotated left by 0 places: ");
            printArray(leftRotateArraysByDPlaces(nums2, 0));
            System.out.print("nums3: Array rotated left by 5 places: ");
            printArray(leftRotateArraysByDPlaces(nums3, 5));

            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        // Test maxDifference method
        try {
            int[] nums1 = {7, 1, 5, 3, 6, 4};
            int[] nums2 = {7, 6, 4, 3, 1};
            int[] nums3 = {};
            int[] nums4 = {5};
            int[] nums5 = {1, 2, 3, 4, 5};

            System.out.println("Testing maxDifference method:");
            System.out.println("nums1: Maximum difference expected: 5, Actual: " + maxDifference(nums1));
            System.out.println("nums2: Maximum difference expected: 0, Actual: " + maxDifference(nums2));

            // Uncomment to test for NoSuchElementException
            //System.out.println("nums3: Maximum difference expected: NoSuchElementException");
            //System.out.println("Actual: ");
            //maxDifference(nums3);

            System.out.println("nums4: Maximum difference expected: 0, Actual: " + maxDifference(nums4));
            System.out.println("nums5: Maximum difference expected: 4, Actual: " + maxDifference(nums5));

            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        // Test freqInSortedArray method
        try {
            int[] nums1 = {1, 1, 2, 2, 2, 3, 4, 4};
            int[] nums2 = {1, 2, 3};
            int[] nums3 = {1, 1, 1};

            System.out.println("Testing freqInSortedArray method:");
            System.out.println("nums1: Frequency of elements:");
            freqInSortedArray(nums1);
            System.out.println("nums2: Frequency of elements:");
            freqInSortedArray(nums2);
            System.out.println("nums3: Frequency of elements:");
            freqInSortedArray(nums3);

            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        // Test buyAndSellStocks method
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};

        System.out.println("Testing buyAndSellStocks method:");
        System.out.println("prices1: Max profit expected: 7, Actual: " + buyAndSellStocks(prices1));
        System.out.println("prices2: Max profit expected: 4, Actual: " + buyAndSellStocks(prices2));
        System.out.println("prices3: Max profit expected: 0, Actual: " + buyAndSellStocks(prices3));

        // Testing trappingRainWater method
        int[] heights1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] heights2 = {4, 2, 0, 3, 2, 5};
        int[] heights3 = {2, 0, 2};
        int[] heights4 = {3, 0, 0, 2, 0, 4};

        System.out.println("Testing trappingRainWater method:");
        System.out.println("heights1: Expected: 6, Actual: " + trappingRainWater(heights1));
        System.out.println("heights2: Expected: 9, Actual: " + trappingRainWater(heights2));
        System.out.println("heights3: Expected: 2, Actual: " + trappingRainWater(heights3));
        System.out.println("heights4: Expected: 10, Actual: " + trappingRainWater(heights4));

        // Testing maxSubArraySum method
        System.out.println("Testing maxSubArraySum method:");
        System.out.println("Max subarray sum in [-2, 1, -3, 4, -1, 2, 1, -5, 4]: " + maxSubArraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        // Testing maxSumCircularSubArray method
        System.out.println("Testing maxSumCircularSubArray method:");
        System.out.println("Max circular subarray sum in [5, -3, 5]: " + maxSumCircularSubArray(new int[]{5, -3, 5}));
        System.out.println("Max circular subarray sum in [-2, 4, -1, 4, -1, 5]: " + maxSumCircularSubArray(new int[]{-2, 4, -1, 4, -1, 5}));

        // Test cases for majorityElement method
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Testing majorityElement method:");
        System.out.println("Majority element in [3, 2, 3]: " + majorityElement(nums1));
        System.out.println("Majority element in [2, 2, 1, 1, 1, 2, 2]: " + majorityElement(nums2));
    }

    static void printArray(int[] nums){
        for(int val : nums){
            System.out.println(val);
        }
    }

    static int largestElement(int[] nums){
        if (nums.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        int largestElement = nums[0];
        for(int i=1; i<nums.length; i++){
            largestElement = Math.max(largestElement, nums[i]);
        }
        return largestElement;
    }

    static int secondLargestElement(int[] nums){
        if (nums.length < 2) {
            throw new NoSuchElementException("Not enough data in array.");
        }
        int largestElement = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > largestElement){
                secondLargest = largestElement;
                largestElement = nums[i];
            }else{
                if(nums[i] > secondLargest && nums[i] < largestElement){
                    secondLargest = nums[i];
                }
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new NoSuchElementException("No second largest element found.");
        }

        return secondLargest;
    }

    static boolean isSortedArray(int[] nums){
        if(nums.length == 0) throw new NoSuchElementException("Array is empty.");
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]) return false;
        }
        return true;
    }

    static int[] reverseArray(int[] nums){
        if(nums.length == 0) throw new NoSuchElementException("Array is empty.");
        if(nums.length == 1) return new int[]{nums[0]};

        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int temp = nums[high];
            nums[high] = nums[low];
            nums[low] = temp;
            low++;
            high--;
        }

        return nums;
    }

    static int[] removeDuplicatesFromSortedArray(int[] nums){
        if(nums.length == 0) throw new NoSuchElementException("Array is empty.");

        int j = 0;
        int k = 0;
        nums[k++] = nums[j];

        for(int i=1; i<nums.length; i++){
            if(nums[j] != nums[i]){
                nums[k++] = nums[i];
                j = i;
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[i];
        }
        return result;
    }

    static int[] moveZeroesToEnd(int[] nums){
        if(nums.length == 0) throw new NoSuchElementException("Array is empty.");
        int j = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }

        // Fill the remaining positions with zeros
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }

    static int[] rotateArrayByOne(int[] nums){
        if(nums.length == 0) throw new NoSuchElementException("Array is empty.");
        if(nums.length == 1) return new int[]{nums[0]};

        int temp = nums[nums.length - 1]; // Store the last element
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1]; // Shift elements to the right
        }

        nums[0] = temp;
        return nums;
    }

    static int[] leftRotateArraysByDPlaces(int[] nums, int d){
        if(nums.length == 0) throw new NoSuchElementException("Array is empty.");
        d = d % nums.length; // Handle cases where d is greater than the array length
        if (d == 0) return nums;
        reverse(nums, 0, d - 1);
        reverse(nums, d, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        return nums;
    }

    static void reverse(int[] nums, int si, int ei){
        if(nums.length == 0) throw new NoSuchElementException("Array is empty.");
        while(si >  ei){
            int temp = nums[ei];
            nums[ei] = nums[si];
            nums[si] = temp;
            si++;
            ei--;
        }
    }

    static int maxDifference(int[] nums){
        if(nums.length == 0) throw new NoSuchElementException("Array is empty.");
        int min = nums[0];
        int maxDiff = 0;

        for(int val : nums){
            int currentDiff = val - min;
            min = Math.min(min, val);

            if(currentDiff > maxDiff){
                maxDiff = currentDiff;
            }
        }

        return maxDiff;
    }

    static void freqInSortedArray(int[] nums){
        if(nums.length == 0) throw new NoSuchElementException("Array is empty.");

        int freq = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                freq++;
            }else{
                System.out.println("Frequency of " +nums[i-1] + " is " + freq );
                freq = 1;
            }
        }
        System.out.println("Frequency of " +nums[nums.length-1] + " is " + freq );
    }

    static int buyAndSellStocks(int[] nums){
        if(nums.length == 0) return 0;
        int maxProfit = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                maxProfit += nums[i] - nums[i-1];
            }
        }
        return maxProfit;
    }

    static int trappingRainWater(int[] nums){
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];

        lmax[0] = nums[0];
        for(int i=1; i<n; i++){
           lmax[i] = Math.max(nums[i], lmax[i-1]);
        }

        rmax[nums.length - 1] = nums[nums.length-1];
        for(int i=n-2; i>=0; i--){
            rmax[i] = Math.max(rmax[i+1], nums[i]);
        }

        int result = 0;
        for(int i=0; i<n; i++){
            result += Math.min(lmax[i], rmax[i]) - nums[i];
        }

        return result;
    }

    static int maxSubArraySum(int[] nums){
        if (nums == null || nums.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        int n = nums.length;
        int result = nums[0];
        int currentSum = nums[0];

        for(int i=1; i<n; i++){
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            result = Math.max(currentSum, result);
        }
        return result;
    }

    static int maxSumCircularSubArray(int[] nums){
        int normalMaxSumSubArray = maxSubArraySum(nums);
        if(normalMaxSumSubArray < 0) return normalMaxSumSubArray;

        int totalSum = 0;
        for(int i=0; i<nums.length; i++){
            totalSum += nums[i];
            nums[i] = -nums[i];
        }

        int negativeMaxSumSubArray = maxSubArraySum(nums);
        int max_circular_sum = totalSum + negativeMaxSumSubArray;
        return Math.max(max_circular_sum, normalMaxSumSubArray);
    }

    /** Boyer-Moore Voting Algorithm to find the majority element in an array */
    static int majorityElement(int[] nums){
        if (nums == null || nums.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        int n = nums.length;

        int count = 1;
        int majorityElement = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]){
                count++;
                majorityElement = nums[i];
            }else{
                count--;
            }

            if(count == 0){
                count = 1;
                majorityElement = nums[i];
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return majorityElement;
        } else {
            throw new NoSuchElementException("No majority element found.");
        }
    }

}

