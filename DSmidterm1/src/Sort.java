import java.util.Arrays;

/* HERRERA, CINDY
 * CSC2720 TEST1
 * 
 * 
 * Has several methods of sorting a list of integers
 */
public class Sort {

	public static void main(String[] args) {
	
		//sorting the same array with different sort methods
		int[] x = {3,4,7,19,1,55,32};
		
		System.out.print("Sort with bubble sort ");
		bubbleSort(x);
		System.out.println(Arrays.toString(x));
		
		System.out.print("Sort with quick sort");
		quickSort(x,0,6); //this works but you have to put in the high and low manually
		System.out.println(Arrays.toString(x));
		
		System.out.print("Sort with selection sort ");
		selectionSort(x);
		System.out.println(Arrays.toString(x));
		
		System.out.print("Sort with insertion sort ");
		insertionSort(x);
		System.out.println(Arrays.toString(x));
		
		System.out.print("Sort with merge sort");
		mergeSort(x,0,6);
		System.out.println(Arrays.toString(x));
		
	}
		//BUBBLE SORT
		public static int[] bubbleSort(int[] x) {
			for (int i = 0; i < x.length; i++) {
				for (int j = 0; j < x.length; j++) {
					if (x[i] < x[j]) { //swap values if i lower than j
						int temp = x[i];
						x[i] = x[j];
						x[j] = temp;
					}
				}
			}
			return x;
		}
		
		//INSERTION SORT
		public static int[] insertionSort(int[] x) {
			for (int i=1; i < x.length; i++) {
				int temp = x[i]; //starting at index 1
				int j = i - 1; //setting to index 0
				//comparing j and swapping into appropriate index if smaller
				while (j >= 0 && temp <= x[j]) {
					x[j+1] = x[j];
					j = j -1;
				}
				x[j+1] = temp; 
			}
			return x;
		}
		
		//SELECTION SORT
		public static int[] selectionSort(int[] x) {
			for (int i = 0; i < x.length-1; i++) {
				int temp = i; //start at beginning of list
				for (int j = i; j < x.length; j++) {
					if (x[j] < x[i])
						temp = j; //constantly finding smallest element in array
				}
				int minTemp = x[i]; //putting smallest in the sorted indezx
				x[temp] = x[i];
				x[i] = minTemp; //changing to new smallest minimum if a smaller number found
			}
			return x;
		}
				
		//QUICKSORT 
		public static int partition(int[] x, int low, int high) {
			
			//pick a pivot, in this case we pick highest
			int pivot = x[high];
			int i = low - 1;; //index we are partitioning
			for (int j = low; j < high; j++) { //going to through the entire list
				if(x[j] <= pivot) {
					i++;
					
					//swaps i and j in array if smaller
					int temp = x[i];
					x[i] = x[j];
					x[j] = temp;
				}
			}
			
			//swaps x[i+1] and pivot
			int temp = x[i + 1];
			x[i + 1] = x[high];
			x[high] = temp;
			
			return i + 1;
		}
		public static void quickSort(int[] x, int low, int high) {
			if (low < high) {
				
				int pi = partition(x, low, high);
				
				//recursively sort elements 
				quickSort(x, low, pi-1);
				quickSort(x, pi + 1, high);
				
			}
		}
		//MERGESORT
		public static void mergeSort(int[] x, int low, int high) {
			//will have to put in low and high index parameters
			//works with already sorted lists
			//if array size 1 then low==high
			
			//array size 0 if low>high
			if(low >= high) {
				return;
			}
			int mid = (low + high) / 2;
			//sorts first half
			mergeSort(x, low, mid);
			//sorts second half
			mergeSort(x, mid+1, high);
			//both halves sorted, now combine them together
			merge(x, low, mid, high);
			
		}
		public static void merge(int[] x, int low, int mid, int high) {
			
			
			//finding left half of array
			int left = mid - low + 1;
			//right half
			int right = high - (mid + 1) +1;
			
			//temporary arrays
			int[] left1 = new int[left];
			int[] right1 = new int[right];
			
			//fill in the created arrays
			for(int i = 0; i < left; i++) {
				left1[i]= x[low + i];
			}
			
			//fill in right array
			for(int j = 0; j < right; j++) {
				right1[j] = x[mid + 1 + j];
			}
			
			int i = 0; //index for left
			int j = 0; //index for right
			int k = low; //index for the number variables
			while(i < left && j < right) {
				int leftVar = left1[i];
				int rightVar = right1[j];
				if(leftVar < rightVar) {
					x[k] = leftVar; //left variable is smaller so keep track of it
					i++; //increases left side index
				} else {
					x[k] = rightVar;
					j++; //increases right side index
				}
				k++; //increases the index of all numbers
			}
			// copies left side into the numbers
			while(i < left) {
				x[k] = left1[i];
				k++;
				i++;
				
			} 
			//copies right side into the numbers
				while(j < right) {
					x[k] = right1[j];
					j++;
					k++;
				}	
			
		}
}
