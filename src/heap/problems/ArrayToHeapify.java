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

  public static void main(String[] args) {
    int[] arr = {};
  }
}
