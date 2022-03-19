package org.lql.examination;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/3/13 22:12
 * @description: 期末1
 */
public class ET1Main {

    /**
     *
     */
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int z;

        public Node (int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }


        @Override
        public int compareTo(Node o) {
            if (this.z == o.z){
                if (this.x + this.y == o.x + o.y){
                    return o.x - this.x;
                } else {
                    return o.x + o.y - this.x - this.y;
                }
            }
            return this.z - o.z;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] hamster = new int[n][2];
        for(int i = 0; i < n; i++){
            hamster[i][0] = scanner.nextInt();
            hamster[i][1] = scanner.nextInt();
        }

        int[][] botany = new int[m][2];
        for(int i = 0; i < m; i++){
            botany[i][0] = scanner.nextInt();
            botany[i][1] = scanner.nextInt();
        }

        Map<String, Integer> hamsterMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            String key = hamster[i][0] + "_" + hamster[i][1];
            hamsterMap.put(key, hamsterMap.getOrDefault(key,0) + 1);
        }

        Set<String> botanySet = new HashSet<>();
        for(int i = 0; i < m; i++){
            String key = botany[i][0] + "_" + botany[i][1];
            botanySet.add(key);
        }

        TreeSet<Node> set = new TreeSet<>();
        for(int i = 0; i < n; i++){
            String key = hamster[i][0] + "_" + hamster[i][1];
            int count = hamsterMap.getOrDefault(key,0);
            if(botanySet.contains(key)){
                continue;
            }
            set.add(new Node(hamster[i][0],hamster[i][1],count));
        }
        Node node = set.last();
        System.out.print(node.x + " " + node.y);
    }
}
