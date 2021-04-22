class TrappingWaterProblem {

	// Method for solving the problem in O(n) time with O(n) space.
	private static int findTrappedWater(int[] arr, int n){
		int maxLeft[] = new int[n];
		int maxRight[] = new int[n];
		int totalWater = 0;
		maxLeft[0] = arr[0];
		maxRight[n-1] = arr[n-1];
		// filling the maxLeft array with maximum values to its current left.
		for(int i = 1; i<n; i++)
			maxLeft[i] = arr[i] > maxLeft[i-1] ? arr[i] : maxLeft[i-1];
		// filling the maxRight array with maximum values to its current right.
		 for(int i = n-2; i>=0; i--)
			maxRight[i] = arr[i] > maxRight[i+1] ? arr[i] : maxRight[i+1];
		// finding the total amount of water filled.
		for(int i = 1; i<n; i++)
			if(Math.min(maxLeft[i], maxRight[i]) - arr[i] > 0)
				totalWater += Math.min(maxLeft[i], maxRight[i]) - arr[i];
		return totalWater;
	}

	// Method for solving the problem in O(n) time with O(1) space.
	private static int findTrappedWaterV2(int[] arr, int n){
		int left = 0, right = n-1;
		int maxLeft = 0, maxRight = 0;
		int totalWater = 0;
		while(left < right){
			if(arr[left] < arr[right]){
				if(arr[left] >= maxLeft)
					maxLeft = arr[left];
				else
					totalWater += maxLeft - arr[left];
				left++;
			}
			else{
				if(arr[right] >= maxRight)
					maxRight = arr[right];
				else
					totalWater += maxRight - arr[right];
				right--;
			}
		}
		return totalWater;
	}

	public static void main(String[] args) {
		int arr[] = {6, 4, 7, 5, 3, 2, 5, 8};
		int n = arr.length;
		System.out.println(findTrappedWaterV2(arr, n));
	}
}