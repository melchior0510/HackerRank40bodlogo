import java.io.*;
import java.util.*;

public class AlmostSorted {

    public static void almostSorted(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        int left = -1, right = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] != sorted[i]) {
                if (left == -1) {
                    left = i;
                }
                right = i;
            }
        }

        if (left == -1) {
            System.out.println("yes");
        } else {
            // Try swap
            swap(arr, left, right);
            if (Arrays.equals(arr, sorted)) {
                System.out.println("yes");
                System.out.println("swap " + (left + 1) + " " + (right + 1));
                return;
            }
            // Undo swap
            swap(arr, left, right);

            // Try reverse
            reverse(arr, left, right);
            if (Arrays.equals(arr, sorted)) {
                System.out.println("yes");
                System.out.println("reverse " + (left + 1) + " " + (right + 1));
            } else {
                System.out.println("no");
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        String[] parts = br.readLine().trim().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        almostSorted(arr);
    }
}
