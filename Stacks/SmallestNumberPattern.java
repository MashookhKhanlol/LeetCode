package com.mashukh.Stacks;

import java.util.Stack;

public class SmallestNumberPattern {

    public static void main(String[] args) {
        String str = "ddiidi";
        pattern(str);

    }

    public static void pattern(String str){
        Stack<Integer> st = new Stack<>();

        int num =1;

        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);

            if(ch == 'd'){
                st.push(num);
                num++;
            }
            else{
                st.push(num);
                num++;
                while(st.size()> 0){
                    System.out.print(st.pop());
                }
            }

        }
        while(st.size() >0){
            System.out.print(st.pop());

        }
        System.out.print(num);
    }
}
