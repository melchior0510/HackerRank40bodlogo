import java.io.*;
import java.util.*;

class Result {

    public static String encryption(String s) {
        String str = s.replaceAll(" ", "");
        int length = str.length();

        if (length == 0) return "";

        double sqrtLen = Math.sqrt(length);
        int rows = (int) Math.floor(sqrtLen);
        int cols = (int) Math.ceil(sqrtLen);

        if (rows * cols < length) rows++;

        List<String> grid = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            int start = i * cols;
            int end = Math.min(start + cols, length);
            grid.add(str.substring(start, end));
        }

        StringBuilder encrypted = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            for (String row : grid) {
                if (j < row.length()) {
                    encrypted.append(row.charAt(j));
                }
            }
            encrypted.append(" ");
        }

        return encrypted.toString().trim();
    }
}

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String s = reader.readLine();
        String result = Result.encryption(s);

        writer.println(result);

        reader.close();
        writer.close();
    }
}
