import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

   static boolean Bfs(int node, ArrayList<ArrayList<Integer>>adj,int col[]){
       Queue<Integer>q = new LinkedList<>();
       // here we add first node to the queue
       q.add(node);
       // fill the color 0 to first node
       col[node ]=0;
       while(q.isEmpty() == false){
           int u = q.poll();
           for(int it : adj.get(u)){
               if(col[it] == -1){
                   // here we are filling opposite colors to the adjacent node
                col[it] = 1-col[it];
                // if we get the same color on the adjacent nodes then we return false
               }else if(col[it] == col[u]){
                   return false;
               }
           }
       }
       return true;
   }
   static  boolean BfsSol(ArrayList<ArrayList<Integer>>adj, int n){
       int col[] = new int[n];
       for(int i=0; i<n; i++){
           col[i] = -1;
       }
       for(int i=0; i<n; i++){
           if(col[i] == -1){
              if( Bfs(i,adj,col) == false){
                  return false;
              }
           }
       }
       return true;
   }
    public static void main(String[] args) {
        // write your code here
        //Scanner sc = new Scanner(System.in);
        //int t = sc.nextInt();
      //  while (t-- > 0) {
        int n =7;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(2).add(5);
        adj.get(5).add(2);
        adj.get(1).add(4);
        adj.get(4).add(1);

        if(BfsSol(adj,n) == true){
            System.out.println("Bipartite");
        }else{
            System.out.println("Not Bipartite");
        }











    }
    }

      //  }


