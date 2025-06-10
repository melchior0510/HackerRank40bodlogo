import java.io.*;
import java.util.*;

class Result {
    private static final String[] numbers = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
        "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two",
        "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
        "twenty eight", "twenty nine"
    };

    public static String timeInWords(int h, int m) {
        if (m == 0) {
            return numbers[h] + " o' clock";
        } else if (m == 1) {
            return "one minute past " + numbers[h];
        } else if (m == 15) {
            return "quarter past " + numbers[h];
        } else if (m == 30) {
            return "half past " + numbers[h];
        } else if (m == 45) {
            return "quarter to " + numbers[h + 1];
        } else if (m < 30) {
            return numbers[m] + " minutes past " + numbers[h];
        } else {
            return numbers[60 - m] + " minutes to " + numbers[h + 1];
        }
    }
}

public class TimeInWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer;

        String outputPath = System.getenv("OUTPUT_PATH");
        if (outputPath != null) {
            writer = new BufferedWriter(new FileWriter(outputPath));
        } else {
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int h = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        String result = Result.timeInWords(h, m);

        writer.write(result);
        writer.newLine();

        reader.close();
        writer.close();
    }
}
