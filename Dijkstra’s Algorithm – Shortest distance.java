
import java.util.*;
// we use comparator to take the element first which has minimum weight from the priority queue
class Node implements Comparator<Node>{
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
@Override
 public int compare(Node a, Node b)
 {
     // we use this comparator to sort in ascending order
    return a.w - b.w;
 }

}

 class Main {
    static void MinDistance(int s, ArrayList<ArrayList<Node>>adj, int N){
        int dist[] = new int[N];
// created a dist array to store the distance of each element of the array from the source to it
        for(int i=0; i<N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        // at starting we store infinite value to the array
        // we make the distance of source 0.
        dist[s] =0;
        // we created priority queue which will contain node and its respected weight.
        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
        // at first we add the first element to it (i.e its source element and its distance)
        pq.add(new Node(s,0));
        while(pq.size()>0){
            Node node = pq.poll();
            // we call all the neighbours of the node if the current distance is larger then we update the current distance
            // so that we have to take the minimum distance.
            for( Node it: adj.get(node.getV())){
                if(dist[node.getV()] + it.getW() < dist[it.getV()]){
                    dist[it.getV()] = it.getW() + dist[node.getV()];
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }

            }
        }
        for(int i=0; i<N; i++) {
            System.out.print(dist[i] +" ");
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

        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));

        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));

        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));

        MinDistance(0,adj,n);










    }
    }




