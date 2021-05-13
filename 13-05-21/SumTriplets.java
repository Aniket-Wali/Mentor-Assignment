import java.util.*;
class SumTriplets{

	// Brute force approach (V1) O(n^3)
	public static void printTripletV1(int arr[], int target){
		int n = arr.length;
		for(int i = 0; i<n-2; i++){
			for(int j = i+1; j<n-1; j++){
				for(int k = j+1; k<n; k++){
					if(arr[i] + arr[j] + arr[k] == target)
						System.out.print(arr[i] + " " + arr[j] + " " + arr[k] + "\n");
				}
			}
		}
	}

	// Slightly Better Approach (V2) O(n^2 log n)
	public static void printTripletV2(int arr[], int target){
		int n = arr.length;
		Arrays.sort(arr);
		for(int i =0; i<n-2; i++){
			for(int j = i+1; j<n; j++){
				int k = target - (arr[i] + arr[j]);
				int index = Arrays.binarySearch(arr, j, n, k);
				if(index >= 0 && index != j)
					System.out.print(arr[i] + " " + arr[j] + " " + arr[index] + "\n");
			}
		}
	}

	// Better Approach V3  O(n^2)
	public static void printTripletV3(int arr[], int target){
		int n = arr.length;
		Arrays.sort(arr);
		for(int k = 0; k<n-2; k++){
			int i = k+1, j = n-1;
			while(i < j){
				if(arr[k] + arr[i] + arr[j] > target)
					j--;
				else if(arr[k] + arr[i] + arr[j] < target)
					i++;
				else{
					System.out.print(arr[k] + " " + arr[i] + " " + arr[j] + "\n");
					i++;
					j--;
				}
			}
		}
	}


	public static void main(String[] args) {
		int arr[] = {-1,0,1,2,-1,-4};
		int target = 0;
		printTripletV1(arr, target);
		printTripletV2(arr, target);
		printTripletV3(arr, target);
	}
}