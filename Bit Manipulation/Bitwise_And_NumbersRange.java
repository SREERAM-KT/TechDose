public int msbPosition(int n){ 
    int msb=-1;
    while(n>0){
            n= n>>1;
             msb++;
    }
    return msb;
}
public int rangeBitwiseAnd(int left, int right) {
     int ans=0;
    while (left > 0 && right > 0) {
            int msb_left= msbPosition(left);
            int msb_right= msbPosition(right);
            if(msb_left != msb_right)
            break;  
            int val= (1<<msb_left);
            ans += val ;
            left-=val;
            right-=val;
    }
     return ans;
}