import java.io.*;
import java.util.*;

public class SurfaceArea3D {

    public static int surfaceArea(int[][] A) {
        int H = A.length;
        int W = A[0].length;
        int area = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int height = A[i][j];
                if (height > 0) {
                    area += 2; 
                }

                if (i == 0) {
                    area += height;
                } else {
                    area += Math.max(0, height - A[i - 1][j]);
                }

                if (i == H - 1) {
                    area += height;
                } else {
                    area += Math.max(0, height - A[i + 1][j]);
                }

                if (j == 0) {
                    area += height;
                } else {
                    area += Math.max(0, height - A[i][j - 1]);
                }

                if (j == W - 1) {
                    area += height;
                } else {
                    area += Math.max(0, height - A[i][j + 1]);
                }
            }
        }

        return area;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println(surfaceArea(A));
    }
}
