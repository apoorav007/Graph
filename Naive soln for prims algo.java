import java.util.*;

class Node {
private  int v;
private  int w;
Node(int _v, int _w) {
    v = _v;
    w = _w;
}
    Node() {}

 int getV(){
    return v;
 }
 int getW() {
     return w;
 }

}

 class Main {
    static void Prims( ArrayList<ArrayList<Node>>adj, int N) {
        int key[] = new int[N];
        boolean a[] = new boolean[N];
        int b[] = new int[N];
        for(int i=0; i<N;i++){
            key[i] =Integer.MAX_VALUE;
            a[i] = false;
            b[i] = -1;
        }
        //distance of the first element or source element should be 0
        key[0] =0;
        // we have to traverse through the n-1 edges of the graph


        for(int i=0; i<N-1; i++){
            int x = Integer.MAX_VALUE, u=0;
            for(int j=0; j<N; j++ ){
                //this is for checking the minimum distance in key array
                if(a[i] == false && key[i]<x){
                    x = key[i];
                    u = i;
                }
            }
            a[u] = true;
// after getting the minimum distance in key array we call the adjacent node of the node having minimum dist
            for(Node it : adj.get(u)){
                // checking if the adjacent node is visited then we not update its dist.
                if(a[it.getV()]== false && it.getW() <key[it.getV()] ){
                    // here we update the parent
                    b[it.getV()] = u;
                    key[it.getV() ] = it.getW();
                }

            }
        }
        for(int i=1; i<N; i++){
            System.out.print(b[i] +" ");
        }


    }


    public static void main(String[] args) {
        // write your code here
        int n =5;
        ArrayList<ArrayList<Node>>adj = new ArrayList<ArrayList<Node>>();
        for (int i=0; i<n; i++){
            adj.add(new ArrayList<Node>());
        }
        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));


Prims(adj,n);


