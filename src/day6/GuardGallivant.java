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
        guardTraversal(arr, dir);
        //Arrays.stream(arr).forEach(System.out::println);
        System.out.println("sum of X path:"+countPath(arr));


    }

    static int countPath(char[][] arr){
        int sum = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]=='X') {
                    sum++;
                }
            }
        }
        return sum;
    }

    static void guardTraversal(char[][] input, int[] startDir){
        int i=startDir[0]; int j=startDir[1];
        int x=startDir[2]; int y=startDir[3];
        int prevI = i, prevJ = j;
        int currDir = directions.indexOf(List.of(x, y));
        while(i>0 && j>0 && i<R && j<C) {
            while (input[i][j] != '#') {
                prevI = i;
                prevJ = j;
                input[i][j] = 'X';
                i += x;
                j += y;

                if (i >= R || i < 0 || j >= C || j < 0) {
                    return;
                }
            }
            //System.out.println("--------curr state");
            //Arrays.stream(input).forEach(System.out::println);
            i=prevI; j=prevJ;
            currDir = (currDir+1)%4;
            x = directions.get(currDir).get(0);
            y = directions.get(currDir).get(1);
        }
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

