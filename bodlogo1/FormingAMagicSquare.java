import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class FormingAMagicSquare {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            List<List<Integer>> s = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                s.add(
                    Stream.of(bufferedReader.readLine().trim().split(" "))
                          .map(Integer::parseInt)
                          .collect(toList())
                );
            }

            int result = Result.formingMagicSquare(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
    }
}
