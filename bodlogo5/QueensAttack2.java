import java.io.*;
import java.util.*;

class Result {

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, -1}, {0, 1},
            {1, -1}, {1, 1}, {-1, -1}, {-1, 1}
        };

        int[] closest = {
            n - r_q, r_q - 1, c_q - 1, n - c_q,
            Math.min(n - r_q, c_q - 1),
            Math.min(n - r_q, n - c_q),
            Math.min(r_q - 1, c_q - 1),
            Math.min(r_q - 1, n - c_q)
        };

        for (List<Integer> obstacle : obstacles) {
            int r = obstacle.get(0);
            int c = obstacle.get(1);
            int dr = r - r_q;
            int dc = c - c_q;

            if (dr == 0) {
                if (dc > 0 && dc - 1 < closest[3]) closest[3] = dc - 1;
                else if (dc < 0 && -dc - 1 < closest[2]) closest[2] = -dc - 1;
            } else if (dc == 0) {
                if (dr > 0 && dr - 1 < closest[0]) closest[0] = dr - 1;
                else if (dr < 0 && -dr - 1 < closest[1]) closest[1] = -dr - 1;
            } else if (Math.abs(dr) == Math.abs(dc)) {
                int dist = Math.abs(dr) - 1;
                if (dr > 0 && dc > 0 && dist < closest[5]) closest[5] = dist;
                else if (dr > 0 && dc < 0 && dist < closest[4]) closest[4] = dist;
                else if (dr < 0 && dc > 0 && dist < closest[7]) closest[7] = dist;
                else if (dr < 0 && dc < 0 && dist < closest[6]) closest[6] = dist;
            }
        }

        int total = 0;
        for (int d : closest) total += d;
        return total;
    }
}

public class QueensAttack2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = bufferedReader.readLine().trim().split(" ");
        int n = Integer.parseInt(firstInput[0]);
        int k = Integer.parseInt(firstInput[1]);

        String[] queenPos = bufferedReader.readLine().trim().split(" ");
        int r_q = Integer.parseInt(queenPos[0]);
        int c_q = Integer.parseInt(queenPos[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            String[] parts = bufferedReader.readLine().trim().split(" ");
            obstacles.add(Arrays.asList(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
        }

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
