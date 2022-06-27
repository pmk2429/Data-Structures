package heap.problems;

public class ArrayToHeapify {

    private int leftChildIndex(int i) {
        return 2 * i + 1;
    }

    private int rightChildIndex(int i) {
        return 2 * i + 2;
    }

    private int parentIndex(int i) {
        return (i - 1) / 2;
    }

    private void maxHeapify(int[] arr, int n, int i) {
        int largest = i; // initialize the largest as root
        int l = leftChildIndex(i);
        int r = rightChildIndex(i);

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            maxHeapify(arr, n, largest);
        }
    }

    private void minHeapify(int[] arr, int n, int i) {
        int smallest = i;
        int l = leftChildIndex(i);
        int r = rightChildIndex(i);

        if (l < n && arr[l] < arr[smallest]) {
            smallest = l;
        }

        if (r < n && arr[r] < arr[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            // recursively getMin heapify
            minHeapify(arr, n, smallest);
        }
    }

    /**
     * The following is entirely using integer division. I.e. fractional remainders are dropped.
     * For any given node index N, the children of that node will always be in locations 2N+1 and 2(N+1) in the same array.
     * <p>
     * Therefore, The parent of any node N > 0 in such an array will always be at index (N-1)/2.
     * -----------------------
     * Parent to Child Examples:
     * -----------------------
     * Parent 0: children 1,2
     * Parent 1: children 3,4
     * Parent 2: children 5,6
     * Parent 3: children 7,8
     * -----------------------
     * Child to Parent Examples:
     * -----------------------
     * Child 8 : Parent = (8-1)/2 = 7/2 = 3
     * Child 7 : Parent = (7-1)/2 = 6/2 = 3
     * Child 6 : Parent = (6-1)/2 = 5/2 = 2
     * Child 5 : Parent = (5-1)/2 = 4/2 = 2
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {};
    }
}
