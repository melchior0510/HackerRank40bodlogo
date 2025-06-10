import java.io.*;
import java.util.*;

public class theFullcountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            String value = (i < n / 2) ? "-" : input[1]; 
            buckets.get(x).add(value);
        }

        StringBuilder sb = new StringBuilder();
        for (List<String> bucket : buckets) {
            for (String str : bucket) {
                sb.append(str).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
