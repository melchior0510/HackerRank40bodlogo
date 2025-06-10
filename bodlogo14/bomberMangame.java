import java.util.*;

public class bomberMangame {

    public static List<String> bomberMan(int n, List<String> grid) {
        if (n == 1) return grid;

        int rows = grid.size();
        int cols = grid.get(0).length();
        char[][] g = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            g[i] = grid.get(i).toCharArray();
        }

        if (n % 2 == 0) {
            
            List<String> full = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                char[] row = new char[cols];
                Arrays.fill(row, 'O');
                full.add(new String(row));
            }
            return full;
        }

        char[][] first = detonate(g);
        char[][] second = detonate(first);

        if ((n - 3) % 4 == 0) {
            return toList(first);
        } else {
            return toList(second);
        }
    }

    private static char[][] detonate(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        char[][] result = new char[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(result[i], 'O');
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'O') {
                    result[i][j] = '.';
                    if (i > 0) result[i - 1][j] = '.';
                    if (i < r - 1) result[i + 1][j] = '.';
                    if (j > 0) result[i][j - 1] = '.';
                    if (j < c - 1) result[i][j + 1] = '.';
                }
            }
        }

        return result;
    }

    private static List<String> toList(char[][] grid) {
        List<String> res = new ArrayList<>();
        for (char[] row : grid) {
            res.add(new String(row));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split(" ");
        int R = Integer.parseInt(parts[0]);
        int C = Integer.parseInt(parts[1]);
        int N = Integer.parseInt(parts[2]);

        List<String> grid = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            grid.add(sc.nextLine());
        }

        List<String> result = bomberMan(N, grid);
        for (String line : result) {
            System.out.println(line);
        }
    }
}
