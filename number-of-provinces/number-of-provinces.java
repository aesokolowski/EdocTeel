class Solution {
    List<Integer>[] graph;
    int[] discovered;
    int[] lowLink;
    Deque<Integer> stack;
    boolean[] onStack;
        
    int sccCount;
    int time;
    final int UNVISITED = -1;
    
    public int findCircleNum(int[][] isConnected) {   
        init();
        return driver(isConnected);
    }
    
    private void init() {
        sccCount = 0;
        time = 0;
    }
        
    private int driver(int[][] isConnected) {
        int n= isConnected.length;

        discovered = new int[n];
        Arrays.fill(discovered, UNVISITED);
            
        lowLink = new int[n];
        Arrays.fill(lowLink, UNVISITED);
        
        stack = new ArrayDeque<>();
        onStack = new boolean[n];
            
        graph = new ArrayList[n];
            
        //convert Adjaceny matrix to adjacency list
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();     
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }
            
        for (int i = 0; i < n; i++) {
            if (discovered[i] == UNVISITED) {
                dfs(i);
            }
        }
        
        return sccCount;
    }
        
    private void dfs(int current) {
        discovered[current] = time;
        lowLink[current] = time;
        time++;
            
        stack.push(current);
        onStack[current] = true;
            
        for (int destination : graph[current]) {
            if (discovered[destination] == UNVISITED) {
                dfs(destination);
            }
                
            // on callback, check if neighbor is on stack
            if (onStack[destination]) {
                lowLink[current] = Math.min(lowLink[destination], lowLink[current]);
            }
        }
                                                
        if (discovered[current] == lowLink[current]) {
            for (int node = stack.pop(); ; node = stack.pop()) {
                onStack[node] = false;
                if (node == current) break;
            }
            
            sccCount++;
        }
    }
}