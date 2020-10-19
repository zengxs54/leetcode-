public class 旋转数组最小数字 {
    public static void main(String[] args) {
        /**
         * 测试用例：1，3，5
         * 2，3，4，5，1
         * */
        int[] arr = new int[]{1,3,5};
        System.out.println(aaa(arr));
    }

    public static int aaa(int[] numbers) {
        int num = -999;
        int len = numbers.length;
        for (int i = 1; i < len; i++) {
            if (numbers[i - 1] <= numbers[i]) {
                continue;
            } else {
                num = numbers[i];
                break;
            }
        }
        return num == -999 ? numbers[0] : num;
    }

    /*二分法，有bug*/
    public static int minArray(int[] numbers) {
        int min = 0;
        int len = numbers.length;
        if (len == 1)
            return numbers[0];
        min = numbers[0];
        //对半拆，看看最小值在哪边
        if (numbers[0] >= numbers[len / 2]) {
            for (int i = len / 2; i > -1; i--) {
                if (numbers[i] < min) {
                    min = numbers[i];
                    break;
                }
            }
        } else {
            for (int i = len / 2; i < len; i++) {
                if (numbers[i] < min) {
                    min = numbers[i];
                    break;
                }
            }
        }
        return min;
    }
}
