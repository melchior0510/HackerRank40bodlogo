import java.io.*;
import java.util.*;

class Result {
    public static String gridSearch(List<String> G, List<String> P) {
        int R = G.size();
        int C = G.get(0).length();
        int r = P.size();
        int c = P.get(0).length();

        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {
                boolean match = true;

                for (int x = 0; x < r; x++) {
                    String bigRow = G.get(i + x).substring(j, j + c);
                    if (!bigRow.equals(P.get(x))) {
                        match = false;
                        break;
                    }
                }

                if (match) return "YES";
            }
        }

        return "NO";
    }
}

public class GridSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer;

        String outputPath = System.getenv("OUTPUT_PATH");
        if (outputPath != null) {
            writer = new BufferedWriter(new FileWriter(outputPath));
        } else {
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int t = Integer.parseInt(reader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = reader.readLine().split(" ");
            int R = Integer.parseInt(RC[0]);
            int C = Integer.parseInt(RC[1]);

            List<String> G = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                G.add(reader.readLine());
            }

            String[] rc = reader.readLine().split(" ");
            int r = Integer.parseInt(rc[0]);
            int c = Integer.parseInt(rc[1]);

            List<String> P = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                P.add(reader.readLine());
            }

            String result = Result.gridSearch(G, P);
            writer.write(result);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
