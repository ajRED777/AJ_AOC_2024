package day6;

import java.util.*;

import static Util.TxtFileProcessor.readFileLines;

public class GuardGallivant {
    static int R =0;
    static int C =0;
    static Map<Character, List<Integer>> guardPositions = Map.of('^', List.of(-1,0),
            'v', List.of(1,0), '<', List.of(0,-1), '>', List.of(0,1));
    static List<List<Integer>> directions = List.of(List.of(-1,0),List.of(0,1), List.of(1,0), List.of(0,-1));
    public static void main(String[] args) {
        boolean isTest = false;
        String parentPath = "src/day6/";
        String filename = isTest?parentPath+"input-test.txt":parentPath+"input-puzzle.txt";

        List<String> input = readFileLines(filename);
        //System.out.println(input);
        R = input.size();
        char[][] arr = new char[R][];
        for(int i=0;i<R;i++) {
            arr[i] = input.get(i).toCharArray();
        }
        C = arr[0].length;

        int[] dir = findGuard(arr);

        //Arrays.stream(arr).forEach(System.out::println);
        System.out.println("sum of X path:"+guardTraversal(arr, dir).size());

        int res = 0;
        for(int i=0;i<R;i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] == '#' || guardPositions.containsKey(arr[i][j]))
                    continue;
                if(formsLoop(arr, dir, i, j))
                    res++;

            }
        }
        System.out.println("Additional barriers forming loops: "+res);

    }

    static Set<List<Integer>> guardTraversal(char[][] input, int[] startDir){
        int i=startDir[0]; int j=startDir[1];
        int x=startDir[2]; int y=startDir[3];
        int prevI = i, prevJ = j;
        int currDir = directions.indexOf(List.of(x, y));
        HashSet<List<Integer>> visited = new HashSet<>();
        while(i>0 && j>0 && i<R && j<C) {
            while (input[i][j] != '#') {
                prevI = i;
                prevJ = j;
                visited.add(List.of(i, j));
                i += x;
                j += y;

                if (i >= R || i < 0 || j >= C || j < 0) {
                    return visited;
                }
            }
            //System.out.println("--------curr state");
            //Arrays.stream(input).forEach(System.out::println);
            i=prevI; j=prevJ;
            currDir = (currDir+1)%4;
            x = directions.get(currDir).get(0);
            y = directions.get(currDir).get(1);
        }

        return visited;
    }

    static boolean formsLoop(char[][] input, int[] startDir, int bi, int bj){
        input[bi][bj] = '#';
        int i=startDir[0]; int j=startDir[1];
        int x=startDir[2]; int y=startDir[3];
        int prevI = i, prevJ = j;
        int currDir = directions.indexOf(List.of(x, y));
        HashSet<List<Integer>> visited = new HashSet<>();
        while(i>0 && j>0 && i<R && j<C) {
            while (input[i][j] != '#') {
                prevI = i;
                prevJ = j;
                if(visited.contains(List.of(i, j, currDir))) {
                    Arrays.stream(input).forEach(System.out::println);
                    input[bi][bj] = '.';
                    return true;
                }
                visited.add(List.of(i, j, currDir));
                i += x;
                j += y;

                if (i >= R || i < 0 || j >= C || j < 0) {
                    input[bi][bj] = '.';
                    return false;
                }
            }
            //System.out.println("--------curr state");
            //Arrays.stream(input).forEach(System.out::println);
            i=prevI; j=prevJ;
            currDir = (currDir+1)%4;
            x = directions.get(currDir).get(0);
            y = directions.get(currDir).get(1);
        }
        input[bi][bj] = '.';
        return false;
    }

    static int[] findGuard(char[][] input){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(guardPositions.containsKey(input[i][j])) {
                    var dir = guardPositions.get(input[i][j]);
                    return new int[]{i, j, dir.get(0), dir.get(1)};
                }
            }
        }
        return null;
    }
}

