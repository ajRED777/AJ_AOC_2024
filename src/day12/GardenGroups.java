package day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static Util.TxtFileProcessor.readFileLines;

public class GardenGroups {
    static int R;
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static List[] walls = new List[4];
    public static void main(String[] args) {
        boolean isTest = false;
        String parentPath = "src/day12/";
        String filename = isTest ? parentPath + "input-test.txt" : parentPath + "input-puzzle.txt";

        List<String> input = readFileLines(filename);
        R = input.size();
        char[][] map = new char[R][R];
        boolean[][] visited = new boolean[R][R];
        for (int i = 0; i < R; i++)
            map[i] = input.get(i).toCharArray();

        System.out.println(Arrays.deepToString(map));
        long res = 0;
        long res2 = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                if (visited[i][j])
                    continue;
                System.out.println("processing " + map[i][j] + " ");
                List<Integer> p = new ArrayList<>();
                p.add(0);
                for(int k = 0; k < 4; k++)
                    walls[k] = new ArrayList<List<Integer>>();
                int area = getArea(i, j, map[i][j], p, map, visited);
                res += (long) area *p.get(0);
                System.out.println("walls: " + Arrays.toString(walls));
                int sideCount = getSideCount(walls);
                System.out.println("sides count: " + sideCount);
                System.out.println("Area " + area + " Perm:" + p.get(0));
                res2 += (long) area *sideCount;
            }


        }
        System.out.println("Cost: "+ res);
        System.out.println("Discounted Cost: "+ res2);
    }

    static int getArea(int i, int j, char c, List<Integer> perimeter, char[][] map, boolean[][] visited) {
        //System.out.println("checking i: " + i + " j: " + j );
        visited[i][j] = true;
        int area = 0;
        int e= -1;
        for (int[] dir : dirs) {
            e++;
            //System.out.println("checking dir: " + dir[0] + ", " + dir[1] );
            if ((i + dir[0]) < 0 || (j + dir[1]) < 0 || (i + dir[0]) >= R || (j + dir[1]) >= R || map[i + dir[0]][j + dir[1]] != c) {

                //System.out.println("dir: " + Arrays.toString(dir) + " adding wall: "+ List.of(i,j)+"as wall "+ e);
                walls[e].add(List.of(i,j));
                perimeter.set(0, perimeter.get(0) + 1);
                continue;
            }
            if (visited[i + dir[0]][j + dir[1]] && map[i + dir[0]][j + dir[1]] == c){
                continue;
            }
            //System.out.println("processing "+map[i][j]+" i: "+ (i+dir[0])+ " j: "+(j+dir[1]));
            int a = getArea(i + dir[0], j + dir[1], c, perimeter, map, visited);
            if (a == 0){
                walls[e].add(List.of(i,j));
                perimeter.set(0, perimeter.get(0) + 1);
            }

            area += a;
        }
        return area + 1;
    }

    static int countSides(List<List<Integer>> walls,int same, int changing){
        int sides = 0;
        while(!walls.isEmpty()){
            sides++;
            var start = walls.get(0);
            int s = start.get(same);
            int nextWall = start.get(changing);
            while(!walls.isEmpty() && walls.get(0).get(same) == s
                    && walls.get(0).get(changing) == nextWall
            ){
                walls.remove(0);
                nextWall++;
            }
        }
        return sides;
    }

    static int getSideCount(List<List<Integer>>[] walls){
        int sides = 0;
        //top
        walls[0].sort(getComparator(true));
        sides += countSides(walls[0], 0, 1);
        //down
        walls[1].sort(getComparator(true));
        sides += countSides(walls[1], 0, 1);
        //right
        walls[2].sort(getComparator(false));
        sides += countSides(walls[2], 1, 0);
        //left
        walls[3].sort(getComparator(false));
        sides += countSides(walls[3], 1, 0);
        return sides;
    }

    public static Comparator<List<Integer>> getComparator(boolean byRowFirst) {
        if(byRowFirst){
            return (l1, l2) -> {
                // Compare by the first element
                int firstComparison = Integer.compare(l1.get(0), l2.get(0));
                if (firstComparison != 0) {
                    return firstComparison;
                }
                // If first elements are equal, compare by the second element
                return Integer.compare(l1.get(1), l2.get(1));
            };
        }else{
            return (l1, l2) -> {
                // Compare by the first element
                int firstComparison = Integer.compare(l1.get(1), l2.get(1));
                if (firstComparison != 0) {
                    return firstComparison;
                }
                // If first elements are equal, compare by the second element
                return Integer.compare(l1.get(0), l2.get(0));
            };
        }

    }

}
