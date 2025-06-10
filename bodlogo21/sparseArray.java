import java.io.*;
import java.util.*;

public class sparseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(reader.readLine());
        }

        int q = Integer.parseInt(reader.readLine());
        List<String> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            queries.add(reader.readLine());
        }

        for (String query : queries) {
            int count = 0;
            for (String s : strings) {
                if (s.equals(query)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
