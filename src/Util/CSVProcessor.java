package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVProcessor {
    public static List<String> processCSV(String relativeFilePath) {
        Path projectDir = Paths.get("").toAbsolutePath();
        System.out.println(projectDir);
        Path fullPath = projectDir.resolve(relativeFilePath);
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fullPath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}