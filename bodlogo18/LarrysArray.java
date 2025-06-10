import java.util.*;

public class LarrysArray {

    public static String larrysArray(List<Integer> A) {
        int inversions = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) > A.get(j)) {
                    inversions++;
                }
            }
        }
        return (inversions % 2 == 0) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q-- > 0) {
            int n = scanner.nextInt();
            List<Integer> A = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                A.add(scanner.nextInt());
            }
            System.out.println(larrysArray(A));
        }
        scanner.close();
    }
}
