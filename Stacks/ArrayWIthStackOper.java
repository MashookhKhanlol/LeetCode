package com.mashukh.Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayWIthStackOper {

    public static void main(String[] args) {

    }

    public List<String> buildArray(int[] target ,int n){
        Stack<Integer> st = new Stack<>();
        List<String> str = new ArrayList<>();
        int[] arr = new int[n];

        for(int i=0; i<n;i++){
            arr[i] = i+1;
        }

        int targetIndex =0;
        int index =0;

        while(targetIndex < target.length){
            int num = arr[index];
            st.push(num);
            str.add("Push");

            if(num != target[targetIndex]){
                st.pop();
                str.add("Pop");
            }
            else{
                targetIndex++;
            }
            index++;
        }
        return str;
    }

}
