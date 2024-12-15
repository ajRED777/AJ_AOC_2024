package day14;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static Util.TxtFileProcessor.readFileLines;

public class RestroomRedoubt2 {
    // final static int C = 11;
    // final static int R = 7;
    final static int C = 101;
    final static int R = 103;

    public static void main(String[] args) {
        // Set up file for logging output
        try {
            File outputFile = new File("C:\\Personal\\Advent_of_code\\src\\day14\\output.txt");
            FileOutputStream fos = new FileOutputStream(outputFile);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);  // redirect System.out to the file

            List<String> input = readFileLines(14, false);
            int[][] finalPositions = new int[R][C];
            //int[] seconds = new int[]{38, 88, 139, 191, 240, 294, 543, 745, 947}; //all seconds where some kind of pattern was being formed
            int seconds = 1;
            //int add = 50;
            processPattern(input, 7916);
            while(seconds<=8000) {
                if(seconds % C !=38 || seconds % R != 88){
                    seconds++;
                    continue;
                }
                processPattern(input, seconds);
            }
            
            //after a lot of pattern matching found a tree at 7916
            processPattern(input, 7916);
            ps.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processPattern(List<String> input, int seconds) {
        int[][] finalPositions;
        finalPositions = new int[R][C];
        for (String line : input) {
            String[] split = line.split(" ");
            String[] p = split[0].substring(split[0].indexOf("=") + 1).split(",");
            String[] v = split[1].substring(split[1].indexOf("=") + 1).split(",");
            //System.out.println("p: "+ Arrays.toString(p) +" v: "+ Arrays.toString(v));
            int py = ((Integer.parseInt(p[0]) + seconds * Integer.parseInt(v[0])) % C + C) % C;
            //System.out.println("py without mod: "+ Integer.parseInt(p[0]) + 100*Integer.parseInt(v[0]));
            int px = ((Integer.parseInt(p[1]) + seconds * Integer.parseInt(v[1])) % R + R) % R;
            //System.out.println("pX without mod: "+ (Integer.parseInt(p[1]) + 100*Integer.parseInt(v[1])));
            //System.out.println("py: "+ py + " px: "+ px);
            finalPositions[px][py]++;
        }
        System.out.println("After " + seconds + " ::::::");
        //Arrays.stream(finalPositions).forEach(r -> System.out.println(Arrays.toString(r)));
        Arrays.stream(finalPositions)
                .map(row -> Arrays.stream(row)
                        .mapToObj(i -> i == 0 ? " " : String.valueOf(i))
                        .collect(Collectors.joining(","))) // Convert ints to chars and join with ","
                .map(String::toCharArray)  // Convert each string to a char array
                .forEach(System.out::println);
    }
}
