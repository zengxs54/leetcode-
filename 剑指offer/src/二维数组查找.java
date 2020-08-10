public class 二维数组查找 {
    public static void main(String[] args) {
//        int[][] arr = {
//                {1,  4,  7,  11, 15},
//                {2,  5,  8,  12, 19},
//                {3,  6,  9,  16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30},
//        };
        int[][] arr = {
                {-1}, {-1}
        };
        System.out.println(findNumberIn2DArray(arr, -2));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length - 1;//行
        int n = 0;
        while (m >= 0 && n < matrix[0].length) {
            int a = matrix[m][n];
            if (a > target) {
                m--;
            } else if (a < target) {
                n++;
            } else {
                return true;
            }
        }
        return false;
    }
}
