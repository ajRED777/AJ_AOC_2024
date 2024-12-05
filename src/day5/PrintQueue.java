package day5;

import java.util.*;

import static Util.TxtFileProcessor.readFileLines;

public class PrintQueue {
    static HashMap<Integer, List<Integer>> adj = new HashMap<>();
    static HashMap<Integer, List<Integer>> adj2 = new HashMap<>();
    public static void main(String[] args) {
        boolean isTest = false;
        String parentPath = "src/day5/";
        String filename = isTest?parentPath+"input-test.txt":parentPath+"input-puzzle.txt";
        List<String> input = readFileLines(filename);
        //System.out.println(input);
        List<String> edges = new ArrayList<>();
        int i = 0;
        while(!input.get(i).isBlank()){
            edges.add(input.get(i++));
        }
        i++;
        //System.out.println("edges" + edges);
        List<List<Integer>> pageList = new ArrayList<>();
        while(i<input.size()){
            pageList.add(Arrays.stream(input.get(i++).split(",")).map(Integer::parseInt).toList());
        }
        //System.out.println("lists"+pageList);
        constructAdj(edges);
        //System.out.println("adj:"+adj);
        //System.out.println("adj2:"+adj2);


        int orderedSum = 0;
        int unorderedSum = 0;
        for(List<Integer> l:pageList){
            if(isSorted(l)){
                orderedSum += l.get((l.size()/2));
            }else{
                unorderedSum += sumOnTopoSort(l);
            }

        }

        System.out.println("ordered Sum of ordered lists: "+ orderedSum);



        System.out.println("orderedSum of unordered lists: "+ unorderedSum);

    }

    static boolean isSorted(List<Integer> l){
        for(int j=l.size()-1; j>=1; j--){
            if(adj.get(l.get(j))==null)
                continue;
            for(int d:adj.get(l.get(j))){
                //System.out.println(">>>"+l.get(j)+" "+d+" " + l.subList(0,j-1));
                if(l.subList(0,j).contains(d))
                    return false;
            }
        }
        return true;
    }


    static void constructAdj(List<String> input){
        for(String e : input){
            //System.out.println(e);
            int p1 = Integer.parseInt(e.substring(0,2));
            int p2 = Integer.parseInt(e.substring(3,5));
            //System.out.println("p1:" + p1 + " p2:" + p2);
            adj.computeIfAbsent(p1, k -> new ArrayList<>()).add(p2);
            adj2.computeIfAbsent(p2, k -> new ArrayList<>()).add(p1);
            //System.out.println(indegree);
        }
    }

    static int sumOnTopoSort(List<Integer> input){
        //khan's algo
        //System.out.println("sumOnTopoSort on "+ input);
        var que = new ArrayDeque<Integer>();
        int[] indegree = new int[100];
        for(int num:input){
            var inEdges = adj2.get(num);
            if(inEdges==null){
                que.add(num);
            }else{
                var currInEdges = new ArrayList<>(inEdges);
                currInEdges.retainAll(input);
                if(currInEdges.isEmpty()){
                    que.add(num);
                }else {
                    indegree[num]+=currInEdges.size();
                }
            }
        }
        //System.out.println("que: "+que);
        var ordered = new ArrayList<Integer>();
        while(!que.isEmpty()){

            int r = que.pop();
            //System.out.println("processing : "+r);
            ordered.add(r);
            if(adj.get(r)==null)
                continue;
            for(var d:adj.get(r)){
                if(!input.contains(d))
                    continue;
                indegree[d]--;
                if(indegree[d] == 0) {
                    que.add(d);
                }
            }
            //System.out.println("que after : "+r+"que: "+que);
        }
        //System.out.println("ordered >>: "+ordered);
        return ordered.get(ordered.size()/2);
    }



}
