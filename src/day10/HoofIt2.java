package day10;

import java.util.Arrays;
import java.util.List;

import static Util.TxtFileProcessor.readFileLines;

public class HoofIt2 {
    static int[][] memo;
    static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        boolean isTest = false;
        String parentPath = "src/day10/";
        String filename = isTest ? parentPath + "input-test.txt" : parentPath + "input-puzzle.txt";

        List<String> input = readFileLines(filename);
        int[][] map = new int[input.size()][input.get(0).length()];
        memo = new int[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            int[] line = new int[input.get(i).length()];
            for (int j = 0; j < line.length; j++) {
                line[j] = input.get(i).charAt(j) - '0';
            }
            map[i] = line;
            Arrays.fill(memo[i], -1);
        }
        System.out.println(Arrays.deepToString(map));
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print("processing for: " + i + "-" + j + " : " + map[i][j] + "\n");
                countTrails(map, i, j, map[i][j] - 1);
                Arrays.stream(memo).map(Arrays::toString).forEach(System.out::println);
            }
        }
        System.out.println(Arrays.deepToString(memo));
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0)
                    res += memo[i][j];
            }
        }
        System.out.println(res);
    }

    static int countTrails(int[][] map, int i, int j, int prevHeight) {
        if (i < 0 || j < 0 || i >= map.length || j >= map[0].length || map[i][j] != prevHeight + 1)
            return 0;
        if (map[i][j] == 9)
            return 1;
        if (memo[i][j] != -1)
            return memo[i][j];


        int trails = 0;
        for (int[] dir : dirs)
            trails += countTrails(map, i + dir[0], j + dir[1], map[i][j]);
        memo[i][j] = trails;
        return memo[i][j];
    }


}
