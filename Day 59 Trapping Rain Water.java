// Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 




class Solution {
    public int maxWater(int arr[]) {
        // code here
        int left = 0, right = arr.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax)
                    leftMax = arr[left];
                else
                    waterTrapped += leftMax - arr[left];
                left++;
            } else {
                if (arr[right] >= rightMax)
                    rightMax = arr[right];
                else
                    waterTrapped += rightMax - arr[right];
                right--;
            }
        }
        return waterTrapped;
    }
}
