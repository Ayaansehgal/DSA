class Solution {
    static boolean dfs(int src,int des,List<List<Integer>>graph,boolean visited[]){
        if(src==des){
            return true;
        }
        visited[src]=true;
        for(int i:graph.get(src)){
            if(!visited[i]){
                if(dfs(i,des,graph,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int src, int des) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());

        }
        for(int e[]:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean visited[]=new boolean[n];
        return dfs(src,des,graph,visited);
    }
}