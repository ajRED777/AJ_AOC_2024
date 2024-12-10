package day8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static Util.TxtFileProcessor.readFileLines;
// naive attempt at another approach
//please ignore this
public class ResonantCollinearity2 {
    static int R = 0;
    static int C = 0;
    static Set<List<Integer>> set = new HashSet<>();
    //final static int[][] dirs = new int[][]{{1, 1}, {1, -1},{-1, -1}, {-1, 1}};
    final static int[][] dirs = new int[][]{{1, 1},{1,0},{1,-1},{0,-1},
            {-1,-1},{-1,0},{-1,1},{0,1}};
    //final static int[][] diff = new int[][]{{0, -1}, {-1, 0},{0, 1}, {1, 0}};
    final static int[][] diff = new int[][]{{0, -1},{0, -1}, {-1, 0},{-1, 0},{0, 1},{0, 1}, {1, 0},{1, 0}};

    public static void main(String[] args) {
        boolean isTest = true;
        String parentPath = "src/day8/";
        String filename = isTest ? parentPath + "input-test.txt" : parentPath + "input-puzzle.txt";

        List<String> input = readFileLines(filename);
        R = input.size();
        C = input.get(0).length();
        char[][] arr = new char[R][];
        for (int i = 0; i < R; i++) {
            arr[i] = input.get(i).toCharArray();
        }
        System.out.println(Arrays.deepToString(arr));
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != '#' && arr[i][j] != '.')
                    checkAntiNodeNodePairs(i, j, arr);
            }
        }
        System.out.println(set);
        System.out.println(set.size());

    }

    static void checkAntiNodeNodePairs(int i, int j, char[][] input) {
        System.out.println("-----------i= " + i + ", j= " + j);
        int radius = Math.max(Math.max(R - i - 1, i), Math.max(C - j - 1, j));
        for (int r = 1; r < radius; r++) {
            System.out.println("----------------");
            System.out.println("For Radius>>> " + r);
            for (int d = 0; d < dirs.length; d++) {
                //int od = (d+2)%dirs.length;
                int od = (d+4)%dirs.length;
                int ia = i + r * dirs[od][0];
                int ja = j + r * dirs[od][1];

                int x = i + r * dirs[d][0];
                int y = j + r * dirs[d][1];
                System.out.println("x-y " + x + " " + y + ": i-j " + i + " " + j);

                //System.out.println("Found matching char>>> " + input[x][y]+ " for x= "+x+" y= "+y);
                //System.out.println("matching char at x= "+x+" y= "+y);
                //System.out.println("For d=" + d + " adding " + Arrays.toString(dirs[(d + 4) % 8]) + "->" + "x+" + r * dirs[(d + 4) % 8][0] + "y+" + r * dirs[(d + 4) % 8][1]);
                System.out.println("antinode for i-j " + i + " " + j + ": " + ia + " " + ja);

                int xa = x + r * dirs[d][0];
                int ya = y + r * dirs[d][1];

                int nX = i + r * dirs[(d + 1) % dirs.length][0];
                int nY = j + r * dirs[(d + 1) % dirs.length][1];
                System.out.println("antinode for x-y " + x + " " + y + ": " + xa + " " + ya);
                System.out.println("until next x-y " + nX + " " + nY);

                while (x != nX || y != nY) {
                    System.out.println("checking>x-y " + x + " " + y + ": i-j " + i + " " + j);
                    System.out.println("checking>xa-ya " + xa + " " + ya + ": ia-ja " + ia + " " + ja);
                    if (!isOffTheMap(x, y) && input[x][y] == input[i][j]) {
                        System.out.println(">Found matching char>>> " + input[x][y] + " for x= " + x + " y= " + y);
                        System.out.println("# at: " + ia + "_" + ja + " " + xa + "_" + ya);
                        if (!isOffTheMap(xa, ya))
                            set.add(List.of(xa, ya));
                        if (!isOffTheMap(ia, ja))
                            set.add(List.of(ia, ja));
                    }


                    x = x + diff[d][0];
                    y = y + diff[d][1];
                    System.out.println("next x= " + x + " y= " + y);
                    System.out.println("dir>>"+ Arrays.toString(dirs[d]));
                    //System.out.println("For d=" + d + " adding " + Arrays.toString(diff[d]) + "->" + "xa:" + xa + "+" + diff[d][0] + " ya:" + ya + "+" + diff[d][1]);

                    xa = x + r * dirs[d][0]+ diff[d][0];
                    ya = y + r * dirs[d][1]+ diff[d][1];
                    System.out.println("next xa= " + xa + " ya= " + ya);
                    ia = i + r * dirs[od][0] + diff[od][0];
                    ja = j + r * dirs[od][1] + diff[od][1];
                    System.out.println("next ia= " + ia + " ja= " + ja);
                }
            }
        }
    }

    static boolean isAntiNode(int i, int j, char[][] input, char expected) {
        return (isOffTheMap(i, j) && expected == '#') ||
                (!isOffTheMap(i, j) && expected == '#');
    }

    static boolean isOffTheMap(int i, int j) {
        return i < 0 || j < 0 || i >= R || j >= C;
    }
}
