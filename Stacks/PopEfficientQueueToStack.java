package com.mashukh.Stacks;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopEfficientQueueToStack {

    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    PopEfficientQueueToStack(){
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }

    int pop(){
        while(mainQ.size()>1){
            helperQ.add(mainQ.remove());
        }
        int val = mainQ.remove();

        while(helperQ.size()> 0){
            mainQ.add(helperQ.remove());
        }

        return val;
    }

    void push(int val){
        mainQ.add(val);
    }

    int top(){
        if(mainQ.size() == 0){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            while(mainQ.size()>1){
                helperQ.add(mainQ.remove());
            }
            int val = mainQ.remove();
            helperQ.add(val);

            while(helperQ.size()> 0){
                mainQ.add(helperQ.remove());
            }

            return val;
        }
    }
}
