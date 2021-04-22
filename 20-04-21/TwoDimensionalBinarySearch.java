
class TwoDimensionalBinarySearch {
    // Searching the element in 2D matrix by implementing binary search.
    public static boolean binarySearchIn2D(int[][] matrix, int k) {
        int col = matrix[0].length;
        int start = 0, end = matrix.length * col;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            int i = mid / col; // converting mid index into row for 2D matrix
            int j = mid % col; // converting mid index into column for 2D matrix
            if (matrix[i][j] < k) // if k > current element, then shift the start pointer.
                start = mid + 1;
            else if (matrix[i][j] == k) // if k == current element, return true.
                return true;
            else // if k < current element, then shift the end pointer.
                end = mid - 1;
        }
        // Just Check if the last iteration will return the element or not.
        mid = (start + end) / 2;
        int i = mid / col;
        int j = mid % col;
        if (i >= matrix.length || j >= col)
            return false;
        if (matrix[i][j] == k)
            return true;
        return false; // If no element found in the matrix, return false
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4}, {5,6,7,8}, {9, 10, 11, 12}};
        int k = 7;
        System.out.println(binarySearchIn2D(matrix, k));
    }
}