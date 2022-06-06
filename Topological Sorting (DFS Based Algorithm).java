import java.util.*;


public class Main {
    //First we add the edges because in directed graph we add it in only one side.
    static void addEdge(ArrayList<ArrayList<Integer>>adj,int u,int v){
        adj.get(u).add(v);


    }

    static void Dfs(ArrayList<ArrayList<Integer>>adj, int u, Stack<Integer>s,boolean visited[]) {
        visited[u] = true;
        for (int i : adj.get(u)) {
            if (visited[i] == false) {
                Dfs(adj, i, s, visited);
            }
        }

// when the call is finished we add the element in the stack
        s.push(new Integer(u));
    }
    // it starts from here 
    static void DfsRec(ArrayList<ArrayList<Integer>>adj, int V){
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++){
            visited[i] = false;

        }
        // it checks each element whether it is visited or not 
        // if not visited then we call for that element 
        Stack<Integer>s = new Stack<>();
        for(int i=0; i<V;i++){
            if(visited[i] == false ){
                Dfs(adj,i,s,visited);
            }
        }
        // at last when all the elements is added on the stack we print each element one by one.
        while (s.isEmpty() == false){
            System.out.print(s.pop()+" ");
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
       


        DfsRec(adj,V);


    }
}












