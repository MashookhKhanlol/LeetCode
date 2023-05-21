package com.mashukh.Stacks;

import java.util.Stack;

public class LargestAreaHistogram {

    public static int Histogram(int[] arr){
        int[] ans = new int[arr.length];
        int[] rb = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length -1);
        arr[arr.length -1] = arr.length;
        for(int i=arr.length -2 ; i>= 0;i--){
            while(st.size() >0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() ==0){
                rb[i] = arr.length;
            }
            else{
                rb[i] = st.peek();
            }
            st.push(i);
        }


        int[] lb = new int[arr.length];
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for(int i=1; i< arr.length ;i++){
            while(st.size() >0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() ==0){
                lb[i] = -1;
            }
            else{
                lb[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea =0;

        int ans2 =0;
        for (int i=0; i<arr.length ;i++){
            int width = rb[i] - lb[i] -1;
            int area = width * arr[i];
            if(area > maxArea){
                maxArea = area;
                ans2 =arr[i];
            }
        }

        return ans2;

    }

    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6};

        int ans = Histogram(arr);

        System.out.println(ans);
    }
}
