
import java.util.*;

public class Main {
    //First we add the edges because in directed graph we add it in only one side.
    static void addEdge(ArrayList<ArrayList<Integer>>adj,int u,int v){
        adj.get(u).add(v);

    }
    // we have to store the indegree of every vertex in an array.
    static void BfSort(ArrayList<ArrayList<Integer>>adj, int V){
        int InDegree[] = new int[V];
          for(int i=0; i<V; i++) {
              for (int x : adj.get(i)) {
                  InDegree[x]++;
              }
          }
//at first we have to add the o indegree vertex in queue.
             Queue<Integer>q = new LinkedList<>();
             for(int j=0; j<V;j++){
                 if(InDegree[j]==0){
                     q.add(j);
                 }
             }
             // after printing 0 indegree vertex we decrease the indegree of its adjacent vertices by 1
             while (q.isEmpty() == false){
                int u = q.poll();
                System.out.print(u+" ");
                for(int j : adj.get(u)){
                    // after decresing if the element becomes 0 we add it in the queue and this will repeat till
                    // the last element will be printed
                    if(--InDegree[j] == 0){
                        q.add(j);
                    }
                }

                 }

          }









    public static void main(String[] args) {
        // write int visited[] your code here

        //  Scanner sc = new Scanner(System.in);
        //
        //int t = sc.nextInt();
        //while (t-- > 0) {
        // int n = sc.nextInt();
        //int k = sc.nextInt();


        // }/*
        int V = 5;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<V;i++ ){
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,0, 2);
        addEdge(adj,0, 3);
        addEdge(adj,1, 3);
        addEdge(adj,1, 4);
        addEdge(adj,2, 3);

        BfSort(adj,V);


    }
}















