public int hammingDistance(int x, int y) {
        int ans =0; 
        int res = x^y;   
        while(res>0){  
            if((res&1)==1) ans++;   
            res = res>>1;     
        }
        return ans;
    }