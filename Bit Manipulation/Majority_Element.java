public int majorityElement(int[] nums){
        int half=nums.length/2;
        int major=0;
        for(int i=0;i<32;i++){
            int ones=0;
            for(int num:nums){
                ones+=(num>>i)&1;
            }
            if(ones>half){
                major+=1<<i;
            }
        }
        return major;
    }