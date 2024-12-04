package day4;

import java.util.Arrays;
import java.util.List;

import static Util.TxtFileProcessor.readFileLines;

public class CeresSearch {
    final static char[] word = new char[]{'X','M','A','S'};
    final static int[][] dirs = new int[][]{{1,1},{1,-1},{-1,1},{1,0},{-1,-1},{0,1},{-1,0},{0,-1} };
    static int R=0;
    static int C=0;
    public static void main(String[] args) {
        List<String> input = readFileLines("src/day4/input.txt");
        System.out.println(input);
        R = input.size();
        char[][] arr = new char[R][];
        for(int i=0;i<R;i++) {
            arr[i] = input.get(i).toCharArray();
        }
        System.out.println(arr[0]);
        C = arr[0].length;
        System.out.println(countXmas(arr));


    }

    static long countXmas(char[][] input){
        long res = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(input[i][j]==word[0]){
                    System.out.println("Found x at "+i+" "+j);
                    for(int[] dir:dirs)
                        res += checkPath(input, i, j, dir[0], dir[1], 1);
                }
            }
        }
        return res;
    }

    static int checkPath(char[][] input, int i, int j, int x, int y, int wIdx){
        if(word.length==wIdx){
            System.out.println("Found xmas");
            return 1;
        }
        if(i+x>=R || j+y>=C || i+x<0 || j+y<0){
            return 0;
        }

        if(word[wIdx]!=input[i+x][j+y]){
            return 0;
        }
        return checkPath(input,i+x,j+y,x,y,wIdx+1);
    }
}
