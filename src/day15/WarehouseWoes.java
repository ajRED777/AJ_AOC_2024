package day15;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static Util.TxtFileProcessor.readFileLines;

public class WarehouseWoes {
    static int R;
    static Map<Character, List<Integer>> move = Map.of('^', List.of(-1,0),
            'v', List.of(1,0), '<', List.of(0,-1), '>', List.of(0,1));
    static Map<List<Integer>,Character> movesDir = Map.of(List.of(-1,0), '^',
            List.of(1,0), 'v', List.of(0,-1), '<', List.of(0,1),'>');
    public static void main(String[] args) {
        List<String> input = readFileLines(15, false);

        R = 0;
        while(!input.get(R).isBlank()){
            System.out.println(input.get(R++));
        }
        char[][] map = new char[R][input.get(0).length()];
        int startI = 0;
        int startJ = 0;

        for(int i = 0; i < R; i++){
            map[i] = input.get(i).toCharArray();
            if(input.get(i).contains("@")){
                startI = i;
                startJ = input.get(i).indexOf("@");
            }
        }
        System.out.println("startI: " + startI + " startJ: " + startJ);
        int[][] moves = new int[(input.size()-R-1)*input.get(R+1).length()][2];
        int mi = 0;
        for(int i = R+1; i < input.size(); i++){
            for(char m: input.get(i).toCharArray()){
                moves[mi++] = new int[]{move.get(m).get(0), move.get(m).get(1)};
            }
        }
        process(map, moves, startI, startJ);
        System.out.println("GPS: "+getGPS(map));

        //System.out.println(Arrays.deepToString(moves));

    }

    private static int getGPS(char[][] map) {
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 'O')
                    res+=i*100 + j;
            }
        }
        return res;
    }

    static void process(char[][] map, int[][] moves, int i, int j){
        for(int[] move : moves){
            System.out.println("moving: "+movesDir.get(List.of(move[0],move[1])));
            int x = i + move[0];
            int y = j + move[1];
            if(map[x][y] == '#'){
                Arrays.stream(map).forEach(System.out::println);
                continue;
            }
            if(map[x][y] == 'O'){
                System.out.println("moving box at: "+x+"-"+y);
                if(!moveBoxes(x, y, map, move)){
                        System.out.println("cannot move");
                    Arrays.stream(map).forEach(System.out::println);
                    continue;
                }
            }
            map[i][j] = '.';
            map[x][y] = '@';
            i = x;
            j = y;
            Arrays.stream(map).forEach(System.out::println);

        }
    }

    static boolean moveBoxes(int x, int y, char[][] map, int[] dir) {
        int i = x+dir[0], j = y+dir[1];
        System.out.println("box at x: " + x + " y: " + y);
        while(map[i][j] != '.' && map[i][j] != '#'){
            i+=dir[0];
            j+=dir[1];
        }
        System.out.println("    i: " + i + " j: " + j);
        if(map[i][j] == '.'){
            map[i][j] = 'O';
            //Arrays.stream(map).forEach(System.out::println);
            return true;
        }
        return false;
    }
}
