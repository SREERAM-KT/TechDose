class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int colors[]=new int[n+1];
        Map<Integer,List<Integer>>haters=new HashMap<>();
        for(int i=0;i<dislikes.length;i++){
            if(!haters.containsKey(dislikes[i][0])){
                haters.put(dislikes[i][0],new ArrayList<Integer>());
            }
            
            if(!haters.containsKey(dislikes[i][1])){
                haters.put(dislikes[i][1],new ArrayList<Integer>());
            }
            
            haters.get(dislikes[i][0]).add(dislikes[i][1]);
            haters.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        
        
        
        for(int i=1;i<=n;i++){
            if(colors[i]==0 && !tryColor(haters,colors,1,i)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean tryColor(Map<Integer,List<Integer>>haters, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }       
        colors[node] = color; 
        List<Integer>list=haters.getOrDefault(node,new ArrayList<>());
        for (int next : list) {
            if (!tryColor(haters, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }
}