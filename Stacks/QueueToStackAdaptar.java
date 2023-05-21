package com.mashukh.Stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class QueueToStackAdaptar {

     Queue<Integer> mainQ = new ArrayDeque<>();
     Queue<Integer> helperQ = new ArrayDeque<>();

     int size(){
         return mainQ.size();
     }

     void push(int val){
        while(mainQ.size() > 0){
            helperQ.add(mainQ.remove());
        }

         mainQ.add(val);

        while(helperQ.size() > 0){
            mainQ.add(helperQ.remove());
        }
     }

     int pop(){
         if(mainQ.size() == 0){
             System.out.println("Stack underflow");
             return -1;
         }
         else{
             return mainQ.remove();
         }
     }

    int top(){
        if(mainQ.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        else{
            return mainQ.peek();
        }
    }
}
