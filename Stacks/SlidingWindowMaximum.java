package com.mashukh.Stacks;

import java.util.Stack;

public class SlidingWindowMaximum {
    public static void SWM(int[] arr ,int k){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        arr[arr.length -1] = arr.length;

        st.push(arr.length -1);
        for(int i=arr.length -2;i>=0 ; i--){
            while(st.size() >0 && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                ans[i] = arr.length;
            }
            else {
                ans[i] = st.peek();
            }
            st.push(i);
        }

        int j =0;
        for(int i=0; i<=arr.length -k ;i++) {
            if (j < i) {
                j=i;
            }
            while (ans[j] < i + k) {
                j = ans[j];
            }
            System.out.print(arr[j] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};

        SWM(arr,4);
    }


}
