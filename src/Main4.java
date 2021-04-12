import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        List<String> list = getAllSubStr(str);
        int count = find(list);
        System.out.println(count);

    }

    private static int find(List<String> list) {
        int count = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (isGuanjian(list.get(i)))
                count++;
        }
        return count;
    }

    private static boolean isGuanjian(String s) {
        int sum = 0;
        char ch = s.charAt(s.length() / 2);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch)
                sum++;
        }
        if (sum > s.length() / 2)
            return true;
        else
            return false;
    }

    private static List<String> getAllSubStr(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char first = str.charAt(i);
            for (int j = i; j < str.length(); j++) {
                list.add(str.substring(i, j+1));
            }
        }
        return list;
    }


}
