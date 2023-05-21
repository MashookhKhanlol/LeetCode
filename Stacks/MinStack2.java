package com.mashukh.Stacks;

import java.util.Stack;

public class MinStack2 {

    Stack<Integer> st;
    public MinStack2() {
        st = new Stack<>();
    }
    int min=0;

    int size(){
        return st.size();
    }

    public int pop(){
        if(st.size() == 0) {
            return -1;
        }
        else{
            int val = st.pop();
            if(val >= min){
                return val;
            }
            else{
                return min;
            }
        }

    }

    public int top(){
        if(st.size() == 0) {
            return -1;
        }
        else{
            if(st.peek() > min){
               st.peek();
            }
            else{
                return min;
            }
        }
        return -1;
    }

    public void push(int val){
        if(st.size() == 0){
            st.push(val);
            min = val;
        }
        else if(val >= min){
            st.push(val);
        }
        else{
            st.push(val + val -min);
            min = val;
        }

    }
}
