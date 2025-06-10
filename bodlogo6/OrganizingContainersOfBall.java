import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        List<Integer> rowSums = new ArrayList<>();
        for (List<Integer> row : container) {
            int sum = 0;
            for (int num : row) {
                sum += num;
            }
            rowSums.add(sum);
        }

        List<Integer> colSums = new ArrayList<>(Collections.nCopies(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                colSums.set(j, colSums.get(j) + container.get(i).get(j));
            }
        }

        Collections.sort(rowSums);
        Collections.sort(colSums);

        return rowSums.equals(colSums) ? "Possible" : "Impossible";
    }
}

public class OrganizingContainersOfBall {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().trim().split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

                try {
                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
