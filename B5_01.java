package lab_6;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;

public class B5_01 {
    public static void main(String[] args) {
        duzhka("input.txt", "output_removed_brackets.txt");
    }

    public static void duzhka(String input, String output) {
        Path inpPath = Path.of(input);
        Path outPath = Path.of(output);

        try {
            List<String> Lines = Files.readAllLines(inpPath);
            StringBuilder result = new StringBuilder();

            for (String line : Lines) {
                if (areBracketsValid(line)) {
                    result.append(removeBracets(line)).append("\n");
                } else {
                    System.out.println("");
                }
            }

            BufferedWriter bw = Files.newBufferedWriter(outPath);
            bw.write(result.toString());
            bw.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    
    public static boolean areBracketsValid(String input) {
        int bracketcount = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                bracketcount++;
                if (bracketcount > 1) {
                    return false;
                }
            } else if (ch == ')') {
                bracketcount--;
                if (bracketcount < 0) {
                    return false;
                }
            }
        }

        return bracketcount == 0;
    }

    public static String removeBracets(String input) {
        StringBuilder result = new StringBuilder();
        boolean insideBrackets = false;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                insideBrackets = true;
            } else if (ch == ')') {
                insideBrackets = false;
            } else if (!insideBrackets) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
