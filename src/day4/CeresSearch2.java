package day4;

import java.util.List;

import static Util.TxtFileProcessor.readFileLines;

public class CeresSearch2 {
    final static char[][] word = new char[][]{{'S','M','S','M'},{'M','S','M','S'},{'M','M','S','S'},{'S','S','M','M'}};
    final static int[][] dirs = new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}};
    static int R=0;
    static int C=0;
    public static void main(String[] args) {
        List<String> input = readFileLines("src/day4/input.txt");
        //System.out.println(input);
        R = input.size();
        char[][] arr = new char[R][];
        for(int i=0;i<R;i++) {
            arr[i] = input.get(i).toCharArray();
        }
        //System.out.println(arr[0]);
        C = arr[0].length;
        System.out.println(countXmas(arr));


    }

    static long countXmas(char[][] input){
        long res = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(input[i][j]=='A'){
                    //System.out.println("Found A at "+i+" "+j);

                    for(int l=0; l<4; l++) {
                        int found = 0;
                        for (int k = 0; k < 4; k++) {
                            found += isExpectedChar(input, i, j, dirs[k][0], dirs[k][1], k, word[l]) ? 1 : 0;
                        }
                        res += found==4?1:0;
                    }


                }
            }
        }
        return res;
    }

    static boolean isExpectedChar(char[][] input, int i, int j, int x, int y, int w, char[] expWord){

        if(i+x>=R || j+y>=C || i+x<0 || j+y<0){
            return false;
        }
        return expWord[w] == input[i + x][j + y];
    }
}
