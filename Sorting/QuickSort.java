public class QuickSortWithWhile {

    // Main method to call quickSort
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, left, right);
            
            // Recursively apply quicksort to left and right partitions
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    // Partition method using while loop
    private static int partition(int[] array, int left, int right) {
        int pivot = array[right]; // Choose the rightmost element as pivot
        int i = left - 1; // Index of smaller element

        int j = left;
        while (j < right) {
            if (array[j] <= pivot) { // Change to >= for descending order
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            j++;
        }

        // Swap the pivot element to its correct position
        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;

        return i + 1; // Return the index of the pivot element
    }

    // Helper method to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: Unsorted array with positive and negative numbers
        int[] nums1 = {5, 16, 7, 9, -1, 4, 3, 11, 2};
        System.out.println("Test Case 1 - Original array:");
        printArray(nums1);
        quickSort(nums1, 0, nums1.length - 1);
        System.out.println("Test Case 1 - Sorted array:");
        printArray(nums1);
        System.out.println();

        // Test Case 2: Array already sorted in ascending order
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Test Case 2 - Original array:");
        printArray(nums2);
        quickSort(nums2, 0, nums2.length - 1);
        System.out.println("Test Case 2 - Sorted array:");
        printArray(nums2);
        System.out.println();

        // Test Case 3: Array with duplicate values
        int[] nums3 = {4, 2, 5, 2, 1, 3, 4};
        System.out.println("Test Case 3 - Original array:");
        printArray(nums3);
        quickSort(nums3, 0, nums3.length - 1);
        System.out.println("Test Case 3 - Sorted array:");
        printArray(nums3);
    }
}
