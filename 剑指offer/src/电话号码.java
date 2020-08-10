import java.util.*;

public class 电话号码 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
//        System.out.println(lett("234"));
    }

    public static List<String> lett(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        //这里也可以用map，用数组可以更节省点内存
        String[] letter_map = {
                " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = letter_map[digits.charAt(i) - '0'];
            int size = res.size();
            //计算出队列长度后，将队列中的每个元素挨个拿出来
            for (int j = 0; j < size; j++) {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for (int k = 0; k < letters.length(); k++) {
                    res.add(tmp + letters.charAt(k));
                }
            }
        }
        return res;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put(' ', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        list.add("");
        int len = digits.length();
        for (int i = 0; i < len - 1; i++) {
//            if(digits.charAt(i) == ' ' ||digits.charAt(i)== '1') continue;
            String sb = map.get(digits.charAt(i));
            int size = list.size();
            for (int j = 0; j < size; j++) {

                //每次都从队列中拿出第一个元素
                String tmp = list.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for (int k = 0; k < sb.length(); k++) {
                    list.add(tmp + sb.charAt(k));
                }
            }
        }
        return list;
    }


}
