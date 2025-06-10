import java.io.*;
import java.util.stream.*;


class Result {

    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int n = chars.length;
        int pivot = -1;

        for (int i = n - 1; i > 0; i--) {
            if (chars[i] > chars[i - 1]) {
                pivot = i - 1;
                break;
            }
        }
        if (pivot == -1) {
            return "no answer";
        }

        int swap = n - 1;
        while (chars[swap] <= chars[pivot]) {
            swap--;
        }

        char temp = chars[pivot];
        chars[pivot] = chars[swap];
        chars[swap] = temp;

        int left = pivot + 1;
        int right = n - 1;
        while (left < right) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }
}

public class BiggerIsGreater {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}