   public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        int rows = intervals.length;
        LinkedList<int[]> m = new LinkedList<>();
        for(int i=0; i<rows; ){
            int start = intervals[i][0];
            int cEnd = intervals[i][1];
            int j = i+1;
            while(j<rows && intervals[j][0] <= cEnd){
                cEnd = Math.max(intervals[j][1], cEnd);
                j++;
            } 
            if(j==i){
                i++;
            }else{
                i=j;
            }
            
            m.add(new int[]{start, cEnd});
        }
        return m.toArray(new int[m.size()][]);
    }