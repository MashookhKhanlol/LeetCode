package com.mashukh.Stacks;

import com.mashukh.OOPs.MethodOverloading.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;


public class NextGreaterElement {
    public static int[] NGE(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        st.push(arr[arr.length -1]);
        ans[arr.length-1] = -1;
        for(int i=arr.length -2; i>= 0; i--){
            while(st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }
            if(st.size() ==0){
                ans[i] =-1;
            }
            else {
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> al = new ArrayList<>();

        int[] arr = {4,2,5,7,8,6};
        int[] ans =NGE(arr);

        for(int i=0; i<arr.length ;i++){
            System.out.print(ans[i] + " ");
        }


     }


}
