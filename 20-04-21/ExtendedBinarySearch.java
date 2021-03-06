
class ExtendedBinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int n = arr.length;
        int k = 4;
        int position = findMaxPosition(arr); // Finding the maximum element in the array in O(log n)
        if (position == n - 1) { // If array is strictly Increasing only
            System.out.println(binarySearch1(arr, 0, position, k));
            return;
        }
        if (position == 0) { // If array is strictly Decreasing only
            System.out.println(binarySearch2(arr, 0, n - 1, k));
            return;
        }
        boolean x = binarySearch1(arr, 0, position, k); // Binary Search for Searching the element in strictly
                                                        // increasing array
        boolean y = binarySearch2(arr, position + 1, n - 1, k); // Binary Search for Searching the element in strictly
                                                                // Decreasing array
        System.out.println(x || y);
    }

    // Implementing the binary search for strictly Increasing array.
    private static boolean binarySearch1(int[] arr, int start, int end, int k) {
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] == k)
                return true;
            else if (arr[mid] < k)
                start = mid + 1;
            else
                end = mid - 1;
        }
        if (arr[start] == k)
            return true;
        return false;
    }

    // Implementing the binary search for strictly decreasing array.
    private static boolean binarySearch2(int[] arr, int start, int end, int k) {
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] == k)
                return true;
            else if (arr[mid] > k)
                start = mid + 1;
            else
                end = mid - 1;
        }
        if (arr[start] == k)
            return true;
        return false;
    }

    // Finding Maximum element in the array with the help of binary search.
    private static int findMaxPosition(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid + 1] > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
}
