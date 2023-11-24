package com.yt.november;

public class NumArray_307 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(0, 2);
        System.out.println(numArray.sumRange(1, 2));
    }


}


class NumArray {
    public int[] nums;
    public int sum;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        if(index >= 0 && index < nums.length) {
            this.nums[index] = val;
        }
    }

    public int sumRange(int left, int right) {
        sum = 0;
        int i = left, j = right;
        while(i <= j) {
            sum = sum + nums[i] + nums[j];
            if(i == j) {
                sum -= nums[j];
            }
            i++;
            j--;
        }
//        if(left >=0 && left < nums.length && right >= 0 && right < nums.length) {
//            for(;left <= right;left++) {
//                sum += nums[left];
//            }
//        }
        return sum;
    }
}