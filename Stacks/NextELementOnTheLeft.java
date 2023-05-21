package com.mashukh.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class NextELementOnTheLeft {

    public static int[] NEL(int[] arr){
        int[] ans = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(0);
        ans[0] =1;
        for(int i=1; i<arr.length; i++){

            while(st.size()>0 && arr[i] > arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = i+1;
            }
            else{
                ans[i] = i - st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {4,2,5,7,8,6};
        int[] ans =NEL(arr);

        for(int i=0; i<arr.length ;i++){
            System.out.print(ans[i] + " ");
        }
    }
}
