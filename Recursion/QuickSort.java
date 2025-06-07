public class QuickSort {

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int partition(int[] arr, int low, int high) {
    int pivot = arr[low];
    int i = low + 1;
    int j = high;

    while (i <= j) {
      while (i <= high && arr[i] <= pivot) {
        i++;
      }
      while (j >= low && arr[j] > pivot) {
        j--;
      }
      if (i < j) {
        swap(arr, i, j);
      }
    }

    // Place pivot at its correct position
    swap(arr, low, j);
    return j; // new pivot index
  }

  public static void qs(int[] arr, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(arr, low, high);
      qs(arr, low, pivotIndex - 1);
      qs(arr, pivotIndex + 1, high);
    }
  }

  public static void main(String[] args) {
    int[] arr = {5, 7, 8, 3, 4, 2, 1};

    System.out.println("Before sorting:");
    for (int val : arr) {
      System.out.print(val + " ");
    }

    qs(arr, 0, arr.length - 1);

    System.out.println("After sorting:");
    for (int val : arr) {
      System.out.print(val + " ");
    }
  }
}
