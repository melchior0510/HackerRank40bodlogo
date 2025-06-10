import java.io.*;
import java.util.*;

public class MatrixRotation {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> values = new ArrayList<>();

            for (int j = layer; j < n - layer; j++)
                values.add(matrix.get(layer).get(j));
       
            for (int i = layer + 1; i < m - layer - 1; i++)
                values.add(matrix.get(i).get(n - layer - 1));
      
            for (int j = n - layer - 1; j >= layer; j--)
                values.add(matrix.get(m - layer - 1).get(j));

            for (int i = m - layer - 2; i > layer; i--)
                values.add(matrix.get(i).get(layer));

            int len = values.size();
            List<Integer> rotated = new ArrayList<>(Collections.nCopies(len, 0));
            for (int i = 0; i < len; i++) {
                rotated.set(i, values.get((i + r) % len));
            }

            int idx = 0;

            for (int j = layer; j < n - layer; j++)
                matrix.get(layer).set(j, rotated.get(idx++));

            for (int i = layer + 1; i < m - layer - 1; i++)
                matrix.get(i).set(n - layer - 1, rotated.get(idx++));

            for (int j = n - layer - 1; j >= layer; j--)
                matrix.get(m - layer - 1).set(j, rotated.get(idx++));

            for (int i = m - layer - 2; i > layer; i--)
                matrix.get(i).set(layer, rotated.get(idx++));
        }
        
        for (List<Integer> row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(scanner.nextInt());
            }
            matrix.add(row);
        }

        matrixRotation(matrix, r);
    }
}
