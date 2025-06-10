import java.util.*;

public class emaSupercomputer {

    static int maxProductOfPluses(char[][] grid, int n, int m) {
        List<Plus> pluses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'G') {
                    int arm = 0;
                    while (isValid(grid, i, j, arm)) {
                        pluses.add(new Plus(i, j, arm));
                        arm++;
                    }
                }
            }
        }

        int maxProduct = 0;

        for (int i = 0; i < pluses.size(); i++) {
            for (int j = i + 1; j < pluses.size(); j++) {
                Set<String> set1 = pluses.get(i).getCells();
                Set<String> set2 = pluses.get(j).getCells();
                Set<String> intersect = new HashSet<>(set1);
                intersect.retainAll(set2);

                if (intersect.isEmpty()) {
                    int area1 = pluses.get(i).getArea();
                    int area2 = pluses.get(j).getArea();
                    maxProduct = Math.max(maxProduct, area1 * area2);
                }
            }
        }

        return maxProduct;
    }

    static boolean isValid(char[][] grid, int i, int j, int arm) {
        int n = grid.length;
        int m = grid[0].length;

        if (i - arm < 0 || i + arm >= n || j - arm < 0 || j + arm >= m)
            return false;

        return grid[i - arm][j] == 'G' &&
               grid[i + arm][j] == 'G' &&
               grid[i][j - arm] == 'G' &&
               grid[i][j + arm] == 'G';
    }

    static class Plus {
        int x, y, arm;

        Plus(int x, int y, int arm) {
            this.x = x;
            this.y = y;
            this.arm = arm;
        }

        int getArea() {
            return arm * 4 + 1;
        }

        Set<String> getCells() {
            Set<String> cells = new HashSet<>();
            cells.add(x + "," + y);
            for (int a = 1; a <= arm; a++) {
                cells.add((x + a) + "," + y);
                cells.add((x - a) + "," + y);
                cells.add(x + "," + (y + a));
                cells.add(x + "," + (y - a));
            }
            return cells;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine(); // consume newline
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        System.out.println(maxProductOfPluses(grid, n, m));
    }
}
