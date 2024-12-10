package day10;

import java.util.*;

import static Util.TxtFileProcessor.readFileLines;

public class HoofIt {
    static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        boolean isTest = true;
        String parentPath = "src/day10/";
        String filename = isTest ? parentPath + "input-test.txt" : parentPath + "input-puzzle.txt";

        List<String> input = readFileLines(filename);
        int[][] map = new int[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            int[] line = new int[input.get(i).length()];
            for (int j = 0; j < line.length; j++) {
                line[j] = input.get(i).charAt(j) - '0';
            }
            map[i] = line;
        }
        System.out.println(Arrays.deepToString(map));
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                //System.out.print("processing for: "+i+"-"+j + " : "+map[i][j]+"\n");
                HashSet<List<Integer>> set = new HashSet<>();
                countTrails(map, i, j, map[i][j]-1, set);
                if(map[i][j] == 0)
                    res+=set.size();
            }
        }
        System.out.println(res);
    }

    static void countTrails(int[][] map, int i, int j, int prevHeight, HashSet<List<Integer>> set){
        if(i<0 || j<0 || i>=map.length || j>=map[0].length || map[i][j] != prevHeight+1)
            return;
        if(map[i][j] == 9){
            set.add(List.of(i,j));
        }
        for(int[] dir: dirs)
            countTrails(map, i + dir[0], j + dir[1], map[i][j], set);
    }


}
