import java.util.*;

public class absolutePermutation {

    public static List<Integer> absolutePermutation(int n, int k) {
        List<Integer> result = new ArrayList<>();

        if (k == 0) {
            for (int i = 1; i <= n; i++) result.add(i);
            return result;
        }

        if (n % (2 * k) != 0) {
            result.add(-1);
            return result;
        }

        boolean add = true;
        for (int i = 1; i <= n; i++) {
            if (add)
                result.add(i + k);
            else
                result.add(i - k);

            if (i % k == 0)
                add = !add;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        while (t-- > 0) {
            int n = sc.nextInt(); 
            int k = sc.nextInt(); 
            List<Integer> res = absolutePermutation(n, k);
            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
