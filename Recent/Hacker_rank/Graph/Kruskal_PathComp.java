/*
Kruskal's algorithm with disjoin set(union by rank & path Compressoin)
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
                public int compare(int[] a1, int[] a2) {
                    if(a1[2] != a2[2]) return a1[2]-a2[2];
                    else return (a1[0]+a1[1]+a1[2]) - (a2[0]+a2[1]+a2[2]);
                }
        });
        for(int i = 0; i < m; i++) {
            pq.add(new int[]{sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()});
        }
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        long ret = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int par1, par2;
            if((par1 = find(curr[0],parent)) != (par2 = find(curr[1],parent))) {
                ret += curr[2];
                union(par1, par2, rank, parent);
            }
        }
        System.out.println(ret);
    }
    
    public static int find(int num, int[] parent) {
        while(num != parent[num]) {
            parent[num] = parent[parent[num]];
            num = parent[num];
        }
        return parent[num];
    }
    
    public static void union(int par1, int par2, int[] rank, int[] parent) {
        if(rank[par1] > rank[par2]) {
            parent[par2] = par1;
        } else if(rank[par2] > rank[par1]) {
            parent[par1] = par2;
        } else {
            parent[par2] = par1;
            rank[par1]++;
        }
    }
    
}