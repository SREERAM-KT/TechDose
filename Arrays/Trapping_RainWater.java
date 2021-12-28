public int trap(int[] height) {
        int totalWaterArea = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        while (leftPointer < rightPointer) {
            if (height[leftPointer] <= height[rightPointer]) { if (height[leftPointer] >= maxLeft) {
                    maxLeft = height[leftPointer];
                } else {
                    totalWaterArea += maxLeft - height[leftPointer];
                }
                leftPointer++;

            } else {
                if (height[rightPointer] >= maxRight) {
                    maxRight = height[rightPointer];
                } else {
                    totalWaterArea+=maxRight-height[rightPointer];
                }
                rightPointer--;
            }
        }
        return totalWaterArea;
    }