class pair{
        private int v;
        private int w;
        pair(int _v, int _w){
            v = _v;
           w = _w;
        }
        int getv(){
            return v;
        }
        int getw(){
            return w;
        }
    }
public class Main {
        void tpSort(int node, boolean visited[], Stack stack, ArrayList<ArrayList<pair>>adj){
       visited[node] = true;
       for(pair it: adj.get(node)){
           if(visited[it.getv()] == false){
               tpSort(it.getv(), visited, stack,adj);
           }
       }
       stack.add(node);
        }
        void dag(int s, ArrayList<ArrayList<pair>>adj, int n){
            Stack stack = new Stack();
            boolean visited[] = new boolean[n];
            for(int i=0; i<n; i++){
                visited[i] = false;
            }
            for(int i=0; i<n; i++){
                if(visited[i] == false){
                    tpSort(i,visited,stack, adj);
                }
            }
            int dist[] = new int[n];
            for(int i=0; i<n; i++) {
                dist[i] = Integer.MAX_VALUE;

            }
            dist[s] =0;
            while(stack.empty() == false){
                int node = (int) stack.pop();
                if(dist[node] != Integer.MAX_VALUE){
                    for(pair it : adj.get(node)){
                        if(dist[node]+ it.getw() < dist[it.getv()]){
                            dist[it.getv()] = dist[node]+ it.getw();
                        }
                    }
                }
            }
            for(int i=0; i<n; i++){
                if(dist[i] == Integer.MAX_VALUE){
                    System.out.print("INF");
                }else{
                    System.out.print(dist[i]+ " ");
                }
            }
        }


    public static void main(String[] args) {
        // write your code here
        //Scanner sc = new Scanner(System.in);
        //int t = sc.nextInt();
      //  while (t-- > 0) {
int  n =6;
ArrayList<ArrayList<pair>>adj = new ArrayList<ArrayList<pair>>();
for(int i=0; i<n; i++){
    adj.add(new ArrayList<>());
}
adj.get(0).add(new pair(1,2));
        adj.get(0).add(new pair(4,1));
        adj.get(1).add(new pair(2,3));
        adj.get(2).add(new pair(3,6));
        adj.get(4).add(new pair(5,4));
        adj.get(4).add(new pair(2,2));
        adj.get(5).add(new pair(3,1));

Main obj = new Main();

obj.dag(0,adj,n);



    }
    }
