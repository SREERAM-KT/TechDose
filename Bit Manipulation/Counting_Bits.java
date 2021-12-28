public int[] countBits(int n) {
         int[]arr = new int[n+1];
         for(int i=0;i<=n;i++){
         int count=0;
         int a=i;
         while(a!=0){
            a=a&(a-1);
            count++;
         }
         arr[i]=count;
    }
    return arr;
    }