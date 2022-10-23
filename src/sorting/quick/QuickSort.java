package sorting.quick;

import java.util.Arrays;

public class QuickSort {

    private static int[] values;

    private static int[] sort(int[] arr) {
        // check for empty or null array
        if (arr == null || arr.length == 0) {
            return null;
        }

        values = arr;
        int number = values.length;
        quickSort(0, number - 1);

        return values;
    }

    private static void quickSort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = values[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (values[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (values[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j) {
            quickSort(low, j);
        }
        if (i < high) {
            quickSort(i, high);
        }
    }

    private static void swap(int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 3, 0, 2, 0, 1, 2};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
