package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class TxtFileProcessor {
    public static List<String> readFileLines(String relativeFilePath) {
        Path projectDir = Paths.get("").toAbsolutePath();
        System.out.println(projectDir);
        Path fullPath = projectDir.resolve(relativeFilePath);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fullPath.toString()))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<String> readFileLines(int day, boolean isTestInput) {
        String parentPath = MessageFormat.format("src/day{0}/", day);
        String filename = isTestInput ? parentPath + "input-test.txt" : parentPath + "input-puzzle.txt";

        List<String> input = readFileLines(filename);
        System.out.println("File read: " + input);
        return input;
    }

}
