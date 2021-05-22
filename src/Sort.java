import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort{
	
	private static int[] bubbleSort(int[] arr, int size){
		for(int i = 0; i< size; i++){
			for(int j = i+1; j< size; j++){
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	private static int[] selecttionSort(int[] arr, int size){
		for(int i = 0; i< size; i++){
			int smallest = i;
			for(int j = i+1; j< size; j++){
				if(arr[smallest] > arr[j]){
					smallest = j;
				}
				int temp = arr[i];
				arr[i] = arr[smallest];
				arr[smallest] = temp;
			}
		}
		return arr;
	}
	
	private static int[] insertionSort(int[] arr, int size){
		for(int i = 0; i< size; i++){
			int min = i;
            for (int j = i+1; j < size; j++)
                if (arr[j] < arr[min])
                    min = j;
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
		}
		return arr;
	}
	
	private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left)/2;
			
			mergeSort(arr, left, middle);
			mergeSort(arr, middle+1, right);
			
			merge(arr, left, middle, right);
        }
    }
	
	private static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	
	private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);

            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
	
	private static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
	
	private static int binarySearch(int[] arr, int key) {
		int first = 0;
		int last = arr.length;
		int middle = last/2;
		
		while(first <= last){
			if(key < arr[middle])
				last = middle - 1;
			else if(key == arr[middle])
				return middle;
			else
				first = middle + 1;
			middle = (first + last)/2;
		}
		return -1;
	}
	
	public static void main(String[] args) {
        int[] num1 = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println("bubbleSort : "+Arrays.toString(bubbleSort(num1, num1.length)));
		int[] num2 = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
		System.out.println("selecttionSort : "+Arrays.toString(selecttionSort(num2, num2.length)));
		int[] num3 = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
		System.out.println("insertionSort : "+Arrays.toString(insertionSort(num3, num3.length)));
		int[] num4 = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
		mergeSort(num4, 0 , num4.length - 1);
		System.out.println("mergeSort : "+Arrays.toString(num4));
		int[] num5 = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
		quickSort(num5, 0 , num4.length - 1);
		System.out.println("quickSort : "+Arrays.toString(num4));
		int[] num6 = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
		System.out.println("LinearSearch index of "+63+" is : "+linearSearch(num6, 63));
		int[] num7 = {10, 20, 30, 40, 50};
		System.out.println("BinarySearch index of "+40+" is : "+binarySearch(num7, 40));
    }
}