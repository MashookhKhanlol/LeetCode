package com.mashukh.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MInStack {
        public static class MinStack{
            Stack<Integer> alldata;
            Stack<Integer> minData;

            public MinStack() {
                alldata = new Stack<>();
                minData = new Stack<>();
            }


            int size(){
                return alldata.size();
            }

            void push(int val){
                alldata.push(val);

                if(minData.size() == 0 || minData.peek() > val){
                    minData.push(val);
                }
            }

            int min(){
                if(minData.size() ==0){
                    System.out.println("Stack underflow");
                    return -1;
                }else{
                    return minData.peek();
                }
            }

            int pop(){
                if(minData.size() ==0){
                    System.out.println("Stack underflow");
                    return -1;
                }else{
                    int val = alldata.pop();
                    if(minData.peek() == val){
                        minData.pop();
                    }
                    return val;
                }
            }

            int top(){
                if(minData.size() ==0){
                    System.out.println("Stack underflow");
                    return -1;
                }else{
                    return alldata.peek();
                }
            }
        }

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(2);
        ms.push(1);
        ms.push(8);
        ms.push(8);
        System.out.println(ms.top());

    }



}
