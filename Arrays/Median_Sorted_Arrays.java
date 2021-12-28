public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int size = nums1.length + nums2.length;
        int[] added = new int[size];
        int count = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                added[count] = nums1[i];
                i++;
            }
            else{
                added[count] = nums2[j];
                j++;
            }
            count++;
        }
        if(i < nums1.length){
            while(i < nums1.length){
                added[count] = nums1[i];
                count++;
                i++;
            }
        }
        if(j < nums2.length){
            while(j < nums2.length){
                added[count] = nums2[j];
                count++;
                j++;
            }
        }
        double median = 0.0;
        if(size % 2 == 0){
            double total = added[size/2] + added[(size/2) - 1];
            median = total/2;
        }
        else{
            median = added[(size - 1)/2];
        }
        return median;
    }