import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        int n = get.nextInt();
        Map<Integer, Integer> map =new HashMap<>();
        int maxLen = 0;
        for(int i=0;i<n;i++) {
            int num = get.nextInt();
            int curr = map.getOrDefault(num - 1, 0) + 1;
            map.put(num, Math.max(map.getOrDefault(num, 0), curr));
            maxLen = Math.max(maxLen, curr);
        }
        
        System.out.println(maxLen);
    }
}