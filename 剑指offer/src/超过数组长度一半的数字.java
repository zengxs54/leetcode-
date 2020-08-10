import javax.swing.text.html.parser.Entity;
import java.util.*;

public class 超过数组长度一半的数字 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 4, 3, 3, 2};
        System.out.println(majorityElement(arr));

    }

    public static int majorityElement(int[] nums) {
        int target = 0;
        int count = 0;
//        for (int i = 0; i < nums.length/2; i++) {
//            if (target == nums[i])
//                count++;
//            else {
//                target = nums[i];
//                count--;
//                if (count < 0) {
//
//
//                }
//            }
//        }
//        return target;
//        int len = nums.length;
//        if (len == 1) return nums[0];
//        Arrays.sort(nums);
//
//        return nums[len/2];

//        for (int num : nums) {
//            if (count == 0) {
//                target = num;
//                count += num == target ? 1 : -1;
//            }
//        }
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
